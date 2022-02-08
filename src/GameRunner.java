enum GameOptions {
    // possible to add new game options once implemented
    CHECKERS,
    DUMMY;
}

public class GameRunner {
    private GameInitializer gameInitializer;

    public GameRunner() {
        Game game = new GameInitializer().getGame(pickGame(), getPlayers());
        game.start();
//        while (!isOver){
//            //play turn
//            if ()
//            //check if game is over
//            //switch turn
//            player1Turn = !player1Turn;
//        }
    }

    private GameOptions pickGame() {
        // logic to pick kind of game
        return GameOptions.CHECKERS;
    }

    private Tuple<Player, Player> getPlayers() {
        int players = 1; // later give option to change players #
        Player p1 = new HumanPlayer();
        Player p2;
        if (players == 1) {
            p2 = new ComputerPlayer();
        } else {
            p2 = new HumanPlayer();
        }
        return new Tuple<>(p1, p2);
    }
}
