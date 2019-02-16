import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeck {
    Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void testCardArray(){
        deck.populateDeck();
        assertEquals(52, deck.deckSize());
    }

    @Test
    public void testShuffle(){
        deck.populateDeck();
        deck.shuffleDeck();
        Card card = deck.getCard(0);

        System.out.println(card.getRank().toString() + " " + card.getSuit().toString());

    }
}
