import java.util.Scanner;

public class Jeu {

    protected Deck deckIndice = new Deck();
    protected Deck deckPerso = new Deck();


    public void initsialisation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coubien il y a t'il de joureu?");
        int joueur= scanner.nextInt();
        int Carte1C=0;
        int Carte2C=0;
        int Carte3C=0;

        if (joueur==2) {
            Carte1C=2;
            Carte2C=3;
            Carte3C=2;
            }
        if (joueur==3) {
            Carte1C=2;
            Carte2C=4;
            Carte3C=3;
        }
        if (joueur==4) {
            Carte1C=3;
            Carte2C=4;
            Carte3C=3;
        }


        // Carte 1 couleur
        for (int i = 0; i < Carte1C; i++) {
            int n1 = (int) (Math.random() * 4) + 1;

            CarteIndice carteI = new CarteIndice();
            carteI.couleur1 = n1;
            carteI.couleur2 = 0;
            carteI.couleur3 = 0;
            carteI.couleur4 = 0;
            carteI.etat = false;
            carteI.activation = false;
            deckIndice.addCarte(carteI);
        }

        // Carte 2 couleur
        for (int i = 0; i < Carte2C; i++) {
            int n1 = (int) (Math.random() * 4) + 1;
            int n2 = (int) (Math.random() * 4) + 1;

            CarteIndice carteI = new CarteIndice();
            carteI.couleur1 = n1;
            carteI.couleur2 = n2;
            carteI.couleur3 = 0;
            carteI.couleur4 = 0;
            carteI.etat = false;
            carteI.activation = false;
            deckIndice.addCarte(carteI);
        }

        // Carte 3 couleur
        for (int i = 0; i < Carte3C; i++) {
            int n1 = (int) (Math.random() * 4) + 1;
            int n2 = (int) (Math.random() * 4) + 1;
            int n3 = (int) (Math.random() * 4) + 1;

            CarteIndice carteI = new CarteIndice();
            carteI.couleur1 = n1;
            carteI.couleur2 = n2;
            carteI.couleur3 = n3;
            carteI.couleur4 = 0;
            carteI.etat = false;
            carteI.activation = false;
            deckIndice.addCarte(carteI);
        }
        for (int i = 1; i < 16; i++) {
            int numperso=0;
            if i<8 & i {

            }

            for (int j = 4; j < 4; i++) {
                CartePerso carteP = new CartePerso();
                carteP.perso=1;
                carteP.etat=false;
                carteP.positionX=0;
                carteP.positionY=0;
                deckPerso.addCarte(carteP);
            }
        }
    }

    @Override
    public String toString() {
        return deckIndice.toString();
    }
}
