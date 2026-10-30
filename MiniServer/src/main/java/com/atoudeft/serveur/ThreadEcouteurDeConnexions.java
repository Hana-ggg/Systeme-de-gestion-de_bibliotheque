/*
 * ================================================================
 * CODE FOURNI - INF111
 * Noyau client-serveur
 *
 * Auteur original : Professeur Abdelmoumene (Moumene) Toudeft
 * Mise a jour par : Asma Bellili
 * Date de mise a jour : 2026-05-13
 *
 * Ce fichier fait partie du noyau client-serveur fourni aux etudiants.
 * Le code de communication est deja fonctionnel et ne doit pas etre
 * modifie, sauf indication contraire dans l'enonce du travail pratique.
 * ================================================================
 */

package com.atoudeft.serveur;

/**
 * Cette classe permet de cr�er des threads capables d'�couter continuellement sur un objet de type Serveur
 * l'arriv�e de nouveaux clients.
 *
 * @author Abdelmoum�ne Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-09-01
 */
public class ThreadEcouteurDeConnexions extends Thread {

    Serveur serveur;

    /**
     * Construit un thread sur un lecteur
     *
     * @param s Serveur Le serveur sur lequel le thread va �couter
     */
    public ThreadEcouteurDeConnexions(Serveur s) {
        serveur = s;
    }

    /**
     * M�thode principale du thread. Cette m�thode appelle continuellement la m�thode attendConnexion() du serveur.
     */
    public void run() {
        while (!interrupted()) {
            serveur.attendConnexion();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
