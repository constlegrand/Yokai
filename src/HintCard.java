import java.util.ArrayList;
import java.util.List;

public class HintCard {
    public Position position;
    public int id;
    public String jpg;
    public List<Character> Colors = new ArrayList<>();

    public HintCard(int id, String jpg){
        this.id = id;
        this.jpg = jpg;
        this.setColorsList();
    }

    public int getId() {
        return id;
    }

    public String getJpg() {
        return jpg;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setColorsList() {
        String s = this.jpg;
        for (int i = 1; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            this.Colors.add(currentCharacter);
        }
    }

    public List<Character> getColors(){
        return this.Colors;
    }
}
