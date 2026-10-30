package gestionnaireBibliotheque;

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
        Livre livre10 = new Livre("Math0", "Suisie", "Calcule");
        Livre livre11 = new Livre("Francais", "Timmie", "langage");
        Livre livre12 = new Livre("Philosophy", "Platon", "argumentation");
        Livre livre13 = new Livre("Finance", "Russell", "commerce");
        Livre livre14 = new Livre("Art", "Dora", "art plastique");
        Livre livre15 = new Livre("Physique", "Estelle", "calcule vectorielle");
        Livre livre16 = new Livre("Chimie", "Karle", "reaction chimique");
        Livre livre17 = new Livre("Histoire", "Russell", "culture canadianne");
        Livre livre18 = new Livre("Roman policier", "Alan", "myster");
        Livre livre19 = new Livre("Roman tragique", "Iris", "tragittie");
        Livre livre20 = new Livre("Mecanique", "Alexa", "mentenance");
        Livre livre21 = new Livre("Architecteur", "Alexa", "dessin graphique");


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
        //vérifier que l’identifiant reçu n est pas valide
        System.out.println(" vérifier que l’identifiant reçu n est pas valide :  "+ gestionnaireBibliotheque.traiterCommande(1,"ID","3D"));

        //vérifier que  aucun utilisateur  correspond à cet identifiant
        System.out.println(" vérifier que  aucun utilisateur  correspond à cet identifiant: "+ gestionnaireBibliotheque.traiterCommande(1,"ID","33"));

        //vérifier que l’utilisateur existe dans la liste des utilisateurs enregistrés
        System.out.println(" vérifier que l’utilisateur existe dans la liste des utilisateurs enregistrés: "+ gestionnaireBibliotheque.traiterCommande(1,"ID","2"));

        //vérifier que l’utilisateur  est  déjà authentifié avec la connexion courante
        System.out.println(" vérifier que l’utilisateur est  déjà authentifié avec la connexion courante: "+ gestionnaireBibliotheque.traiterCommande(1,"ID","1"));

        //vérifier que l’utilisateur  est  déjà connecté à partir d’un autre client.
        System.out.println(" vérifier que l’utilisateur est  déjà connecté à partir d’un autre client: "+ gestionnaireBibliotheque.traiterCommande(3,"ID","2"));

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
        //vérifier que l’utilisateur n est pas authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur n est pas authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"BORROW","1 12"));

        //vérifier que les arguments reçus sont invalides
        System.out.println("  ");
        System.out.println("vérifier que les arguments reçus sont invalides");
        System.out.println(""+gestionnaireBibliotheque.traiterCommande(2,"BORROW","1D 12"));
        System.out.println(""+gestionnaireBibliotheque.traiterCommande(2,"BORROW","1 12D"));
        //verifier nombre d argument
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"BORROW","1 "));


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
        Utilisateur p1 = new Personnel(11,"Jimmie") ;
        testMap.put(p1.getId(),p1);
        gestionnaireBibliotheque.setUtilisateurs(testMap);


        Reservation reservation4 = new Reservation(livre3,p1.getId(),p1.getTypeUtilisateur());
        filePrioriteReservations.ajouter(reservation4);
        gestionnaireBibliotheque.setReservationsEnAttente(filePrioriteReservations);

        //vérifier que l’utilisateur n est pas  authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur n est pas authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"RETURN","4 52"));

        // vérifier que les arguments reçus sont invalides
        System.out.println("  ");
        System.out.println("vérifier que les arguments reçus sont invalides ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","6D 52"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN",""));
        //verifier nombre d argument
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","7 "));



        //Si l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté, elle retourne
        //BAD_BORROW_ERROR.
        System.out.println("  ");
        System.out.println("vérifier que l’emprunt indiqué n'existe pas ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","66 52"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"RETURN","6 52"));


        //vérifier que l’emprunt indiqué existe bien dans la liste de ses emprunts en cours
        System.out.println("  ");
        System.out.println("vérifier que l’emprunt indiqué existe ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","7 52"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","8 52"));

        System.out.println("redevient DISPONIBLE : "+ gestionnaireBibliotheque.traiterCommande(4,"BOOKS",""));

        //créé automatiquement un nouvel emprunt pour l’utilisateur prioritaire
        System.out.println("  ");
        System.out.println(" nouvel emprunt pour l’utilisateur prioritaire");
        System.out.println(" "+ gestionnaireBibliotheque.traiterCommande(2,"RETURN","6 52"));
        System.out.println("redevient emprunt : "+ gestionnaireBibliotheque.traiterCommande(4,"BOOKS",""));




    //*
        //Vérifier que l’emprunt 6 a été déplacé vers les emprunts terminés de May
    //    System.out.println("  ");
     //   System.out.println("Emprunts terminés de May : ");
     //   System.out.println(""+c2.getEmpruntsTermines());

        //Vérifier que l’emprunt 6 n’est plus dans les emprunts en cours de May
     //   System.out.println("  ");
     //   System.out.println("Emprunts en cours de May après le retour : ");
     //   System.out.println(c2.getEmpruntsEnCours());
        //Vérifier que la réservation a été retirée de la file
     //   System.out.println("  ");
     //   System.out.println("Réservations encore en attente : ");
      //  System.out.println(gestionnaireBibliotheque.getReservationsEnAttente());

        //Vérifier que la réservation est ATTRIBUEE
     //   System.out.println("  ");
      //  System.out.println("Statut de la réservation : ");
      //  System.out.println(reservation4);

        //Vérifier que le nouvel emprunt a été ajouté à l’utilisateur prioritaire
     //   System.out.println("  ");
     //   System.out.println("Emprunts en cours de Jimmie : ");
     //   System.out.println(p1.getEmpruntsEnCours());

        //Vérifier que le livre 3 est toujours EMPRUNTE
     //   System.out.println("  ");
    //    System.out.println("Livre 3 après attribution : ");
     //   System.out.println(livre3);

        //ex5
        System.out.println("--------------------------------Partie2 ex5-----------------------------");
        livre10.setStatut(StatutLivre.EMPRUNTE);
        livre11.setStatut(StatutLivre.EMPRUNTE);
        livre12.setStatut(StatutLivre.EMPRUNTE);
        livre13.setStatut(StatutLivre.EMPRUNTE);
        livre14.setStatut(StatutLivre.RESERVE);
        livre15.setStatut(StatutLivre.RESERVE);
        livre16.setStatut(StatutLivre.RESERVE);
        livre17.setStatut(StatutLivre.RESERVE);
        livre18.setStatut(StatutLivre.PERDU);
        livre19.setStatut(StatutLivre.PERDU);
        livre20.setStatut(StatutLivre.PERDU);
        livre21.setStatut(StatutLivre.PERDU);
        liste_livre.add(livre10);
        liste_livre.add(livre11);
        liste_livre.add(livre12);
        liste_livre.add(livre13);
        liste_livre.add(livre14);
        liste_livre.add(livre15);
        liste_livre.add(livre16);
        liste_livre.add(livre17);
        liste_livre.add(livre18);
        liste_livre.add(livre19);
        liste_livre.add(livre20);
        liste_livre.add(livre21);
        //vérifier que l’utilisateur n est pas authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur n est pas authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"RESERVE","3"));

        //vérifier que les arguments reçus sont invalides
        System.out.println("  ");
        System.out.println("vérifier que les arguments reçus sont invalides");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","g"));

        //vérifier que le livre demandé n existe pas
        System.out.println("  ");
        System.out.println("vérifier que le livre demandé n existe pas");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","33"));

        //vérifier que le livre est déjà disponible
        System.out.println("  ");
        System.out.println("vérifier que le livre est déjà disponible");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","4"));

        //vérifier que l’utilisateur a atteint sa limite de réservations
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur a atteint sa limite de réservations");
        System.out.println("Nombre des reservation pour utilisatuer connecte : "+c2.getReservation().taille());
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","10"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","11"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","12"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","13"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","14"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","15"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","16"));
        System.out.println("Nombre des reservation pour utilisatuer connecte : "+c2.getReservation().taille());
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","17"));
        System.out.println("Nombre des reservation pour utilisatuer connecte : "+c2.getReservation().taille());
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","18"));
        System.out.println("Nombre des reservation pour utilisatuer connecte : "+c2.getReservation().taille());
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","19"));
        System.out.println("Nombre des reservation pour utilisatuer connecte : "+c2.getReservation().taille());
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","20"));
        //Donc c est ajoute aux réservations de l’utilisateur
        System.out.println("Nombre des reservation pour utilisatuer connecte : "+c2.getReservation().taille());


        //vérifier que l’utilisateur possède déjà une réservation en attente pour ce livre,
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur possède déjà une réservation en attente pour ce livre,");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"RESERVE","10"));
        System.out.println("La file de reservtaion en ATTENTE");
        System.out.println(gestionnaireBibliotheque.getReservationsEnAttente());
        System.out.println("La Liste des livre");
        System.out.println(gestionnaireBibliotheque.getLivres());



        //ex6
        System.out.println("--------------------------------Partie2 ex6-----------------------------");
        //vérifier que l’utilisateur n est pas authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur n est pas authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"INFO","4"));

        //vérifier que les arguments reçus sont invalides
        System.out.println("  ");
        System.out.println("vérifier que les arguments reçus sont invalides");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"INFO","g"));

        //vérifier que l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté
        System.out.println("  ");
        System.out.println("vérifier que l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"INFO","99"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(3,"INFO","7"));

        //vérifier que si pas d argument ca retourner la liste emprunts en cours de l’utilisateur
        System.out.println("  ");
        System.out.println("vérifier que si pas d argument ca retourner la liste emprunts en cours de l’utilisateur");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"INFO",""));


        //vérifier que avec argment ca retourner l emprunt trouve de l’utilisateur
        System.out.println("  ");
        System.out.println("vérifier que avec argment ca retourner l emprunt trouve de l’utilisateur");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"INFO","5"));


        //ex7
        System.out.println("--------------------------------Partie2 ex7-----------------------------");
        Utilisateur u5 = new Professeur(5,"Proton") ;
        Utilisateur c5 = new Professeur(5,"Proton") ;
        testConnexionMap.put(5,c5);
        Livre livre22 = new Livre("Avion", "Suri", "physique et dynamique");
        liste_livre.add(livre22);
        //C est l emputre numero 10
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(5,"BORROW","5 12"));


        //vérifier que l’utilisateur n est pas authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur n  est pas authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"PENALTY","4 4"));

        //vérifier que les arguments reçus sont invalides
        System.out.println("  ");
        System.out.println("vérifier que les arguments reçus sont invalides");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","g 4"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","4 g"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","4"));


        //vérifier que l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté
        System.out.println("  ");
        System.out.println("Vérifier que l’emprunt demandé n’existe pas ou n’appartient pas à l’utilisateur connecté");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","99 4"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","10 4"));

        //vérifier le montant de la pénalité
        System.out.println("  ");
        System.out.println("Vérifier le montant de la pénalité si livre est returne a temp");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","6 52"));
        System.out.println("Vérifier le montant de la pénalité si livre est returne en retard");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","6 53"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"PENALTY","6 54"));

        System.out.println("  ");
        System.out.println(" Si un professeur ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(5,"PENALTY","10 52"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(5,"PENALTY","10 54"));


        //ex8
        System.out.println("--------------------------------Partie2 ex8-----------------------------");
        //vérifier que les arguments reçus sont invalides, si l’identifiant est déjà utilisé ou si le type d’utilisateurest invalide
        System.out.println("  ");
        System.out.println("vérifier que les arguments reçus sont invalides, si l’identifiant est déjà utilisé ou si le type d’utilisateurest invalide ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"REGISTER","g"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"REGISTER","g b d"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"REGISTER","4 ETUDIANT Lila"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"REGISTER","6 ETUDIANT "));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"REGISTER","6 PRESIDANT Lila"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"REGISTER","-6 ETUDIANT Lila"));

        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(2,"REGISTER","6 ETUDIANT Lila"));
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(5,"REGISTER","6 ETUDIANT Lila"));

        System.out.println("  ");
        System.out.println("Liste des utilisateur enregistre");
        System.out.println(""+gestionnaireBibliotheque.getUtilisateurs());
        //ex9
        System.out.println("--------------------------------Partie2 ex8-----------------------------");
        //vérifier que l’utilisateur n est pas authentifié.
        System.out.println("  ");
        System.out.println("vérifier que l’utilisateur n est pas authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(4,"EXIT",""));

        System.out.println("  ");
        System.out.println("Liste des utilisateur authentifies avant");
        System.out.println(""+gestionnaireBibliotheque.getUtilisateursAuthentifies());

        System.out.println("  ");
        System.out.println("Si l’utilisateur est authentifié ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"EXIT",""));

        System.out.println("  ");
        System.out.println("Liste des utilisateur authentifies apres");
        System.out.println(""+gestionnaireBibliotheque.getUtilisateursAuthentifies());

        System.out.println("  ");
        System.out.println("exit une deuximeme fois la meme connection ");
        System.out.println(""+ gestionnaireBibliotheque.traiterCommande(1,"EXIT",""));



    }
}