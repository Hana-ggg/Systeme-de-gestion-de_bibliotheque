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

package com.atoudeft.commun.evenement;

/**
 * Classe utilitaire fournissant des m�thodes pour manipuler des �v�nements.
 */
public class EvenementUtil {
    /*
      Contructeur priv� pour emp�cher l'instanciation (inutile) de la classe.
    */
    private EvenementUtil() {
    }
    /**
     * M�thode utilitaire qui extrait � partir d'une chaine de caract�res le type et l'argument d'un �v�nement.
     *
     * @param str chaine de caract�res d�crivant l'�v�nement
     * @return String[] tableau de taille 2 contenant le type et l'argument de l'�v�nement
     */
    public static String[] extraireInfosEvenement(String str) {

        str = str.trim();

        if ("".equals(str))
            return new String[]{"", ""};
        else {
            int i = str.indexOf(' ');
            if (i == -1)
                return new String[]{str, ""};
            else
                return new String[]{str.substring(0, i), str.substring(i).trim()};
        }
    }
}