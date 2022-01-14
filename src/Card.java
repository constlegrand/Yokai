public class Card {
    public Position position;
    public int id;
    public char color;
    public boolean cardNextTo = true;
    public boolean famillyCardNextTo;

    public Card(char color, int id,  Position position){
        this.id = id;
        this.color = color;
        this.position = position;
    }

    public void setColor(char color){
        this.color = color;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public char getColor(){
        return this.color;
    }

    public Position getPosition(){
        return this.position;
    }

    public void printData(){
        System.out.println("ID: " + this.id + " => color :"+ this.color+ " [" + this.position.x  +" , " + this.position.y+ " ]" );

       // System.out.println("ID: " + this.id + " => color :"+ this.color );

    }

    public boolean getfamillyCardNextTo(){
        return this.famillyCardNextTo;
    }

    public void setfamillyCardNextTo(boolean value){
        this.famillyCardNextTo = value;
    }
}
