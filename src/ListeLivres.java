import java.util.ArrayList;

import java.util.ArrayList;//9.1 //9.8 implement interfcae
import java.util.Iterator;

public class ListeLivres implements IListeLivres,Iterable <Livre>{

    //encapsuler = private
    //pour stocker les objets Livre.
    private ArrayList<Livre> listeLivres;// j ai nomme
    //9.2 initialiser la liste interne.
    public ListeLivres (ArrayList<Livre> listeLivres){
        this.listeLivres = listeLivres ;
    }
    //ou
    public ListeLivres (){
        this.listeLivres = new ArrayList<>();
    }

    //9.3
    //ajoute un livre dans la liste, retourne true si l’ajout a été effectué correctement.
    @Override
    public boolean ajouter(Livre livre){
        boolean ajoutReussi = false  ;
        ajoutReussi = this.listeLivres.add(livre);
        return ajoutReussi ;

    }

    //9.4
    //rechercher dans la liste le livre correspondant à l’identifiant reçu en paramètre,puis le retirer de la liste
    @Override
    public Livre supprimer(int idLivre) {
        Livre livreTrouve;
        // Si le livre est trouvé,  retourner l’objet Livre supprimé. Sinon null
        for (Livre livre : this.listeLivres) {
            if (livre.getId() == idLivre) {
                livreTrouve = livre; //sauvegarder l object
                this.listeLivres.remove(livre); //retirer
                return livreTrouve;
            }
        }
        return null;

    }

    //9.5
    //retourne le livre correspondant à l’identifiant reçu en paramètre. Si aucun livre ne correspond à cet identifiant, la méthode retourne null.
    @Override
    public Livre rechercher(int idLivre)  {
        for(Livre livre :this.listeLivres ) {
            if(livre.getId()== idLivre){
                return livre ;
            }
        }
        return null;
    }


    //9.6
    //retourne true si un livre correspondant à l’identifiant existe dans la liste, retourne false sinon.
    public boolean contient(int idLivre) {
        for (Livre livre : this.listeLivres) {
            if (livre.getId() == idLivre) {
                return true;
            }
        }
        return false;
    }


    //9.7
    public int taille(){
        return this.listeLivres.size();
    }

    public boolean estVide(){
        return this.listeLivres.isEmpty();
    }





    //9.8
    //redéfinir la méthode
    // !!! iterator est une interface
    @Override
    public Iterator<Livre> iterator(){
        //retourne un itérateur permettant de parcourir les livres de la liste.
        return this.listeLivres.iterator();
    }

    //9.9
    //retourner une chaîne de caractères contenant tous les livres présents dans la liste.
    @Override
    public String toString() {
        String chaineLivres = " ";
        for(Livre livre : this.listeLivres )
        {
            chaineLivres += livre+" ,";
        }
        return  chaineLivres ;
    }
}