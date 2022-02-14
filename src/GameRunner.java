enum GameOptions {
    // possible to add new game options once implemented
    CHECKERS,
    DUMMY;
}

public class GameRunner {
    //private GameInitializer gameInitializer;
    private static GameRunner runnerInstance = null;
    private ScoreBoard scoreBoard;

    private GameRunner() {
        Game game = new GameInitializer().getGame(pickGame(), getPlayers());
        scoreBoard = ScoreBoard.getInstance();
        game.start();
    }

    public static GameRunner getInstance(){
        if (runnerInstance == null){
            runnerInstance = new GameRunner();
        }
        return runnerInstance;
    }

    private GameOptions pickGame() {
        // logic to pick kind of game
        return GameOptions.CHECKERS;
    }

    private Tuple<Player, Player> getPlayers() {
        int players = 1; // TODO later give option to change players #
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
