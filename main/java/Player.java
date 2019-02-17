import java.util.ArrayList;

public class Player {
    private String name;
    private Card card;
    private ArrayList<Card> cards;


    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
    }
    public void getCard(Card card){
        this.cards.add(card);
    }
    public ArrayList viewCards() {
        return this.cards;
    }
    public int getHandValue(){
        int total = 0;
        for (Card card : this.cards) {
           total += card.getValueFromEnum();
        }
        return total;
    }
//    public void twist(){
//
//    }
    public boolean playerHasAce(){
        for (Card card : this.cards) {
            if (card.getValueFromEnum() == 1){
                return true;
            }
        }
        return false;
    }
    public int getScore(){
        int score = 0;
        for (Card card : this.cards) {
            score += card.getValueFromEnum();
            }
        if (this.playerHasAce() && score <= 11){
            score += 10;
        }
        return score;
    }

}
