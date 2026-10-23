
//7.3
//sous class Professeur herite de class Utilisateur
public class Professeur extends Utilisateur {

    //redéfini les attributs hérités (en dehors de constructeur)
    private static final int MAX_EMPRUNT = 10;
    // la pénalité est de 0.75 $ par jour de retard
    private static final double PENALTY = 0.25;
    public Professeur(int id, String nom) {
        super(id, nom);
    }


    public int getMAX_EMPRUNT() {
        return this.MAX_EMPRUNT;
    }

    public double getPENALTY() {
        return this.PENALTY;
    }

    @Override //redefinir methode de l class mere abstrait Utilisateur
    public int nombreMaxEmprunts() {
        return getMAX_EMPRUNT();
    }

    @Override //redefinir methode de l class mere abstrait Utilisateur
    public double calculerPenalite(int joursRetard) {
        double penaliteCalcule = 0;
        penaliteCalcule = getPENALTY() * joursRetard;
        return penaliteCalcule;
    }

    @Override //redefinir methode de l class mere abstrait Utilisateur
    public  TypeUtilisateur getTypeUtilisateur() {
        return TypeUtilisateur.PROFESSEUR;  //enum
    }

}