import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Demo {
    public static void main(String[] args) {
        Livre livre1 = new Livre("Java", "Deitel", "Informatique");
        Livre livre2 = new Livre("python", "John", "Intelligence artificiel");
        Livre livre3 = new Livre("php", "Bob", "Cybersecurity");

        Etudiant etudiant = new Etudiant(101, "Amine");
        Personnel personnel = new Personnel(102, "Jake");
        Professeur professeur = new Professeur(102, "Alex");

        Emprunt emprunt1 = new Emprunt(livre1, etudiant.getId(), 5);
        Emprunt emprunt2 = new Emprunt(livre2, personnel.getId(), 15);
        Emprunt emprunt3 = new Emprunt(livre3, professeur.getId(), 25);

        //afficher les informations d’un livre ;
        System.out.println("afficher les informations d’un livre");
        System.out.println(livre1);
        System.out.println(livre2);
        //vérifier qu’un emprunt est correctement créé ;
        System.out.println("");
        System.out.println("emprunt est correctement créé ");
        System.out.println(emprunt1);
        System.out.println(emprunt2);
        System.out.println(emprunt3);

        //tester le calcul du retour prévu ;
        System.out.println("");
        System.out.println("tester le calcul du retour prévu ");
        System.out.println( "Jours de prevu : " + emprunt1.getJourRetourPrevu() );
        System.out.println( "Jours de prevu : " + emprunt2.getJourRetourPrevu() );

        //vérifier si un emprunt est en retard
        System.out.println("");
        System.out.println("vérifier si un emprunt est en retard  ");
        System.out.println( "Jours de retard : " + emprunt1.calculerJoursRetard(50) );

        //tester le calcul des pénalités ;
        System.out.println("");
        System.out.println("tester le calcul des pénalités  ");
        System.out.println( "Pénalité : " + etudiant.calculerPenalite(5) + "$");


        Reservation reservation1 = new Reservation(livre1,etudiant.getId(),etudiant.getTypeUtilisateur());
        Reservation reservation2 = new Reservation(livre2,personnel.getId(),personnel.getTypeUtilisateur());
        System.out.println("");
        System.out.println(""+reservation1);
        System.out.println(""+reservation2);

        //vérifier l’ordre de priorité des réservations ;

        FilePrioriteReservations filePrioriteReservations = new FilePrioriteReservations();
        System.out.println("");
        System.out.println(""+filePrioriteReservations);
        filePrioriteReservations.ajouter(reservation1);
        filePrioriteReservations.ajouter(reservation2);
        System.out.println("vérifier l’ordre de priorité des réservations"+filePrioriteReservations.consulter());

        ArrayList <Emprunt> liste_emp = new ArrayList<>();
        liste_emp.add(emprunt1);
        liste_emp.add(emprunt3);
        //tester les différentes listes et structures de données.
        ListeEmprunts listeEmprunts = new ListeEmprunts(liste_emp);
        System.out.println("");
        System.out.println("listeEmprunts : "+listeEmprunts);


        ArrayList <Livre> liste_livre = new ArrayList<>();
        liste_livre.add(livre1);
        liste_livre.add(livre3);
        ListeLivres listeLivres = new ListeLivres(liste_livre);
        System.out.println("listeLivres : "+listeEmprunts);

    }
}