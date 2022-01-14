import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<HintCard> cards = new ArrayList<>();

    public void schuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public HintCard drawCard(){
        HintCard card = this.cards.get(0);
        this.cards.remove(0);
        return card;
    }

    public List<HintCard> getCards(){
        return this.cards;
    }

    public void createDeck(int nbPlayer){

        this.cards.clear();

        String[] color1 = {"1g", "1r", "1b", "1p"};
        List<String> color1List = new ArrayList<String>(Arrays.asList(color1));
        Collections.shuffle(color1List);

        String[] color2 = {"2gb", "2gr", "2gp", "2br", "2bp", "2rp"};
        List<String> color2List = new ArrayList<String>(Arrays.asList(color2));
        Collections.shuffle(color2List);

        String[] color3 = {"3gpr", "3bpr", "3bgr", "3bgp"};
        List<String> color3List = new ArrayList<String>(Arrays.asList(color3));
        Collections.shuffle(color3List);

        switch (nbPlayer){
            case 2:
                color1List.remove(0);
                color1List.remove(0);
                color2List.remove(0);
                color2List.remove(0);
                color2List.remove(0);
                color3List.remove(0);
                color3List.remove(0);
                break;
            case 3:
                color1List.remove(0);
                color1List.remove(0);
                color2List.remove(0);
                color2List.remove(0);
                color3List.remove(0);
                break;
            case 4:
                color1List.remove(0);
                color2List.remove(0);
                color2List.remove(0);
                color3List.remove(0);
                break;
        }
        int index = 16;
        for (String color : color1List) {
            HintCard hintCard = new HintCard(index, color);
            this.cards.add(hintCard);
            index++;
        }
        for (String color : color2List) {
            HintCard hintCard = new HintCard(index, color);
            this.cards.add(hintCard);
            index++;
        }
        for (String color : color3List) {
            HintCard hintCard = new HintCard(index, color);
            this.cards.add(hintCard);
            index++;
        }
        this.schuffleDeck();
        System.out.println(this.cards);

        return;
    }

}