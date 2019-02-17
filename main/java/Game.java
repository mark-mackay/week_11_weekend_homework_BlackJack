import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Player dealer;



    public Game(){
        players = new ArrayList<>();
        deck = new Deck();
        dealer = new Player("Dealer");
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void setupGame(){
        this.addPlayer(dealer);
        this.deck.populateDeck();
        this.deck.shuffleDeck();
        this.initialDeal();
        this.checkPlayersForAces();
        Card dealerCard = dealer.showDealerCard();
        this.players.remove(dealer);
        System.out.println("Dealer Shown Card is: " + dealerCard.getRank().toString() + " " + dealerCard.getSuit().toString());
    }
    public void playGame(){
        this.setupGame();
//        this.playRound();

//        System.out.println("playRound Complete.");
//        if (this.viewPlayers() > 0) {
//            this.playDealer();
//            this.getWinners();
//        } else {
//            System.out.println("House Wins");
//        }
    }

//    public void playRound(){
//        for (Player player: this.players) {
//            this.takeTurn(player);
//        }
//    }
    public void takeTurn(Player player, boolean twist){
        player.showPlayerGame();
            if (twist) {
                this.twist(player);
                System.out.println("Twist");
                player.showPlayerGame();
            }
            else {
                System.out.println("Stick");
            }
            if (player.getScore() > 21) {
                System.out.println("Busted!");
            }

    }

    public void playDealer(){
        while (dealer.getScore() <= 16 ) {
            System.out.println("Score is 16 or under autotwisting");
            this.twist(dealer);
        }
        if (dealer.getScore() <= 21) {
            this.takeTurn(dealer, false);
        } else {
            System.out.println("Dealer Busted");
        }
    }

    public void initialDeal(){
        for (int n = 1; n <= 2; n++) {
            for (Player player : this.players) {
                player.getCard(deck.dealCard());
            }
        }
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }

    public int viewPlayers(){
        return this.players.size();
    }

    public Player getWinner(){
        Player winner = this.players.get(0);
        for (Player player : this.players) {

            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        return winner;
    }
    public void checkPlayersForAces(){
        for (Player player : this.players) {
            player.checkIfPlayerHasAce();
        }
    }

    public void twist(Player player){
        Card newCard = deck.dealCard();
        if (newCard.getValueFromEnum() == 1) {
            player.toggleHasAce();
        }
        player.getCard(newCard);
        if (player.getScore() > 21) {
            this.players.remove(player);
            System.out.println("Player Busted, Player Removed!");
        }
    }

    public void getWinners(){
        for (Player player : this.players){
            if (player.getScore() > dealer.getScore() || dealer.getScore() > 21){
                System.out.println("Player: " + player.getName() + " has beat the dealer");
            }
        }
    }
}
