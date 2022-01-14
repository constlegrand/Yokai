import javax.annotation.processing.SupportedAnnotationTypes;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public int nbPlayer;
    public List<Integer> score = new ArrayList<>();
    public Board board = new Board();
    public Deck hintDeck = new Deck();
    public int round = 0;

    public void newGame(){
        this.choosePlayerNumber();
        this.playGame();
    }

   public void choosePlayerNumber(){
        Scanner scn = new Scanner(System.in);
        String input;
        int nbPlayer;

        System.out.println("Choose nb of player");
        while(true){
            input = scn.nextLine();
            nbPlayer =Integer.parseInt(input, 10);
            this.nbPlayer=nbPlayer;
            System.out.println(nbPlayer);
            break;
            }
        }

    public void roundInitialization(){
       this.board.createGameBoard();
       this.hintDeck.createDeck(this.nbPlayer);

       for (Card yokai : this.board.getGameBoard()) {
           yokai.setfamillyCardNextTo(isNeighborColor(yokai));
       }

    }

    public void playGame(){
        this.roundInitialization();
        System.out.println("fin init");
        this.playturn();
    }

    public void winRound(){
        Scanner scn = new Scanner(System.in);

        System.out.println(" u won this round ");
        scoring();
        System.out.println("do u want to play another round \n 1 : yes");
        int value = scn.nextInt();
        if (value==1){
            this.round++;
            this.playGame();
        }else{
            this.endGame();
        }

    }

    public void looseRound(){
        Scanner scn = new Scanner(System.in);
        System.out.println(" u lost this round ");
        this.score.add(0);
        System.out.println("do u want to play another round \n 1 : yes");
        int value = scn.nextInt();
        if (value==1){
            this.round++;
            this.playGame();
        }else{
            this.endGame();
        }
    }

    public void scoring(){
        int unpreparedHint = this.hintDeck.getCards().size() * 5;
        int unusedHint = this.board.getHintPrepared().size() * 2;

        int trueHint = 0;
        int falseHint = 0;
        for(HintCard hintCard: this.board.getHintUsed()){
            for(Card card: this.board.getGameBoard()){
                if(hintCard.getPosition() == card.getPosition()){
                    for (char color : hintCard.getColors()) {
                        if (color == card.getColor()) {
                            trueHint++;
                        }else{
                            falseHint++;
                        }
                    }

                }
            }
        }
        int goodHint = trueHint-falseHint;

        int roundScore = goodHint + unusedHint + unpreparedHint;
        this.score.add(roundScore);
        int totalscore= 0;
        for(int i = 0 ; i<score.size(); i++){
            totalscore = totalscore + score.get(i);
        }
        System.out.println("ur round score is "+ roundScore);
        switch (this.nbPlayer){
            case 2 :
                if(roundScore < 8){
                    System.out.println("Honorable");
                }else if (roundScore < 12){
                    System.out.println("Glorieuse");
                }else{
                    System.out.println("Totale");
                }
                break;
            case 3 :
                if(roundScore < 9){
                    System.out.println("Honorable");
                }else if (roundScore < 14){
                    System.out.println("Glorieuse");
                }else{
                    System.out.println("Totale");
                }
                break;
            case 4 :
                if(roundScore < 10){
                    System.out.println("Honorable");
                }else if (roundScore < 15){
                    System.out.println("Glorieuse");
                }else{
                    System.out.println("Totale");
                }
        }
        System.out.println("ur total score is "+ totalscore);
        System.out.println("ur previous score are : ");
        for(int index = this.score.size()-1; index> this.score.size()-5; index--){
            System.out.println(this.score.get(index));
        }
       return;
   }

    public void endGame(){
        System.out.println("thx for playing");
        //quit

  }

  public void playturn(){
        while (true){
            for(int index = 0; index<nbPlayer; index++){

                if (this.board.getHintPrepared().size()==0 && this.hintDeck.getCards().size()==0){
                    System.out.println("all hint r used");
                    sootheSpirit();
                }

                System.out.println("it's player " + index + "'s turn");

                Scanner scn0 = new Scanner(System.in);
                Scanner scn1 = new Scanner(System.in);
                Scanner scn2 = new Scanner(System.in);
                Scanner scn3 = new Scanner(System.in);
                Scanner scn4 = new Scanner(System.in);
                Scanner scn5 = new Scanner(System.in);

                System.out.println("are spirits quiet ? Y/N");
                String input = scn0.nextLine();
                if (input  == "Y"){
                    sootheSpirit();
                }
                for(int i = 0; i<1; i++) {
                    System.out.println("where do u want to look");
                    System.out.println("enter position");
                    int inputx = scn1.nextInt();
                    int inputy = scn2.nextInt();
                    Position position = new Position(inputx, inputy);
                    lookYokai(position);
                }
                System.out.println("where do u want to look");
                System.out.println("enter position");
                int inputx = scn3.nextInt();
                int inputy = scn4.nextInt();
                Position position = new Position(inputx, inputy);
                mooveYokai(position);
                System.out.println("so do u want to use (1) or prepare (2)");
                int value = scn5.nextInt();
                if(value == 2 || this.board.getHintPrepared().size()==0){
                    prepareHint();
                }else{
                    useHint();
                }
            }
        }
  }

  public void sootheSpirit(){
if (areSpiritSoothe()==true){
    this.winRound();

}else{
    this.looseRound();
}
  }

  public void mooveYokai(Position fromPosition){
      Boolean isValidMove = false;
      Position newPosition= new Position(0,0);

      while(!isValidMove) {

          Scanner scn = new Scanner(System.in);
          Scanner scn1 = new Scanner(System.in);

          System.out.println("enter position");
          int inputx = scn.nextInt();
          int inputy = scn1.nextInt();
          newPosition = new Position(inputx, inputy);

          isValidMove = isValidMove(fromPosition, newPosition);
          if (isValidMove == false){
              System.out.println("move not possible");
          }
      }
      for (Card yokai : this.board.getGameBoard()) {
          if (yokai.getPosition() == fromPosition) {
              yokai.setPosition(newPosition);
              yokai.setfamillyCardNextTo(isNeighborColor(yokai));
              }
          }
      }

  public boolean isValidMove(Position fromPosition, Position toPosition) {

       for (HintCard hint: this.board.getHintUsed()){ //verifie si il n'y a as un indic utilise au dessus de la carte
           if (hint.getPosition()==fromPosition)
               return false;
       }

      for (Card yokai : this.board.getGameBoard()) { // verifie si il n'y a pas un yokai a la destination
          if (yokai.position == toPosition){
              return false;
          }
      }
      List<Card> board = this.board.getGameBoard();
      for (Card yokai : board) { //verifie si le yokai deplace est bien a cote d'autres yokai
          if (yokai.getPosition() == fromPosition) {
                yokai.setPosition(toPosition);
                if (isNeighbor(yokai)==false){
                    return false;
                }
          }
      }
      return true;
  }

  public void lookYokai(Position position){
        List<Card> board = this.board.getGameBoard(); // CHECK SI Y ABIEN YOKAI
        for (Card yokai : board) {
            if (yokai.position == position){
                yokai.getColor();
            }
        }
  }

  public void prepareHint(){
        HintCard hintCard = this.hintDeck.drawCard();
        this.board.addHintPrepared(hintCard);
  }

  public void useHint() {
        Scanner scn = new Scanner(System.in);
      System.out.println("which hint do u want to use");
      int index = 0;
      for (HintCard hintCard : this.board.getHintPrepared()){
          System.out.println(index +"/ " +  hintCard.getJpg());
          index++;
      }
      int value = scn.nextInt();
      HintCard hintCard = this.board.getHintPrepared().get(value);
      this.board.getHintPrepared().remove(value);

      Position newPosition = new Position(0,0);
      int i =0;
      while(i==0) {
          System.out.println("where do u want to place hint");
          Scanner scn2 = new Scanner(System.in);
          Scanner scn1 = new Scanner(System.in);

          System.out.println("enter position");
          int inputx = scn2.nextInt();
          int inputy = scn1.nextInt();
          newPosition = new Position(inputx, inputy);

          for(Card card : this.board.getGameBoard(  )){ // verifie si il y a bien une carte a l'endroit ou l'on veut mettre l'indice
              if(card.getPosition() == newPosition){    //
                  i = 1;
                  break;
              }
          }
      }
      hintCard.setPosition(newPosition);
      this.board.addHintUsed(hintCard);
  }

  public boolean areSpiritSoothe(){
        List<Card> board = this.board.getGameBoard();
        for(Card yokai: board ){
            if (yokai.getfamillyCardNextTo()==false){
                return false;
            }
        }
        return true;
  }

    public boolean aboveColor(Card card){
        char color = card.color;
        List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x;
        int ycardPosition = 1 + card.position.y;
        for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition && cell.color==color){
                return true;
            }

        }
        return false;
    }
    public boolean belowColor(Card card){
        char color = card.color;
        List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x;
        int ycardPosition = card.position.y - 1;
        for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition && cell.color==color){
                return true;
            }

        }
        return false;
    }
    public boolean rightColor(Card card){
        char color = card.color;
        List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x + 1;
        int ycardPosition = card.position.y;
        for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition && cell.color==color){
                return true;
            }

        }
        return false;
    }
    public boolean leftColor(Card card){
        char color = card.color;
        List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x - 1;
        int ycardPosition = card.position.y;
        for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition && cell.color==color){
                return true;
            }

        }
        return false;
    }
    public boolean isNeighborColor(Card card){
        if(leftColor(card)||rightColor(card)||aboveColor(card)||belowColor(card)){
            return true;
        }
        return false;
    }

    public boolean above(Card card){
      List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x;
        int ycardPosition = 1 + card.position.y;
      for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition){
                return true;
            }

      }
      return false;
  }
    public boolean below(Card card){
        List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x;
        int ycardPosition = card.position.y - 1;
        for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition){
                return true;
            }

        }
        return false;
    }
    public boolean right(Card card){
        List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x + 1 ;
        int ycardPosition = card.position.y;
        for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition){
                return true;
            }

        }
        return false;
    }
    public boolean left(Card card){
        List<Card> board = this.board.getGameBoard();
        int xcardPosition = card.position.x - 1;
        int ycardPosition = 1 + card.position.y;
        for(Card cell: board ) {
            if(cell.position.x == xcardPosition && cell.position.y == ycardPosition){
                return true;
            }

        }
        return false;
    }
    public boolean isNeighbor(Card card){
        if(left(card)||right(card)||above(card)||below(card)){
            return true;
        }
        return false;
    }


}
