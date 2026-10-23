public class Reservation implements Comparable<Reservation>{//4
    //4.1
    private int id;



    private Livre livre;
    private int idUtilisateur;
    private TypeUtilisateur typeUtilisateur;
    private int ordreReservation;


    private StatutReservation statut;

    //4.2
    //générer automatiquement un identifiant unique pour chaque réservation.
    //Cette méthode doit retourner un numéro séquentiel commençant à 1.
    private static int numero_sequentiel_prochainID = 0 ;

    public static int prochainID(){
        numero_sequentiel_prochainID += 1  ;
        return numero_sequentiel_prochainID ;
    }

    //4.3
    //générer automatiquement l’ordre d’arrivée des réservations.
   // Cette méthode doit retourner un numéro séquentiel commençant à 1
    private static int ordreReservationUnique = 0 ;
    public static int prochainOrdreReservation(){
        ordreReservationUnique ++;
        return ordreReservationUnique ;
    }

    //4.4
    public Reservation(Livre livre,int idUtilisateur,TypeUtilisateur typeUtilisateur){//,TypeUtilisateur typeUtilisateur,int
        this.livre = livre ;
        this.idUtilisateur = idUtilisateur;
        this.typeUtilisateur = typeUtilisateur ;
        this.id = prochainID();
        this.ordreReservation = prochainOrdreReservation();
        this.statut = StatutReservation.EN_ATTENTE;

    }
    public int getId(){
        return this.id;
    }
    public Livre getLivre() {
        return livre;
    }
    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }


    //4.5
    //
    @Override
    public int compareTo(Reservation autre) {
        int ordreReservation_priorite_currente = 0;
        int ordreReservation_priorit_autre = 0;

        if (this.typeUtilisateur == TypeUtilisateur.PROFESSEUR
        ) {
            ordreReservation_priorite_currente = 0;
        }
        if (this.typeUtilisateur == TypeUtilisateur.PERSONNEL) {
            ordreReservation_priorite_currente = 1;
        }
        if (this.typeUtilisateur == TypeUtilisateur.ETUDIANT) {
            ordreReservation_priorite_currente = 2;
        }


        if (autre.typeUtilisateur == TypeUtilisateur.PROFESSEUR
        ) {

            ordreReservation_priorit_autre = 0;
        }
        if (autre.typeUtilisateur == TypeUtilisateur.PERSONNEL) {

            ordreReservation_priorit_autre = 1;
        }
        if (autre.typeUtilisateur == TypeUtilisateur.ETUDIANT) {
            ordreReservation_priorit_autre = 2;

            if (ordreReservation_priorite_currente < ordreReservation_priorit_autre) {
                return -1;
            }
            if (ordreReservation_priorite_currente > ordreReservation_priorit_autre) {
                return 1;
            }

            if (this.typeUtilisateur == autre.typeUtilisateur && ordreReservation_priorite_currente == ordreReservation_priorit_autre) {
                return 0; // egaux
            }
            if (this.typeUtilisateur == autre.typeUtilisateur) {


                if (this.ordreReservation < autre.ordreReservation) { //priorite au ancien
                    return -1;
                }
                else {
                    return 1;
                }
            }

        }
     return 0 ;
    }
    //4.6
    @Override
    public String toString() {
        return "Identifiant de la réservation : " + id + " ,Identifiant du livre réservé : "+livre.getId() +" ,Identifiant de l’utilisateur : "+idUtilisateur+ " ,Type d’utilisateur : "+typeUtilisateur+ " ,Ordre de réservation : "+ ordreReservation+" ,Statut de la réservation : "+statut;
    }

}
