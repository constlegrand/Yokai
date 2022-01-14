import java.util.*;

public class Board {
    private List<Card> gameBoard = new ArrayList<>();
    private List<HintCard> hintPrepared = new ArrayList<>();
    private List<HintCard> hintUsed  =new ArrayList<>();

    public void createGameBoard(){
        this.gameBoard.clear();
        this.hintPrepared.clear();
        this.hintUsed.clear();
        char[] colors = {'b', 'b', 'b', 'b', 'r', 'r', 'r', 'r', 'g', 'g', 'g', 'g', 'p', 'p', 'p', 'p'};
        List<Character> colorsList = new ArrayList<Character>();
        for(int i = 0; i<colors.length; i++){
            colorsList.add(colors[i]);
        }
        Collections.shuffle(colorsList);

        int index =0;
        int y= 0 ;
        int x = 0;
        for (char color : colorsList) {
            Position position = new Position(x,y);
            Card card = new Card(color, index, position);
            this.gameBoard.add(card);
            index++;
            x = index % 4;
            y = index / 4;
        }
    }

    public List<Card> getGameBoard() {
        return gameBoard;
    }

    public List<HintCard> getHintPrepared(){
        return hintPrepared;
    }

    public List<HintCard> getHintUsed(){
        return hintUsed;
    }

    public void addHintPrepared(HintCard hintCard){
        this.hintPrepared.add(hintCard);
    }

    public void removeHintPrepared(int index){
        this.hintPrepared.remove(index);
    }

    public void addHintUsed(HintCard hintCard){
        this.hintUsed.add(hintCard);
    }
}
