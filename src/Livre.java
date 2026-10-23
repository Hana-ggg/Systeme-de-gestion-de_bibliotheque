public class Livre {//2.1
    private int id;
    private String titre;
    private String auteur;
    private String categorie;
    private StatutLivre statut;



    private static int  DUREE_MAX_EMPRUNT = 40 ;//2.2

    //2.2
    // Implémenter une méthode statique nommée prochainID() qui retourne un numéro séquentiel
    //commençant à 1
    //utiliser un attribut statique dans la classe Livre.
    private static int numeroSequentiel=0;
    public static int prochaineID(){
        numeroSequentiel+=1;
        return numeroSequentiel;
    }

    //2.3
    public Livre(String titre,String auteur,String categorie){
        this.titre = titre;
        this.auteur = auteur;
        this.categorie= categorie;
        this.id = prochaineID();
        this.statut=StatutLivre.DISPONIBLE;

    }
    public int getId(){
        return this.id;
    }
    public String getTitre(){
        return this.titre;
    }
    public String getAuteur(){
        return this.auteur;
    }
    public String getCategorie(){
        return this.categorie;
    }
    public StatutLivre getStatut(){
        return this.statut;
    }
    public void setStatut(StatutLivre statut){
        this.statut = statut ;
    }
    public static int getDureeMaxEmprunt() {
        return DUREE_MAX_EMPRUNT;
    }

    //2.4
    @Override
    public String toString() {
        return"titre: "+ titre+ " ,auteur: "+ auteur+ " ,categorie: "+ categorie+ " ,id: " + id + " ,statut: " + statut + " ,duree max d emprunt: " + DUREE_MAX_EMPRUNT   ;
    }
    //2.6(pas de 2.5)
    //Deux objets Livre sont considérés égaux s’ils possèdent le même identifiant.
    @Override
    public boolean equals(Object obj) {
        //if(this== obj) //les 2 objets sont en fait le même
        //returntrue;
        //if(obj== null)
        //returnfalse;
        if(obj instanceof Livre) {
            Livre l = (Livre) obj;
            return id == l.id; //this.id.equals(cpt.id);
        }
        else
            return false;
    }

}
