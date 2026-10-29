import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class GestionnaireBibliotheque {


    //attributs privés
    //contient l’ensemble des utilisateurs enregistrés dans le système ,cle = Interger(identifiant), valeur = Utilisateur,variable = utilisateur
    private Map<Integer, Utilisateur> utilisateurs;
    //contient les utilisateurs actuellement connectés au système cle = Interger(identifiant connexion), valeur = Utilisateur,variable = utilisateur authentifie
    private Map<Integer, Utilisateur> utilisateursAuthentifies;
    //la liste des livres + fonctionalite rechercher, afficher, emprunter et réserver les livres
    private ListeLivres livres;
    //ensemble des réservations en attente stockées dans une file de priorité( professeur puis  personnel puis étudiant, puis ordre d’arrivée)
    private FilePrioriteReservations reservationsEnAttente;

    public Map<Integer, Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
    public Map<Integer, Utilisateur> getUtilisateursAuthentifies() {
        return utilisateursAuthentifies;
    }
    public ListeLivres getLivres() {
        return livres;
    }
    public FilePrioriteReservations getReservationsEnAttente() {
        return reservationsEnAttente;
    }
    public void setUtilisateurs(Map<Integer, Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
    public void setUtilisateursAuthentifies(Map<Integer, Utilisateur> utilisateursAuthentifies) {
        this.utilisateursAuthentifies = utilisateursAuthentifies;
    }
    public void setLivres(ListeLivres livres) {
        this.livres = livres;
    }
    public void setReservationsEnAttente(FilePrioriteReservations reservationsEnAttente) {
        this.reservationsEnAttente = reservationsEnAttente;
    }



    //methode principale
    public String traiterCommande(int idConnexion, String typeCommande, String argument) {
        String reponse = "";
        //identifier la commande reçue,
        // appeller methode appropriee selon le type de commande recu
        //swich case semble meilleur choix ici

        //Pour chaque commande reçue, la methode retourne une réponse permettant d’indiquer si la commande a été traitée avec succès ou si une erreur est survenue.


        switch(typeCommande){
            case "ID" :
                reponse = traiterID(idConnexion,argument); //ex1
                return reponse ;

            case "BOOKS" :
                reponse = traiterBOOKS(); //ex2
                return reponse ;

            case "BORROW":
                reponse = traiterBORROW(idConnexion,argument);//ex3
                return reponse ;

            case "RETURN" :
                reponse = traiterRETURN(idConnexion,argument);//ex4
                return reponse ;

            case "RESERVE":
                reponse = traiterRESERVE(idConnexion,argument); //ex5
                return reponse ;

            case "INFO":
                reponse = traiterINFO(idConnexion,argument); //ex6
                return reponse ;

            case "PENALTY" :
                reponse = traiterPENALTY(idConnexion,argument);//ex7
                return reponse ;

            case "REGISTER":
                reponse = traiterREGISTER(argument);//ex8
                return reponse ;

            case "EXIT" :
                reponse = traiterEXIT(idConnexion);//ex9
                return reponse ;




        }
        return reponse ;
    }



    //ex1: traitement de la commande ID
    public String traiterID(int idConnexion, String argument){ //ex:  id connexion = 2 , argument = <id utilisateur> = 102>
        //Si l’identifiant reçu est invalide ou si aucun utilisateur ne correspond à cet identifiant, elle retourne BAD_ARGUMENT_ERROR.
        int idUtilisateur;
        try {
            idUtilisateur = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            return "BAD_ARGUMENT_ERROR";
        }

        //idUtilisateur = Integer.parseInt(argument);//récupèrer l argument et convertir son type a int
        String errorTraitement;

        //vérifier l’identifiant reçu est valide
        //Je verifier si elle interger?
        if(idConnexion <= 0 ){ //dConnexion instanceof Integer
            return  "BAD_ARGUMENT_ERROR" ;
        }

        //vérifier que utilisateur existe dans la liste des utilisateurs enregistrés
        else if(utilisateurs.containsKey(idUtilisateur)){

        }

        //Si l’identifiant reçu est invalide ou si aucun utilisateur ne correspond à cet identifiant, elle retourne BAD_ARGUMENT_ERROR.
        else{
            errorTraitement="BAD_ARGUMENT_ERROR";
            return errorTraitement;
        }



        //verifier que utilisateur pas déjà authentifié avec la connexion courante
        if(utilisateursAuthentifies.containsKey(idConnexion)){
        //Si la connexion courante est déjà associée à un utilisateur authentifié, elle retourne ALREADY_AUTHENTIFIED_ERROR.
            errorTraitement="ALREADY_AUTHENTIFIED_ERROR";
            return errorTraitement;

        }


        //verifier que utilisateur n’est pas déjà connecté à partir d’un autre client.
        //(Integer= id de connexion vs getId() = id d utilisateur,
        //pas besoin on prend l argument Utilisateur utilisateur_connecte = this.utilisateur.get(idConnexion);
        //chercher si l utilisateur existe déjà

        for(Utilisateur utilisateurConnecte : this.utilisateursAuthentifies.values()){

            if(idUtilisateur == utilisateurConnecte.getId() ){
                errorTraitement="TOO_MANY_CONNECTIONS_ERROR";
                return errorTraitement;
            }
        }



        //Si toutes les vérifications sont respectées
        //assosier l utilisateur à la connexion courante

        Utilisateur utilisateurTrouve = utilisateurs.get(idUtilisateur);//creer un utilisateur selon l ID d utilisateur, il cherche directement avec l id  pas besoin de boucle

        //ajouter l utilisateur à la liste des utilisateurs authentifiés
        utilisateursAuthentifies.put(idConnexion,utilisateurTrouve );

        //returne AUTHORIZED  <id utilisateur> <nom  utilisateur>
        return "AUTHORIZED" + "<" + utilisateurTrouve.getId() + ">"+"<"+ utilisateurTrouve.getNom() +">";

    }

    //Ex2 traitement de la commande BOOKS
    //retourner la liste des livres présents dans la bibliothèque à partir de la commande BOOKS
    public String traiterBOOKS() {
        ArrayList<String> listeLivreReponse = new ArrayList<>();
        String reponse = "";

        String nbLivres = "";
        String idLivre = "";
        String titre = "";
        String auteur = "";
        String categorie = "";
        String statut = "";

        //recupere le nombre des livres et convertir en string

        nbLivres = ""+ this.livres.taille();
        reponse = "BOOKS"+" "+ nbLivres + " " ;
        listeLivreReponse.add(reponse);

        //parcourir la liste des livres de la bibliothèque
        for (Livre livreDansListe : this.livres){

        //récupérer les informations de chaque livre  et convertir en string
            idLivre = "" + livreDansListe.getId();
            titre = " " + livreDansListe.getTitre();
            auteur = " " + livreDansListe.getAuteur();
            categorie = " " + livreDansListe.getCategorie();
            statut = " " + livreDansListe.getStatut();

        // format BOOKS <nb livres> {<id livre> <titre> <auteur> <categorie> <statut>}+;
            reponse += "{" + idLivre + titre + auteur  + categorie  + statut + "}";
            //listeLivreReponse.add(reponse);

        }

        //Exemple de réponse possible : BOOKS 2 {1 Java Deitel Informatique DISPONIBLE} {2 CleanCode Martin Informatique EMPRUNTE}
        //delete --> return ""+listeLivreReponse;
        return ""+reponse;

    }

    //Ex3 traitement de la commande BORROW
    //permet à un utilisateur authentifié d’emprunter un livre disponible à l’aide de la commande BORROW <id livre> <jour>
    public String traiterBORROW(int idConnexion, String argument) {  //ex:  id connexion = 2 , argument = <id livre> <jour>
    //verification si les arguments recus sont invalides

        //if(idConnexion > 0 &&  argument != null ){ //idConnexion  instanceof Integer &&  argument instanceof String

       // }
        //Si les arguments reçus sont invalides, elle retourne BAD_ARGUMENT_ERROR.
       // else{
       //     return "BAD_ARGUMENT_ERROR";
       // }
        int idLivre;
        int jour;
        try {
            String[] argumentSeparer = argument.split(" "); //recuperer et separer l argument pour pouvoir le convertir
            idLivre = Integer.parseInt(argumentSeparer[0]); //recuperer l id de jour et convertir en int
            jour = Integer.parseInt(argumentSeparer[1]); //recuperer le nombre des jour et convertir en int
        }
        catch (NumberFormatException e) {
            return "BAD_ARGUMENT_ERROR";
        }
        if(idLivre > 0){

        }
        else{
            return "BAD_ARGUMENT_ERROR";
        }

        //vérifier que l’utilisateur est authentifié
        if(utilisateursAuthentifies.containsKey(idConnexion)){

        }

        //si l’utilisateur n’est pas authentifié, elle retourne AUTHENTICATION_ERROR.
        else{
            return "AUTHENTICATION_ERROR" ;
        }


        //vérifier que le livre demandé existe
        if(livres.contient(idLivre)){

        }

        //Si le livre demandé n’existe pas, elle retourne BOOK_NOT_FOUND_ERROR.
        else{
            return "BOOK_NOT_FOUND_ERROR";
        }

        //vérifier que le statut de livre est DISPONIBLE
        Livre livreTrouve = livres.rechercher(idLivre); //touve le livre dans la liste selon son id
        //if( livreTrouve.getStatut().equals("DISPONIBLE")){
        if( livreTrouve.getStatut() == StatutLivre.DISPONIBLE){ //verifier le type de livre trouve …. je ne sait pas si ca va marche avec == StatutLivre.DISPONIBLE

        }
        //Si le livre n’est pas disponible pour l’emprunt, elle retourne BOOK_NOT_AVAILABLE_ERROR.
        else{
            return "BOOK_NOT_AVAILABLE_ERROR";
        }

        //vérifier que utilisateur n’a pas atteint le nombre maximal d’emprunts autorisé pour son type
        Utilisateur utilisateurConnecte = this.utilisateursAuthentifies.get(idConnexion);//creer un utilisateur selon l ID de connexion,il cherche directement avec l id de connextion ,donc pas besoin de boucle
        if(utilisateurConnecte.peutEmprunter()){ //supprimer ici->utilisateurConnecte.nombreMaxEmprunts()<jour

        }

    //Si l’utilisateur a atteint sa limite d’emprunts, elle retourne BORROW_LIMIT_ERROR
        else{
            return "BORROW_LIMIT_ERROR";
        }

        //Si toutes les validations sont respectées
        //1-créer l’objet Emprunt
        Emprunt emprunt = new Emprunt(livreTrouve, utilisateurConnecte.getId(), jour); //(live,id utilisaeur,jour emprunt,jour prevu du retour de dure max d emprunt)

        //2-ajouter object Emprunt à la liste des emprunts en cours de l’utilisateur
        utilisateurConnecte.ajouterEmpruntEnCours(emprunt);

        //3-modifier le statut du livre à EMPRUNTE
        livreTrouve.setStatut(StatutLivre.EMPRUNTE);



        //4-retourner la réponse BORROW_OK <id emprunt> <id livre> <jour retour prévu>.
        String reponse = "BORROW_OK"+" <"+emprunt.getId()+">"+" <"+livreTrouve.getId() +">" + " <"+emprunt.getJourRetourPrevu()+">";
        return reponse ;

    }



    //ex4
    //permet à un utilisateur authentifié de retourner un livre emprunté à l’aide de la commande RETURN <id emprunt> <jour>  ex :RETURN 12 45 = utilisateur retourne l’emprunt ayant l’identifiant 12 au jour 45.
    public String traiterRETURN(int idConnexion, String argument) {//ex:  id connexion = 2 , argument = <id emprunt> <jour>

    ////-------------------------------------code copie coller de methode percedante-------------------------------------////
    //verification si les arguments recus sont invalides

        //if(idConnexion  > 0 &&  argument != null ){ //idConnexion  instanceof Integer &&  argument instanceof String

       // }
        //Si les arguments reçus sont invalides, elle retourne BAD_ARGUMENT_ERROR.
       // else{
       //     return "BAD_ARGUMENT_ERROR";
       // }

        int idEmprunt;
        int jour;
        try {
            String[ ] argumentSeparer = argument.split(" "); //recuperer et separer l argument pour pouvoir le convertir
            idEmprunt = Integer.parseInt(argumentSeparer[0]); //recuperer l id d emprunt et convertir en int
            jour=  Integer.parseInt(argumentSeparer[1]); //recuperer le nombre des jour et convertir en int
        }
        catch (NumberFormatException e) {
            return "BAD_ARGUMENT_ERROR";
        }
        if(idEmprunt>0 || jour>0){

        }
        else{
            return "BAD_ARGUMENT_ERROR";
        }


        //vérifier que l’utilisateur est authentifié
        if(utilisateursAuthentifies.containsKey(idConnexion)){
        }
        //si l’utilisateur n’est pas authentifié, elle retourne AUTHENTICATION_ERROR.
        else{
            return "AUTHENTICATION_ERROR" ;

        }

////-------------------------------------code unique-------------------------------------////

        //vérifier que le emprunt indiqué existe bien dans la liste de ses emprunts en cours
        Utilisateur utilisateurConnecte = this.utilisateursAuthentifies.get(idConnexion);//creer un utilisateur selon l ID de connexion,il cherche directement avec l id de connextion ,donc pas besoin de boucle
        if(utilisateurConnecte.rechercherEmpruntEnCours(idEmprunt)== null){
        //Si l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté, elle retourne BAD_BORROW_ERROR.
            return "BAD_BORROW_ERROR.";
        }

        //Si ces validations sont respectées,
        //l’emprunt doit être retourné

        Emprunt empruntEnCour = utilisateurConnecte.rechercherEmpruntEnCours(idEmprunt);
        //mis a jour statut   //EN_COURS --> RETOURNE
        empruntEnCour.setStatut(StatutEmprunt.RETOURNE);

        //déplacé l emprunt de la liste des emprunts en cours vers la liste des emprunts terminés.
        Emprunt empruntSupprimer = utilisateurConnecte.supprimerEmpruntEnCours(idEmprunt);
        utilisateurConnecte.ajouterEmpruntTermine(empruntSupprimer);
      //  Emprunt  empruntTermine =  utilisateurConnecte.rechercherEmpruntEnCours(idEmprunt);
        Emprunt  empruntTermine =  empruntSupprimer;

        //Après le retour du livre ,vérifier s’il existe une réservation en attente pour ce livre
        Reservation reservationPrioritaire = reservationsEnAttente.retirerPourLivre(empruntTermine.getLivre().getId());

        //if(utilisateurConnecte.possedeReservationEnAttentePourLivre(empruntTermine.getLivre().getId())){

        //}

        //Si aucune réservation n’existe, le livre redevient DISPONIBLE
        if(reservationPrioritaire == null){
            empruntSupprimer.getLivre().setStatut(StatutLivre.DISPONIBLE);
        //retourne RETURN_OK <id emprunt> <id livre>.
            String reponse = "RETURN_OK"+"<"+ empruntTermine.getId()+">"+"<" + empruntTermine.getLivre().getId()+">" ;
            return reponse ;

        }

        //Si une réservation prioritaire existe pour ce livre  elle doit être retirée de la file des réservations en attente,
        // changer statut RETOURNE-->ATTRIBUEE
        reservationPrioritaire.setStatut(StatutReservation.ATTRIBUEE);//empruntTermine.getLivre().setStatut(StatutEmprunt.ATTRIBUEE);
        //si attribuee donc livere sera automatiquement EMPRUNTE pour cette reservation
        empruntTermine.getLivre().setStatut(StatutLivre.EMPRUNTE);

        //trouve et recupere l utilisateur prioritaire de la reservation si elle existe
        int utilisateurPrioritaireId = reservationPrioritaire.getIdUtilisateur();
        Utilisateur utilisateurPrioriaire = this.utilisateurs.get(utilisateurPrioritaireId);
        if(utilisateurPrioriaire == null){
            return "BAD_BORROW_ERROR.";
        }
        //puis un nouvel emprunt doit être créé automatiquement pour l’utilisateur prioritaire.
        Emprunt empruntNouvel = new Emprunt(empruntTermine.getLivre(), utilisateurPrioritaireId, jour); //doit utiliser le jour du retour comme jour d’emprunt
        //ajouté l emprunt nouvel aux emprunts en cours de cet utilisateur
        utilisateurPrioriaire.ajouterEmpruntEnCours(empruntNouvel);
        //retourne uniquement RESERVATION_ASSIGNED <id emprunt> <id livre>.

        String reponse = "RESERVATION_ASSIGNED"+"<"+ empruntNouvel.getId()+">"+"<" + empruntNouvel.getLivre().getId()+">" ;
        return reponse ;



    }

    //Ex5 traitement de la commande RESERVE permet à un utilisateur authentifié de réserver un livre qui n’est pas disponible à l’aide de la commande RESERVE<id livre> . commande RESERVE 8 = réserver le livre ayant l’identifiant 8.

    public String traiterRESERVE(int idConnexion, String argument) { //ex:  id connexion = 2 , argument = <id livre>
////-------------------------------------code copie coller de methode percedante ordre different-------------------------------------////
        //vérifier que l’utilisateur est authentifié
        if(utilisateursAuthentifies.containsKey(idConnexion)){

        }
        //si l’utilisateur n’est pas authentifié, elle retourne AUTHENTICATION_ERROR.
        else{
            return "AUTHENTICATION_ERROR" ;
        }

        //verification si les arguments recus sont invalides
       // if(idConnexion  > 0 &&  argument != null){ //idConnexion  instanceof Integer &&  argument instanceof String

      //  }

        //Si les arguments reçus sont invalides, elle retourne BAD_ARGUMENT_ERROR.
      //  else{
      //      return "BAD_ARGUMENT_ERROR";
       // }
        int idLivre;
        try{
            idLivre =  Integer.parseInt(argument); //recuperer l id d livreet convertir en int

        }
        catch (NumberFormatException e){
            return "BAD_ARGUMENT_ERROR";
        }

        if(idLivre>0){

        }
        else{
            return "BAD_ARGUMENT_ERROR";
        }

       // int idLivre =  Integer.parseInt(argument); //recuperer l id d livreet convertir en int


        //copie de ex3
        //vérifier que le livre demandé existe
        if(livres.contient(idLivre)){
            Livre livreTrouve =  livres.rechercher(idLivre); //get(idLivre);
        }
        else {
      //Si le livre demandé n’existe pas, elle retourne BOOK_NOT_FOUND_ERROR.
            return "BOOK_NOT_FOUND_ERROR";
        }

////-------------------------------------code unique-------------------------------------////

        //vérifier que le livre n’est pas disponible (Statut != DISPONIBLE)
        Livre livreTrouve = livres.rechercher(idLivre); //touve le livre dans la liste selon son id
        //if( !livreTrouve.getStatut().equals("DISPONIBLE")){ //verifier le type de livre trouve …. je ne sait pas si ca va marche avec == StatutLivre.DISPONIBLE
        if(livreTrouve.getStatut() != StatutLivre.DISPONIBLE){ //verifier le type de livre trouve …. je ne sait pas si ca va marche avec == StatutLivre.DISPONIBLE

            }

        //Si le livre est déjà disponible, elle retourne BOOK_ALREADY_AVAILABLE_ERROR.
        else{
            return "BOOK_ALREADY_AVAILABLE_ERROR";
        }

        //vérifier que l’utilisateur n’a pas atteint sa limite maximale de réservations
        Utilisateur utilisateurConnecte = this.utilisateursAuthentifies.get(idConnexion);
        //Si l’utilisateur a atteint sa limite de réservations, elle retourne RESERVATION_LIMIT_ERROR.
        //vérifier que l’utilisateur ne possède pas déjà une réservation en attente pour ce même livre.
        if(utilisateurConnecte.possedeReservationEnAttentePourLivre(idLivre)){
            ///Si l’utilisateur possède déjà une réservation en attente pour ce livre, elle retourne BAD_ARGUMENT_ERROR.
            return "BAD_ARGUMENT_ERROR";
        }

        else{}

        if(utilisateurConnecte.getReservation().taille() >= utilisateurConnecte.getMAX_RESERVATIONS()){

            return "RESERVATION_LIMIT_ERROR";

        }

        else{}



        //Si toutes les validations sont respectées
        //créer l’objet Reservation correspondant

        Reservation reservation =  new Reservation(livreTrouve,utilisateurConnecte.getId(),utilisateurConnecte.getTypeUtilisateur());//statue = EN_ATTENTE





        //ajouter objet Reservation aux réservations de l’utilisateur,
        boolean succes =utilisateurConnecte.ajouterReservation(reservation);
        if(succes==false){
            return "RESERVATION_LIMIT_ERROR";
        }
        //ajouter objet Reservation à la file de priorité des réservations
        reservationsEnAttente.ajouter(reservation);

        //modifier le statut du livre à RESERVE.
        livreTrouve.setStatut(StatutLivre.RESERVE);

        //En cas de succès, la méthode retourne RESERVATION_OK <id reservation> <id livre>.
        //if(succes == true){
        String reponse = "RESERVATION_OK"+"<"+ reservation.getId()+">"+"<" + livreTrouve.getId()+">" ;
        return reponse ;

//}

    }

    //ex6

    //permet à un utilisateur authentifié de consulter ses emprunts en cours à l’aide de la commande INFO.
    //Cas 1 : commande INFO = afficher tous les emprunts en cours de l’utilisateur connecté
    //Cas 2 : commande INFO <id emprunt>  = afficher les informations d’un emprunt en cours précis.
    public String traiterINFO(int idConnexion, String argument){ //ex:  id connexion = 2 , argument = <id emprunt> ou null ou ""

////-------------------------------------code copie coller de methode percedante -------------------------------------////
        //vérifier que l’utilisateur est authentifié
        if(utilisateursAuthentifies.containsKey(idConnexion)){

        }

        //si l’utilisateur n’est pas authentifié, elle retourne AUTHENTICATION_ERROR.
        else{
            return "AUTHENTICATION_ERROR" ;
        }

        //verification si les arguments recus sont invalides
        if(argument == null){ //idConnexion  instanceof Integer &&  argument instanceof String
            argument = "";
        }
        int empruntId=0;
        //Si les arguments reçus sont invalides, elle retourne BAD_ARGUMENT_ERROR.
        if(!argument.isEmpty()){
            try{
                empruntId = Integer.parseInt(argument);//verifier c est nombre
                if( empruntId <= 0 ){
                    return "BAD_ARGUMENT_ERROR";
                }
            }

            catch(NumberFormatException e){
                return "BAD_ARGUMENT_ERROR";
            }
        }




      //  int idLivre =  Integer.parseInt(argument); //recuperer l id d lemprunt et convertir en int


        //code copier de ex4
        Utilisateur utilisateurConnecte = this.utilisateursAuthentifies.get(idConnexion);//creer un utilisateur selon l ID de connexion,il cherche directement avec l id de connextion ,donc pas besoin de boucle

////-------------------------------------code unique-------------------------------------////

        int idEmprunt= 0;
        ArrayList<String> listeEmpruntReponse = new ArrayList<>();
        String reponse = "";
        String nbEmprunts = "";
        String idEmpruntChaine = "";
        String idLivreChaine = "";
        String jourEmprunt = "";
        String jourRetourPrevu = "" ;
        String statut= "";


        //case 1 sans argument
        //déterminer si un identifiant d’emprunt n a pas été fourni
        if(argument.isEmpty()) { //|| idEmprunt == null si ecrire sous fome  idEmprunt.equlas("") ca va  va planter?
            //Cas1  commande INFO, la méthode doit retourner une réponse de la forme: INFO <nb emprunts> {<id emprunt> <id livre> <jour emprunt> <jour retour prévu> <statut>}+.
            //ex:INFO 2 {1 5 10 50 EN_COURS} {2 3 12 52 EN_COURS}
            //à partir des emprunts en cours de l’utilisateur.
            //recuperer la liste des emprunt en cours de l utilisateur
            ListeEmprunts listeEmprunts = utilisateurConnecte.getEmpruntsEnCours();
            //recupere le nb des empunt dans liste et convertir en String
            nbEmprunts = "" + listeEmprunts.taille();
            reponse = "INFO" + " " + nbEmprunts ;
           // listeEmpruntReponse.add(reponse);


            //Parcourir la liste des emprunt
            for (Emprunt emprunt : listeEmprunts) {
                //recupee les info de chaque emprunt et convertir en string
                idEmpruntChaine = "" + emprunt.getId();
                idLivreChaine = " " + emprunt.getLivre().getId();
                jourEmprunt = " " + emprunt.getJourEmprunt();
                jourRetourPrevu = " " + emprunt.getJourRetourPrevu();
                statut = " " + emprunt.getStatut();

                //forme: INFO <nb emprunts> {<id emprunt> <id livre> <jour emprunt> <jour retour prévu> <statut>}+
                //ex:INFO 2 {1 5 10 50 EN_COURS} {2 3 12 52 EN_COURS}
                reponse += "{" + idEmpruntChaine + idLivreChaine + jourEmprunt + jourRetourPrevu + statut + "}";
                //listeEmpruntReponse.add(reponse);


            }
            return reponse;
        }
        //Cas2 avec argument
         idEmprunt= Integer.parseInt(argument); //recuperer l id d emprunt et convertir en int
        //rechercher l’emprunt demandé uniquement parmi les emprunts en cours de l’utilisateur connecté
        Emprunt emprunt = utilisateurConnecte.rechercherEmpruntEnCours(idEmprunt);
        //Si l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté, elle retourne BAD_BORROW_ERROR.
        if(emprunt == null){
            return "BAD_BORROW_ERROR.";
        }


        //Si l’emprunt est trouvé, elle retourne une réponse contenant un seul emprunt
        // format: INFO 1 {<id emprunt> <id livre> <jour emprunt>  <jour retour prévu> <statut>}.
        //Exemple : INFO 1 {12 5 10 50 EN_COURS}

        nbEmprunts = "1"; // car une seul emprunt specifique
        reponse = "INFO"+" " + nbEmprunts +" "   ;
        //listeEmpruntReponse.add(reponse);


        //recupee les info de l emprunt et convertir en string

        idEmpruntChaine = ""+emprunt.getId();
        idLivreChaine = " "+ emprunt.getLivre().getId();
        jourEmprunt = " "+emprunt.getJourEmprunt();
        jourRetourPrevu = " " +emprunt.getJourRetourPrevu();
        statut= " "+emprunt.getStatut();
        reponse += "{" + idEmpruntChaine + idLivreChaine + jourEmprunt + jourRetourPrevu + statut + "}";






        return reponse;
        }


    //ex7
    //permet à un utilisateur authentifié de consulter la pénalité associée à l’un de ses  emprunts à l’aide de la commande PENALTY <id emprunt> <jour actuel>
    // EX PENALTY 15 52 = calculer la pénalité de l’emprunt ayant l’identifiant 15 au jour 52.
    public String traiterPENALTY(int idConnexion, String argument) { //ex:  id connexion = 2 , argument = <id emprunt>  <jour>
////-------------------------------------code copie coller de methode percedante -------------------------------------////
    //vérifier que l’utilisateur est authentifié
        if(utilisateursAuthentifies.containsKey(idConnexion)){

        }

    //si l’utilisateur n’est pas authentifié, elle retourne AUTHENTICATION_ERROR.
        else{
            return "AUTHENTICATION_ERROR" ;
        }
        //verification si les arguments recus sont invalides
      //  if(idConnexion  > 0 &&  argument != null ){//idConnexion  instanceof Integer &&  argument instanceof String
     //   }
        //Si les arguments reçus sont invalides, elle retourne BAD_ARGUMENT_ERROR.
     //   else{
           // return "BAD_ARGUMENT_ERROR";
    //    }

        //code copier de ex4 + jourActuel
        int idEmprunt;
        int jourActuel;
        try {
            String[] argumentSeparer = argument.split(" "); //recuperer et separer l argument pour pouvoir le convertir
            idEmprunt = Integer.parseInt(argumentSeparer[0]); //recuperer l id d emprunt et convertir en int
            jourActuel = Integer.parseInt(argumentSeparer[1]); //recuperer le nombre des jour actuel et convertir en int
        }
        //argument doit etre un numbrer
        catch(NumberFormatException e) {
            return "BAD_ARGUMENT_ERROR";
        }
        //argument doit etre 2 agruments en total
        catch(ArrayIndexOutOfBoundsException e) {
            return "BAD_ARGUMENT_ERROR";
        }
        if(idEmprunt > 0 || jourActuel > 0 ){

        }
        else{
            return "BAD_ARGUMENT_ERROR";
        }

        Utilisateur utilisateurConnecte = this.utilisateursAuthentifies.get(idConnexion);//creer un utilisateur selon l ID de connexion,il cherche directement avec l id de connextion ,donc pas besoin de boucle

        //une partie code est copie d ex4  on ajoute la condition  && emprunt termine
        if(utilisateurConnecte.rechercherEmpruntEnCours(idEmprunt) == null && utilisateurConnecte.rechercherEmpruntTermine(idEmprunt) == null){
        //Si l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté, elle retourne BAD_BORROW_ERROR.
            return "BAD_BORROW_ERROR.";
        }
        else{}


////-------------------------------------code unique-------------------------------------////
//recherche de l’emprunt doit être effectuée autant dans les emprunts en cours que dans les emprunts terminés de l’utilisateur
        Emprunt emprunt;
        if(utilisateurConnecte.rechercherEmpruntEnCours(idEmprunt) != null){
        //si emprunt est en cours donc elle n est pas termine
            emprunt = utilisateurConnecte.rechercherEmpruntEnCours(idEmprunt);

        }
        else{

        //si emprunt pas en cours donc elle est termine
            emprunt = utilisateurConnecte.rechercherEmpruntTermine(idEmprunt) ;
        }
        //Si l’emprunt est trouvé, la méthode doit calculer le nombre de jours de retard
        int jourRetard = emprunt.calculerJoursRetard(jourActuel); //peut retourne 0

        //calculer le montant de la pénalité selon le type de l’utilisateur.
        double montantPenalite = utilisateurConnecte.calculerPenalite(jourRetard); //polymorphisme : si utilisateur est de type etudiant, l objet utilisateur  va utilise la methode d etudiant qui est redefini  partir de methode abstrat d utilisateur
        //Si l’emprunt n’est pas en retard,le montant retourné doit être 0.00 et le nombre de jours de retard doit être 0.
        if(!emprunt.estEnRetard(jourActuel)){
            montantPenalite = 0;
            jourRetard = 0;
        }



        //Le montant de la pénalité doit être affiché avec deux décimales et utiliser le point comme séparateur décimal
        String montantPenaliteChaine = String.format(Locale.US,"%.2f",montantPenalite );//formater en deux decimale(%2f) et utilise point comme seperateur(Locale.US)

        //retourne ensuite la réponse PENALTY <montant> <jours retard>.
        String reponse = "PENALTY"+" <"+ montantPenaliteChaine +">"+" <" + jourRetard +">" ;
        return reponse;

    }


    //ex8
    //Cette méthode permet d’enregistrer un nouvel utilisateur à l’aide de la commande REGISTER <id utilisateur> <type utilisateur> <nom utilisateur>.
    //Ex: REGISTER 120 ETUDIANT Sara = enregistré dans le système nouvel utilisateur (nom utilisateur =Sara, id = 120 ,type = ETUDIANT)
    public String traiterREGISTER(String argument) { //// argument = <id utilisateur>  <type utilisateur>  <nom utilisateur>.

    //récupérer les paramètres de la commande
    // vérifier si les paramètres sont valides
        int idUtilisateur ;
        String typeUtilisateur ;
        String nomUtilisateur ;

        try {
            String[] argumentSeparer = argument.split(" "); //recuperer et separer l argument pour pouvoir le convertir
            idUtilisateur = Integer.parseInt(argumentSeparer[0]); //recuperer l id d utilisateur et convertir en int
            typeUtilisateur = (argumentSeparer[1]); //recuperer le TypeUtilisateur //delete this --> TypeUtilisateur typeUtilisateur = TypeUtilisateur.valueOf(argumentSeparer[1]); //recuperer le TypeUtilisateur et convertir en TypeUtilisateur avec valueOf
            nomUtilisateur = argumentSeparer[2]; //recuperer le nom d utilisateur
        }
        catch(NumberFormatException e) {
            return "BAD_ARGUMENT_ERROR";
        }
        //argument doit etre 3 agruments en total
        catch(ArrayIndexOutOfBoundsException e) {
            return "BAD_ARGUMENT_ERROR";
        }
        //vérifier si les paramètres sont valides
        if(idUtilisateur > 0){

        }
        else{

            return "BAD_ARGUMENT_ERROR";
        }

       // if(idUtilisateur > 0  || typeUtilisateur != null || nomUtilisateur != null ){//idUtilisateur instanceof Integer || typeUtilisateur instanceof String|| nomUtilisateur instanceof String//delete this--> if(idUtilisateur instanceof Integer || typeUtilisateur instanceof TypeUtilisateur || nomUtilisateur instanceof String){

      //  }
      //  else{

     //       return "BAD_ARGUMENT_ERROR";

     //   }



        //assurer que l’identifiant utilisateur n’est pas déjà utilisé dans le système
        for(Utilisateur utilisateurEnregistre : utilisateurs.values()){ //on peut utilise if(utilisateurs.containsKey(idUtilisateur)){return "BAD_ARGUMENT_ERROR";}
            if( idUtilisateur == utilisateurEnregistre.getId() ){
                return "BAD_ARGUMENT_ERROR";
            }
            else{

            }
        }

        //Si les validations sont respectées, la méthode doit créer l’objet utilisateur correspondant selon le type demandé (ETUDIANT, PERSONNEL ou PROFESSEUR)

        //format Utilisateur utilisateur = new Etudiant()

        //on besoin de type si typeUtilisateur = ETUDIANT --> new Etudiant()
        Utilisateur utilisateurCree;
        switch (typeUtilisateur) {

            case "ETUDIANT":

                utilisateurCree = new Etudiant(idUtilisateur,nomUtilisateur) ;

                break;

            case "PERSONNEL":

                utilisateurCree = new Personnel(idUtilisateur,nomUtilisateur) ;

                break;

            case "PROFESSEUR":

                utilisateurCree = new Professeur(idUtilisateur,nomUtilisateur) ;

                break;

            //si le type d’utilisateur est invalide, elle retourne BAD_ARGUMENT_ERROR.

            default:

                return "BAD_ARGUMENT_ERROR";



        }



        //ajouter cet utilisateur dans la liste des utilisateurs enregistrés

        utilisateurs.put(idUtilisateur,utilisateurCree);
        //retourner la réponse REGISTERED <id utilisateur> <nom utilisateur>

        String reponse = "REGISTERED "+"<"+ idUtilisateur+">"+" <" + nomUtilisateur +">" ;
        return reponse ;



    }

    //ex9 traitement de la commande EXIT
    //permet à un utilisateur de quitter l’application à l’aide de la commande EXIT.
    public String traiterEXIT(int idConnexion) { //ex:  id connexion = 2
        String reponse;
        //vérifier que la connexion courante est associée à un utilisateur authentifié
        Utilisateur utilisateurTrouve = utilisateursAuthentifies.get(idConnexion);
        if (utilisateurTrouve instanceof  Utilisateur ){
        //si il exite un utilisateur associer a la connexion retire l utilisateur lie a la connexion et pas la connexion
            utilisateursAuthentifies.remove(idConnexion);
        //retourner la réponse END
            reponse = "END";
        }

        //Si aucun utilisateur n’est authentifié sur cette connexion
        else{
        //retourne AUTHENTICATION_ERROR.
            reponse =  "AUTHENTICATION_ERROR";
        }
        return  reponse;

    }

//fin

}




