/*
 * ================================================================
 * CODE FOURNI - INF111
 * Noyau client-serveur
 *
 * Auteur  : Professeur Abdelmoumene  Toudeft
 * Documenté  par  : Asma Bellili
 *
 *
 * Ce fichier fait partie du noyau client-serveur fourni aux etudiants.
 * Le code de communication est deja fonctionnel et ne doit pas etre
 * modifie, sauf indication contraire dans l'enonce du travail pratique.
 * ================================================================
 */

package com.atoudeft.serveur;

import com.atoudeft.commun.evenement.Evenement;
import com.atoudeft.commun.evenement.GestionnaireEvenement;
import com.atoudeft.commun.net.Connexion;
import gestionnaireBibliotheque.GestionnaireBibliotheque;

/**
 * Cette classe repr�sente un gestionnaire d'�v�nement d'un serveur. Lorsqu'un serveur re�oit un texte d'un client,
 * il cr�e un �v�nement � partir du texte re�u et alerte ce gestionnaire qui r�agit en g�rant l'�v�nement.
 *
 * @author Abdelmoum�ne Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-09-01
 */
public class GestionnaireEvenementServeur implements GestionnaireEvenement {
    private Serveur serveur;

    /**
     * Construit un gestionnaire d'�v�nements pour un serveur.
     *
     * @param serveur Serveur Le serveur pour lequel ce gestionnaire g�re des �v�nements
     */
    private GestionnaireBibliotheque gestionnaireBibliotheque;
    public GestionnaireEvenementServeur(Serveur serveur) {
        this.serveur = serveur;

        //partie 3:5-Créer dans cette classe un objet de type : GestionnaireBibliotheque  qui  permettra d’utiliser le
        //système de gestion de bibliothèque.
        this.gestionnaireBibliotheque = new GestionnaireBibliotheque();

    }

    /**
     * M�thode de gestion d'�v�nements. Cette m�thode contiendra le code qui g�re les r�ponses obtenues d'un client.
     *
     * @param evenement L'�v�nement � g�rer.
     */
    @Override
    public void traiter(Evenement evenement) {
        Object source = evenement.getSource();
        Connexion cnx;
        String reponse;

        if (source instanceof Connexion) {
            cnx = (Connexion) source;
            System.out.println("SERVEUR: Recu : " + evenement.getType() + " " + evenement.getArgument());
            if ("EXIT".equals(evenement.getType())) {

                cnx.envoyer("END.");
                cnx.close();
            } else {
                /*
                 * ------------------------------------------------------------
                 * TRAITEMENT FOURNI AU DEPART
                 * ------------------------------------------------------------
                 * Dans le noyau fourni, le serveur ne fait pas encore de vraie
                 * gestion de bibliotheque. Il se contente de reprendre le texte
                 * recu du client, de le convertir en majuscules, puis de le
                 * renvoyer au client.
                 *
                 * Exemple :
                 * Client  -> hello
                 * Serveur -> HELLO
                 *
                 * Ce traitement simple permet seulement de verifier que la
                 * communication entre le client et le serveur fonctionne bien.
                 *
                 * Dans le TP, c'est principalement ici que le traitement devra
                 * etre remplace par un appel au gestionnaire de bibliotheque
                 * que vous aurez programme dans le package :
                 *
                 *     gestionnaireBibliotheque
                 *
                 * Le serveur devra alors transmettre la commande recue au
                 * GestionnaireBibliotheque afin d'obtenir une vraie reponse,
                 * par exemple : AUTHORIZED, BORROW_OK, RETURN_OK, etc.
                 * ------------------------------------------------------------
                 */



                int idConnexion = System.identityHashCode(evenement.getSource());
                String typeCommnade = ""+evenement.getType();
                String argument = ""+evenement.getArgument().toUpperCase();
                String testReponse ="ideconnextion: "+idConnexion+" le type d evenement : "+ typeCommnade +" l argument d evenemnt: "+ argument ;
                reponse = gestionnaireBibliotheque.traiterCommande(idConnexion,typeCommnade,argument);
                //reponse = (evenement.getType() + " " + evenement.getArgument()).toUpperCase();
                cnx.envoyer(reponse);

                //cnx.envoyer(testReponse);

                //*Execute les test dans cette ordre
                // • REGISTER <id utilisateur> <type utilisateur> <nom utilisateur> : enregistrer un nouvel utilisateur ;
                //• ID <id utilisateur> : s’authentifier auprès du serveur ;
                //• BOOKS : afficher la liste des livres de la bibliothèque.
                //• BORROW <id livre> <jour> : emprunter un livre disponible ;
                //• RETURN <id emprunt> <jour> : retourner un livre emprunté ;
                //• RESERVE <id livre> : réserver un livre non disponible
                //• INFO : afficher les emprunts en cours de l’utilisateur ;
                //• INFO <id emprunt> : afficher les informations d’un emprunt particulier ;
                //• PENALTY <id emprunt> <jour actuel> : calculer la pénalité associée à un emprunt ;
                //• EXIT : déconnecter le client de l’application.
                // *//

            }
        }
    }
}
