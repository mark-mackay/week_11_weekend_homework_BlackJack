import java.util.ArrayList;

public class Player {
    private String name;
    private Card card;
    private ArrayList<Card> cards;
    private boolean hasAce;
    private boolean sticking;


    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<>();
        this.hasAce = false;
        this.sticking = false;
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
    public void toggleHasAce(){
        this.hasAce = true;
    }

    public void twist(){
        int value = this.getScore();
    }
    public String getName(){
        return this.name;
    }
    public boolean isPlayerSticking(){
        return this.sticking;
    }
    public void playerSticks() {
        this.sticking = true;
    }
    public Card showDealerCard(){
        return this.cards.get(1);
    }
    public String showCards() {
        String cardOutput = "";
        for (Card card : this.cards) {
             cardOutput += "The " + card.getRank() + " of " + card.getSuit() + "\n";
        }
        return cardOutput;
    }
    public void showPlayerGame(){
        System.out.println("Player: " + this.getName());
        System.out.println("Your current score is: " + this.getScore());
        System.out.println("Your cards are: \n" + this.showCards());
    }
}
