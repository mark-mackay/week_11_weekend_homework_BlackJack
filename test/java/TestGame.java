import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {

    private Game game;
    private Player player1;
    private Player player2;


    @Before
    public void before(){
        game = new Game();
        player1 = new Player("Mo");
        player2 = new Player("Mark");

    }
    @Test
    public void testAddPlayers(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        assertEquals(2, game.viewPlayers());
    }
//    @Test
//    public void testPlayerHasCard(){
//        game.addPlayer(player1);
//        game.addPlayer(player2);
//        game.playGame();
//        Card card = player1.viewCard();
//        System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
//    }
//
    @Test
    public void testGame(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        Player winner = game.playGame();
        System.out.println("Player 1: " + player1.getScore());
        System.out.println("Player 2: " + player2.getScore());
        System.out.println("Winner: " + winner.getScore());
//        System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
    }
}
