public class CarteIndice {
    protected int couleur1;
    protected int couleur2;
    protected int couleur3;
    protected int couleur4;  //0 couleur non atribué
    protected boolean etat; // 0 cacher et 1 afficher
    protected boolean activation; // 0 nn activer et 1 activer
    protected int positionX;
    protected int positionY;


    // metode tostrign
    @Override
    public String toString() {
        return "CarteIndice{" +
                "couleur1=" + couleur1 +
                ", couleur2=" + couleur2 +
                ", couleur3=" + couleur3 +
                ", couleur4=" + couleur4 +
                ", etat=" + etat +
                ", activation=" + activation +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    //Constructeurs
    public CarteIndice(){}

    public CarteIndice(int couleur1, int couleur2, int couleur3, int couleur4, boolean etat, boolean activation, int positionX, int positionY) {
        this.couleur1 = couleur1;
        this.couleur2 = couleur2;
        this.couleur3 = couleur3;
        this.couleur4 = couleur4;
        this.etat = etat;
        this.activation = activation;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // geteur
    public int getCouleur1() {
        return couleur1;}
    public int getCouleur2() {
        return couleur2;}
    public int getCouleur3() {
        return couleur3;}
    public int getCouleur4() {
        return couleur4;}
    public boolean isEtat() {
        return etat;}
    public boolean isActivation() {
        return activation;}
    public int getPositionX() {
        return positionX;}
    public int getPositionY() {
        return positionY;}
}
