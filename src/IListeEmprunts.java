//8.2
public interface IListeEmprunts{
//déclarer les méthodes principales nécessaires à la gestion d’une liste d’emprunts.
    public boolean ajouter(Emprunt emprunt);
    public Emprunt supprimer(int idEmprunt);
    public Emprunt rechercher(int idEmprunt);
    public boolean contient(int idEmprunt);
    public int taille();
    public boolean estVide();

}