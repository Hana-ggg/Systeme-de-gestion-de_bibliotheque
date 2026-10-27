import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Demo {
    public static void main(String[] args) {
        Livre livre1 = new Livre("Java", "Deitel", "Informatique");
        Livre livre2 = new Livre("python", "John", "Intelligence artificiel");
        Livre livre3 = new Livre("php", "Bob", "Cybersecurity");
        Livre livre4 = new Livre("windows commande shell script", "Steve", "Automatisation");
        Livre livre5 = new Livre("Linux commande shell", "Dave", "Serveur");
        Livre livre6 = new Livre("Cisco router commande shell", "Cisco", "Reseau");
        Livre livre7 = new Livre("MySql", "Oracl", "Base de donne");
        Livre livre8 = new Livre("PaaS", "Asure", "Disponibilite");
        Livre livre9 = new Livre("Docker", "Francois", "Micro systeme avec conteneur");

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

        System.out.println("listeLivres taille : "+listeLivres.taille());
        System.out.println("listeLivres recherche le livre2 ? "+listeLivres.rechercher(livre2.getId()));
        System.out.println("listeLivres recherche le livre3 ? "+listeLivres.rechercher(livre3.getId()));

        System.out.println("listeLivres contient le livre2 ? "+listeLivres.contient(livre2.getId()));
        System.out.println("listeLivres contient le livre3 ? "+listeLivres.contient(livre3.getId()));

        System.out.println("listeLivres supprimer le livre3 "+listeLivres.supprimer(livre3.getId()));
        System.out.println("listeLivres contient le livre3 ? "+listeLivres.contient(livre3.getId()));
        System.out.println("listeLivres taille : "+listeLivres.taille());


        GestionnaireBibliotheque  gestionnaireBibliotheque = new GestionnaireBibliotheque();
        //utilisateur
        Utilisateur u1 = new Etudiant(1,"Sara") ;
        Utilisateur u2 = new Etudiant(2,"May") ;
        Utilisateur u3 = new Etudiant(3,"Yoko") ;
        Utilisateur u4 = new Etudiant(4,"Steve") ;

        Map<Integer, Utilisateur> testMap = new HashMap<>();
        testMap.put(1,u1);
        testMap.put(2,u2);
        testMap.put(3,u3);
        testMap.put(4,u4);


        gestionnaireBibliotheque.setUtilisateurs(testMap);
        System.out.println("");
        System.out.println(" Gestionaire lite d utilisateur entregistre "+ gestionnaireBibliotheque.getUtilisateurs());

        //connextion

        Utilisateur c1 = new Etudiant(1,"Sara") ;
        Utilisateur c2 = new Etudiant(2,"May") ;
        Utilisateur c3 = new Etudiant(3,"Yoko") ;

        Map<Integer, Utilisateur> testConnexionMap = new HashMap<>();
        testConnexionMap.put(1,c1);
        testConnexionMap.put(2,c2);
       // testConnexionMap.put(3,c2);
        //testConnexionMap.put(3,c3);
        gestionnaireBibliotheque.setUtilisateursAuthentifies(testConnexionMap);


        //livre
        gestionnaireBibliotheque.setLivres(listeLivres);


        //partie 2 ex1
        System.out.println("--------------------------------Partie2 ex1-----------------------------");
        //vérifier que l’identifiant reçu est valide
        System.out.println(" vérifier que l’identifiant reçu est valide :  "+ gestionnaireBibliotheque.traiterCommande(1,"ID","3D"));

        //vérifier que  aucun utilisateur ne correspond à cet identifiant
        System.out.println(" vérifier que  aucun utilisateur ne correspond à cet identifiant: "+ gestionnaireBibliotheque.traiterCommande(1,"ID","33"));

        //vérifier que l’utilisateur existe dans la liste des utilisateurs enregistrés
        System.out.println(" vérifier que l’utilisateur existe dans la liste des utilisateurs enregistrés: "+ gestionnaireBibliotheque.traiterCommande(1,"ID","2"));

        //vérifier que l’utilisateur  n’est pas déjà authentifié avec la connexion courante
        System.out.println(" vérifier que l’utilisateur n’est pas déjà authentifié avec la connexion courante: "+ gestionnaireBibliotheque.traiterCommande(1,"ID","1"));

        //vérifier que l’utilisateur  n’est pas déjà connecté à partir d’un autre client.
        System.out.println(" vérifier que l’utilisateur n’est pas déjà connecté à partir d’un autre client: "+ gestionnaireBibliotheque.traiterCommande(3,"ID","2"));

        //Si toutes les vérifications sont respectées, l’utilisateur est associé à la connexion courante et ajouté à
        //la liste des utilisateurs authentifiés
        System.out.println(" l’utilisateur est associé à la connexion courante et ajouté : "+ gestionnaireBibliotheque.traiterCommande(3,"ID","3"));


        //ex2
        System.out.println("--------------------------------Partie2 ex2-----------------------------");
        liste_livre.remove(livre1);
        liste_livre.remove(livre2);
        liste_livre.remove(livre3);

        liste_livre.add(livre1); //emprunt 4
        liste_livre.add(livre2);
        liste_livre.add(livre3); //emprunt 3

        liste_livre.add(livre4);
        liste_livre.add(livre5);
        liste_livre.add(livre6);

        liste_livre.add(livre7);
        liste_livre.add(livre8);
        liste_livre.add(livre9);

        //parcourir la liste des livres de la bibliothèque, récupérer les informations de chaque
        //livre
        System.out.println("  ");
        System.out.println("parcourir la liste des livres de la bibliothèque ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"BOOKS",""));

        //ex3
        System.out.println("--------------------------------Partie2 ex3-----------------------------");
        //vérifier que l’utilisateur est authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur est authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"BORROW","1 12"));

        //vérifier que les arguments reçus sont invalides
        System.out.println("  ");
        System.out.println("vérifier que les arguments reçus sont invalides");
        System.out.println(""+gestionnaireBibliotheque.traiterCommande(2,"BORROW","1D 12"));
        System.out.println(""+gestionnaireBibliotheque.traiterCommande(2,"BORROW","1 12D"));

        //vérifier que le livre demandé existe
        System.out.println("  ");
        System.out.println("vérifier que le livre demandé n existe pas ");
        System.out.println(gestionnaireBibliotheque.traiterCommande(2,"BORROW","33 12"));


        //Si toutes les validations sont respectées, la méthode doit créer l’objet Emprunt correspondant,
        //l’ajouter à la liste des emprunts en cours de l’utilisateur, modifier le statut du livre à EMPRUNTE
        System.out.println("  ");
        System.out.println("Si toutes les validations sont respectées, la méthode doit créer Emprunt et ajouter livre a la liste  ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","1 12"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"BOOKS",""));
        System.out.println("ne doit pas ajoute car deja emprunte : "+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","1 12"));

        //vérifier que  l’utilisateur n’a pas atteint le nombre maximal d’emprunts autorisé pour son type.
        System.out.println(" ");
        System.out.println("vérifier que  l’utilisateur n’a pas atteint le nombre maximal d’emprunts autorisé pour son type. ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","2 12"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","3 12"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","4 12"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","5 12"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","6 12"));

        //ex4
        System.out.println("--------------------------------Partie2 ex4-----------------------------");
        //vérifier que l’utilisateur est authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur est authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"RETURN","4 52"));

        //vérifier que l’emprunt indiqué existe bien dans la liste de ses emprunts en cours
        System.out.println("  ");
        System.out.println("vérifier que l’emprunt indiqué existe ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","4 52"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","6 52"));
        System.out.println("redevient DISPONIBLE : "+ gestionnaireBibliotheque.traiterCommande(4,"BOOKS",""));
        Reservation reservation4 = new Reservation(livre3,personnel.getId(),personnel.getTypeUtilisateur());
        filePrioriteReservations.ajouter(reservation4);
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","6 52"));







    }
}