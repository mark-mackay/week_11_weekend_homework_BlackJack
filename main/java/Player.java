import java.util.ArrayList;

public class Player {
    private String name;
    private Card card;
    private ArrayList<Card> cards;
    private boolean hasAce;


    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
        this.hasAce = false;
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
    public void checkIfPlayerHasAce(){
        for (Card card : this.cards) {
            if (card.getValueFromEnum() == 1) {
                this.hasAce = true;
            }
        }
    }
    public int getScore(){
        int score = 0;
        for (Card card : this.cards) {
            score += card.getValueFromEnum();
            }
        if (this.hasAce && score <= 11){
            score += 10;
        }
        return score;
    }
    public boolean hasAce(){
        return this.hasAce;
    }

    public void twist(){
        int value = this.getScore();
    }

}
