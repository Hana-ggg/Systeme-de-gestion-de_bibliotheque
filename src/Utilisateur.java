public abstract  class Utilisateur { //6

    //6.1
    private int id;



    private String nom;
    private ListeEmprunts empruntsEnCours;
    private ListeEmprunts empruntsTermines;
    private FilePrioriteReservations reservations;

    //6.2 Cette constante représente le nombre maximal de réservations qu’un utilisateur peut avoir en attente.
    public static final int MAX_RESERVATIONS = 10;




    //6.3
    public Utilisateur(int id, String nom) { //ListeEmprunts empruntsEnCours,ListeEmprunts empruntsTermines,ListeEmprunts empruntsTermines
        this.id = id;
        this.nom = nom;
        this.empruntsEnCours = new ListeEmprunts();
        this.empruntsTermines = new ListeEmprunts();
        this.reservations = new FilePrioriteReservations();
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return nom;
    }

    public ListeEmprunts getEmpruntsEnCours() {
        return this.empruntsEnCours;
    }
    public ListeEmprunts getEmpruntsTermines() {
        return empruntsTermines;
    }

    public FilePrioriteReservations getReservation() {
        return this.reservations;
    }


    public static int getMAX_RESERVATIONS() {
        return MAX_RESERVATIONS;
    }


    //6.4
    //ajoute un emprunt à la liste des emprunts en cours de l’utilisateur.
    public void ajouterEmpruntEnCours(Emprunt emprunt) {
        this.empruntsEnCours.ajouter(emprunt);
    }


    //6.5
    //ajoute un emprunt à la liste des emprunts terminés de l’utilisateur.
    public void ajouterEmpruntTermine(Emprunt emprunt) {
        this.empruntsTermines.ajouter(emprunt);
    }


    //6.6
    public Emprunt supprimerEmpruntEnCours(int idEmprunt) {
        // rechercher dans la liste des emprunts en cours l identifiant
        Emprunt empruntSuprrime = this.empruntsEnCours.rechercher(idEmprunt);
        //retirer de la liste.
        this.empruntsEnCours.supprimer(idEmprunt);


        //Si l’emprunt est trouvé, la méthode retourne l’objet Emprunt supprimé sinon null

        if (empruntSuprrime != null) {
            return empruntSuprrime;

        }

        return null;

    }


    //6.7
    //rechercher dans la liste des emprunts en cours de l’utilisateur l’emprunt correspondant à l’identifiant reçu en paramètre.
    public Emprunt rechercherEmpruntEnCours(int idEmprunt) {
        Emprunt empruntsRecherche = this.empruntsEnCours.rechercher(idEmprunt);

        //Si un emprunt correspondant est trouvé, la méthode retourne l’objet Emprunt associé. Sinon
        if (empruntsRecherche != null) {
            return empruntsRecherche;
        }
        return null;
    }


    //6.8
    //recherche un emprunt terminé à partir de son identifiant.
    public Emprunt rechercherEmpruntTermine(int idEmprunt) {
        Emprunt empruntTermine = this.empruntsTermines.rechercher(idEmprunt);

        //retourne l’objet Emprunt trouvé si l’emprunt existe dans la liste des emprunts terminés de l’utilisateur sinon null
        if (empruntTermine != null) {
            return empruntTermine;
        }
        return null;
    }


    //6.9
    //retourne true si l’utilisateur possède au moins un emprunt en cours. Elle retourne false sinon.
    public boolean aDesEmpruntsEnCours() {
        if (this.empruntsEnCours.estVide()) {
            return false;
        }
        return true;

    }


    //Ex 6.10
    // !!! methode abstrait(sera redefinie en sous class)
    //retourner le nombre maximal de livres qu’un utilisateur peut emprunter selon son type
    public abstract int nombreMaxEmprunts(); //autre class vont herite et utilise?

    //Ex 6.11
    //retourne true si le nombre d’emprunts en cours de l’utilisateur est inférieur au nombre maximal d’emprunts autorisé pour son type sinon false
    public boolean peutEmprunter() {
        // nombre maximal d’emprunts dépendra de la méthode abstraite nombreMaxEmprunts().

        if (this.empruntsEnCours.taille() < nombreMaxEmprunts()) {
            return true;
        }
        return false;
    }


    //6.12 //besoin d interface?
    // vérifier si l’utilisateur possède déjà une réservation en attente pour le livre correspondant à l’identifiant reçu en paramètre.
    public boolean possedeReservationEnAttentePourLivre(int idLivre) {
        //for (Reservation livre : this.reservations) {
        for (Reservation reservation : this.reservations) {
            //retourne true si une réservation en attente existe déjà pour ce livre, et false sinon.
            //if (livre.getId() == idLivre) {
            if ( reservation.getLivre().getId()== idLivre) {
                    return true;

            }
        }
        //This.reservations.retirerPourLivre(int idLivre);
        return false;
    }


    //6.13
    // ajoute une réservation à la file des réservations de l’utilisateur si le nombre maximal de réservations n’est pas atteint.
    public boolean ajouterReservation(Reservation reservation) {
        // Elle retourne true si la réservation a été ajoutée et false sinon
        boolean ajoutReussi = false;
        // if (this.reservations.taille() == this.MAX_RESERVATIONS) {
        if (this.reservations.taille() < this.MAX_RESERVATIONS) {
            ajoutReussi = this.reservations.ajouter(reservation);
        }
        return ajoutReussi;

    }


    //6.14
    // !!! methode abstrait(sera redefinie en sous class)
    //calculer le montant de la pénalité selon le nombre de jours de retard. Le calcul dépendra du type d’utilisateur.
    public abstract double calculerPenalite(int joursRetard);


    //6.15
    // !!! methode abstrait(sera redefinie en sous class
    // Les sous-classes Etudiant, Personnel et Professeur devront redéfinir cette méthode afin de retourner respectivement : ETUDIANT, PERSONNEL, PROFESSEUR
    // retourne le type de l’utilisateur
    public abstract TypeUtilisateur getTypeUtilisateur();


    //6.16
    @Override
    public String toString() {

        return "Type d’utilisateur : " + getTypeUtilisateur() + " Identifiant " + id + " nom" + nom + "  Nombre d’emprunts en cour : " + empruntsEnCours.taille() + "  Nombre d’emprunts terminés :  " + empruntsTermines.taille() + "  Nombre de réservations en attente " + reservations.taille();
    }
}



