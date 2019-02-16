import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private SuitType[] suits;
    private RankType[] ranks;

    public Deck(){
        this.cards = new ArrayList<>();
        this.suits = SuitType.values();
        this.ranks = RankType.values();
    }

    public void populateDeck(){
        for ( SuitType suit : suits ){
            for (RankType rank : ranks) {
                Card card = new Card(suit, rank);
                this.cards.add(card);
            }
        }
    }
    public int deckSize(){
        return this.cards.size();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card getCard(int value){
        return this.cards.get(value);
    }

    public Card dealCard(){
        return this.cards.remove(0);
    }




}
