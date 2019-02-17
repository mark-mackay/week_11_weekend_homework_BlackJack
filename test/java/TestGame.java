import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGame {

    private Game game;
    private Player player1, player2, player3;


    @Before
    public void before(){
        game = new Game();
        player1 = new Player("Mo");
        player2 = new Player("Mark");
        player3 = new Player("Katie");

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
//    @Test
//    public void testGame(){
//        game.addPlayer(player1);
//        game.addPlayer(player2);
//        Player winner = game.playGame();
//        System.out.println("Player 1: " + player1.getScore());
//        System.out.println("Player 2: " + player2.getScore());
//        System.out.println("Winner: " + winner.getScore());
////        System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
//    }
//    @Test
//    public void testGameWithTwist(){
//        game.addPlayer(player1);
//        game.addPlayer(player2);
//        game.addPlayer(player3);
//        Player winner = game.playGame();
//        System.out.println("Player 1: " + player1.getScore());
//        System.out.println("Player 2: " + player2.getScore());
//        System.out.println("Player 3: " + player3.getScore());
//
//        game.twist(player1);
//        game.twist(player2);
//        game.twist(player3);
//
//        for (Player player: game.getPlayers()) {
//            System.out.println("Player: "+ player.getName()+" Score:" + player.getScore());
//        }
//        System.out.println("--------------------------------");
//        System.out.println("Player 1: " + player1.getScore());
//        System.out.println("Player 2: " + player2.getScore());
//        System.out.println("Player 3: " + player3.getScore());
//        System.out.println("Winner: " + winner.getScore());
////        System.out.println(card.getRank().toString() + " " + card.getSuit().toString());
//    }
    @Test
        public void testInteractiveGame(){
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.playGame();
        while (player1.getScore() <= 16) {
            game.takeTurn(player1, true);
        }
        while (player2.getScore() <= 16) {
            game.takeTurn(player2, true);
        }
        while (player3.getScore() <= 16) {
            game.takeTurn(player3, true);
        }
        game.playDealer();
        game.getWinners();
    }

}
