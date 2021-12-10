import java.util.ArrayList;
import java.util.List;

public class Deck {
    protected int taille;
    protected List<CarteIndice> paquet=new ArrayList<>(14);
    protected int carteI;
    // paquet=[[couleur1,couleur2,couleur3,couleur4,état,activation, positionX,positionX],[couleur1,couleur2,couleur3,couleur4,état,activation, positionX,positionX]etc...]

    public void addCarte(CarteIndice carteI){
        paquet.add(carteI);
   }

    public List getPaquet() {
        System.out.println(paquet);
        return paquet;
    }

    public void melanger(){

    }

    public void piocheCarte(){

    }

    @Override
    public String toString() {
        return getPaquet().toString();
    }
}
