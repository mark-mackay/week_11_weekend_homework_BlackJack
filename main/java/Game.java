import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;



    public Game(){
        players = new ArrayList<>();
        deck = new Deck();
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public Player playGame(){
        this.deck.populateDeck();
        this.deck.shuffleDeck();
        this.initialDeal();
////        for (Player player : this.players){
////            player.getCard(deck.dealCard());
////        }
////        return this.getWinner();
        return getWinner();
    }
    public void initialDeal(){
        for (int n = 1; n <= 2; n++) {
            for (Player player : this.players) {
                player.getCard(deck.dealCard());
            }
        }
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

//    public Player getWinner(){
//        Player winner = new Player("Bogus");
//        winner = players.get(0);
//        for (Player player : this.players){
//            if (player.viewCard().getValueFromEnum() > winner.viewCard().getValueFromEnum()){
//                winner = player;
//            }
//        }
//        return winner;
//    }
}
