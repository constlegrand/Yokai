public class CartePerso {
    public int perso;
    public boolean etat; // 0 cacher et 1 afficher
    public int positionX;
    public int positionY;

    // metode tostrign
    @Override
    public String toString() {
        return "CartePerso{" +
                "perso=" + perso +
                ", etat=" + etat +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }


    //constructeur
    public CartePerso(int perso, boolean etat, int positionX, int positionY){
        this.perso=perso;
        this.etat=etat;
        this.positionX=positionX;
        this.positionY=positionY;
    }

    //geteur
    public int getPerso() {
        return perso;}
    public boolean isEtat() {
        return etat;}
    public int getPositionX() {
        return positionX;}
    public int getPositionY() {
        return positionY;}
}
