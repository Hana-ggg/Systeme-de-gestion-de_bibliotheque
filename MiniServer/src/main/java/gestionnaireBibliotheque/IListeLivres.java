package gestionnaireBibliotheque;

//8.1
public interface IListeLivres {
//déclarer les méthodes principales nécessaires à la gestion d’une liste de livres
    public boolean ajouter(Livre livre);
    public Livre supprimer(int idLivre);
    public Livre rechercher(int idLivre);
    public boolean contient(int idLivre);
    public int taille();
    public boolean estVide();

}