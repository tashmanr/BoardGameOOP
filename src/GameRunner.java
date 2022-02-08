enum GameOptions {
    // possible to add new game options once implemented
    CHECKERS,
    DUMMY;
}

public class GameRunner {
    private GameInitializer gameInitializer;

    public GameRunner() {
        gameInitializer = new GameInitializer(pickGame());
    }

    private GameOptions pickGame() {
        // logic to pick kind of game
        return GameOptions.CHECKERS;
    }
}
