import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestPlayer {
    Deck deck;
    Player player1;
    ArrayList<Card> cards;
    Card aceClubs, fourHearts, fiveSpades, tenHearts, aceSpades;


    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player("Mark");
        cards = new ArrayList<>();
        aceClubs = new Card(SuitType.CLUBS, RankType.ACE);
        aceSpades = new Card(SuitType.SPADES, RankType.ACE);
        fiveSpades = new Card(SuitType.SPADES, RankType.FIVE);
        fourHearts = new Card(SuitType.HEARTS, RankType.FOUR);
        tenHearts = new Card(SuitType.HEARTS, RankType.TEN);
    }

    @Test
    public void testPlayerGetsCards(){
        deck.populateDeck();
        deck.shuffleDeck();
        player1.getCard(deck.dealCard());
        player1.getCard(deck.dealCard());
        assertEquals(2, player1.viewCards().size());
        cards = player1.viewCards();
        for (Card card : cards) {
            System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
        }
    }
    @Test
    public void testPlayerScore(){
        deck.populateDeck();
        deck.shuffleDeck();
        player1.getCard(deck.dealCard());
        player1.getCard(deck.dealCard());
        assertEquals(2, player1.viewCards().size());
        cards = player1.viewCards();
        for (Card card : cards) {
            System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
        }
        int total = player1.getHandValue();
        System.out.println("Card Total:" + total);
    }
    @Test
    public void testPlayerHasAce(){
        player1.getCard(aceClubs);
        player1.getCard(fourHearts);
        assertEquals(2, player1.viewCards().size());
        player1.checkIfPlayerHasAce();
        boolean hasAce = player1.hasAce();
        assertEquals(true, hasAce);
    }
    @Test
    public void testPlayerHasntAce(){
        player1.getCard(fiveSpades);
        player1.getCard(fourHearts);
        assertEquals(2, player1.viewCards().size());
        player1.checkIfPlayerHasAce();
        boolean hasAce = player1.hasAce();
        assertEquals(false, hasAce);
    }
    @Test
    public void testGetScore(){
        player1.getCard(fourHearts);
        player1.getCard(tenHearts);
        int value = player1.getScore();
        assertEquals(14, value);
    }
    @Test
    public void testGetScoreWithAces(){
        player1.getCard(aceSpades);
        player1.getCard(aceClubs);
        player1.checkIfPlayerHasAce();
        int value = player1.getScore();
        assertEquals(12, value);
    }
    @Test
    public void testGetScoreWithBlackJack(){
        player1.getCard(aceSpades);
        player1.getCard(tenHearts);
        player1.checkIfPlayerHasAce();
        int value = player1.getScore();
        assertEquals(21, value);
    }
}

