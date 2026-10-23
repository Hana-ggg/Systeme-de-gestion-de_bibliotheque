import java.util.ArrayList;//10.1 //10.8 implementer l interface
import java.util.Iterator;

//Implémenter la classe ListeEmprunts. Cette classe doit implémenter l’interface IListeEmprunts
public class ListeEmprunts implements IListeEmprunts,Iterable <Emprunt> {
    // utiliser une structure de données de type
    private ArrayList<Emprunt> listeEmprunt;//j ai nomme

    // implémenter un constructeur permettant d’initialiser la liste interne.
    public ListeEmprunts(ArrayList <Emprunt> listeEmprunt)
    {
        this.listeEmprunt =listeEmprunt ;
    }

    //10.2 ou
    public ListeEmprunts()
    {
        this.listeEmprunt =new ArrayList<>();
    }

    //10.3
    //ajoute un emprunt dans la liste et retourne true si l’ajout a été effectué correctement.
    public boolean ajouter(Emprunt emprunt){
        boolean ajoutReussi = false  ;
        ajoutReussi = this.listeEmprunt.add(emprunt);
        return ajoutReussi ;
    }


    //10.4
    //retire de la liste l’emprunt correspondant à l’identifiant reçu en paramètre. Elle retourne l’objet supprimé. Sinon null.
    public Emprunt supprimer(int idEmprunt) {
        Emprunt empruntTrouve ;
        for(Emprunt emprunt : this.listeEmprunt){
            if((emprunt.getId() == idEmprunt) ){
                empruntTrouve = emprunt ;//sauvegarder l object
                this.listeEmprunt.remove(emprunt); //retirer
                return empruntTrouve ;
            }
        }
        return null;
    }

    //10.5
    //retourne l’emprunt correspondant à l’identifiant reçu en paramètre. Sinon null.
    public Emprunt rechercher(int idEmprunt){
        for(Emprunt emprunt : this.listeEmprunt )
        {
            if(emprunt.getId() == idEmprunt){
                return emprunt ;
            }
        }
        return null;
    }


    //10.6
    //retourne true si un emprunt correspondant à l’identifiant existe dans la liste, retourne false sinon.
    public boolean contient(int idEmprunt){
        for(Emprunt emprunt : this.listeEmprunt )
        {
            if(emprunt.getId() == idEmprunt){
            return true;
            }
        }
        return false;
    }

    //10.7
    public int taille(){
        return this.listeEmprunt.size();
    }

    public boolean estVide(){
        return this.listeEmprunt.isEmpty();
    }


    //10.8
    // retourne un itérateur permettant de parcourir les emprunts de la liste.
    @Override
    public Iterator<Emprunt> iterator(){
    // !!! iterator est une interface
        return this.listeEmprunt.iterator();

    }


    //10.8
    //retourner une chaîne de caractères contenant tous les emprunts présents dans la liste.
    @Override
    public String toString() {
        String chaineEmprunt = " ";
        for(Emprunt emprunt: this.listeEmprunt )
        {
            chaineEmprunt += emprunt+" ,";
        }
        return  chaineEmprunt ;

    }

}