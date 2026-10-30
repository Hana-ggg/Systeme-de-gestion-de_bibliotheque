package gestionnaireBibliotheque;

import java.util.Iterator;
import java.util.PriorityQueue;
//5
public class FilePrioriteReservations implements Iterable<Reservation> { //ajouter? Iterable <Livre> // pour pouvoir utilise la boucle for each dans la class utilisateur
    //5.1
    private PriorityQueue<Reservation> filePriorite;
    //5.2
    public FilePrioriteReservations(){//(PriorityQueue <Reservation> filePriorite
        this.filePriorite = new PriorityQueue<>() ; //this.filePriorite = filePriorite  ;

    }
    //5.3
    //ajoute une réservation dans la file de priorité
    //retourne true si l’ajout a été effectué correctement
    public boolean ajouter(Reservation reservation) {
        boolean ajoutReussi = false ;

        ajoutReussi = this.filePriorite.offer(reservation);

        return ajoutReussi;
    }


    //5.4  retire et retourne la réservation la plus prioritaire.
    //Si la file est vide, elle retourne null.
    public Reservation retirer() {
        if( this.filePriorite.size() == 0){
            return null ;
        }
        else {
            Reservation reservationRetire = this.filePriorite.remove();
            return reservationRetire ;
        }
    }

    //5.5
    //retourne la réservation la plus prioritaire sans la retirer de la file.
    //Si la file est vide, elle retourne null.
    public Reservation consulter(){
        if( this.filePriorite.size() == 0){
            return null ;
        }
        else {
            Reservation reservationPrioritaire = this.filePriorite.peek() ;
            return reservationPrioritaire ;
        }
    }

    //5.6
    //retourne true si la file ne contient aucune réservation, retourne false sinon.
    public boolean estVide() {
        if (this.filePriorite.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //5.7
    // retourne le nombre de réservations actuellement présentes dans la file.
    public int taille(){
        int fileTaille = this.filePriorite.size();
        return fileTaille ;
    }

    //5.8
    @Override
    public String toString() {
        String ReservationEnChaine="";
        String FilereservationEnChaine=" " ;
        for(Reservation reservation : filePriorite ){
            ReservationEnChaine= " " + reservation;
            FilereservationEnChaine += ReservationEnChaine ;
        }
        return FilereservationEnChaine ;
    }

    //5.9
    //retirer et retourner la réservation prioritaire associée à un livre donné.
    //Si aucune réservation n’existe pour ce livre, la méthode retourne null.
    public Reservation retirerPourLivre(int idLivre) {

        Reservation reservationPrioritaireSelonLivre = null;
        for(Reservation reservation : filePriorite ){//for(int i=0 ; i< filePriorite .size();i++){
            //Si réservation existe pour ce livre.
            if (reservation.getLivre().getId() == idLivre){
                reservationPrioritaireSelonLivre = reservation;
                break;
            }
        }
        //Si aucune réservation n’existe pour ce livre, la méthode retourne null.
        if(reservationPrioritaireSelonLivre == null){
            return null;
        }
        //retirer et retourner la réservation prioritaire associée à un livre donné.
        filePriorite.remove(reservationPrioritaireSelonLivre);
        return reservationPrioritaireSelonLivre;
    }


    //ajouter iterateur???
    @Override
    public Iterator<Reservation> iterator(){
        // !!! iterator est une interface
        return filePriorite.iterator();

    }

}



