package gestionnaireBibliotheque;

public class Emprunt {//3



    private int id;
    private Livre livre;
    private int idUtilisateur;
    private int jourEmprunt ;
    private int jourRetourPrevu;
    private int jourRetour;
    private StatutEmprunt statut;

    //3.2
    private static int identifiantUnique = 0;
    //générer automatiquement un identifiant unique pour chaque emprunt.
    public static int prochainID(){
       // Random rnd = new Random();
       // int de = rnd.nextInt(1, 1000000+ 1);
        return identifiantUnique = identifiantUnique+ 1;

    }



    //3.3
    public Emprunt(Livre livre, int idUtilisateur, int jourEmprunt){ //int jourRetourPrevu
        this.id = prochainID();
        this.livre=livre;
        this.idUtilisateur=idUtilisateur;
        this.jourEmprunt=jourEmprunt;
        this.jourRetourPrevu=jourEmprunt+livre.getDureeMaxEmprunt();
        this.statut = StatutEmprunt.EN_COURS;

    }

    public int getId(){
        return this.id;
    }
    public Livre getLivre(){
        return this.livre;
    }
    public int getJourEmprunt(){
        return this.jourEmprunt ;
    }
    public int getJourRetourPrevu(){
        return this.jourRetourPrevu ;
    }

    public StatutEmprunt getStatut(){
        return this.statut ;
    }
    public void setStatut(StatutEmprunt statut){
        this.statut = statut ;
    }

    //3.4
    //retourne true si le jour actuel dépasse le jour prévu du retour, retourne false sinon.
    public boolean estEnRetard(int jourActuel){
        if( jourActuel > jourRetourPrevu){
            return true;
        }
        return false;
    }
    //3.5
    //retourne le nombre de jours de retard de l’emprunt.
    //Si l’emprunt n’est pas en retard, la méthode retourne 0.
    public int calculerJoursRetard(int jourActuel){
        int nombre_jour_retard;
        if(estEnRetard(jourActuel)){ //si en retard
            nombre_jour_retard = jourActuel - this.jourRetourPrevu;
            return nombre_jour_retard;
        }
        return 0;
    }

    //3.6
    // met à jour :
    //• le jour réel du retour ;
    //• le statut de l’emprunt.
    //• Le statut doit devenir :
    //  RETOURNE si le livre est retourné à temps ;
    //EN_RETARD sinon.
    public void retourner(int jourRetour){
        this.jourRetour = jourRetour;
        if(estEnRetard(jourRetour)){ //si en retard
            this.statut = StatutEmprunt.EN_RETARD;
        }
        else{
            this.statut = StatutEmprunt.RETOURNE;
        }

    }

    // 3.7
    @Override
    public String toString() {
        return "id: "+id+" ,livre: " +livre + " ,idUtilisateur: "+idUtilisateur+" ,jourEmprunt: "+jourEmprunt+ " ,jourRetourPrevu: "+jourRetourPrevu + " ,statut: "+ statut ;
    }

}
