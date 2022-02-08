public class GameInitializer {

    public GameInitializer(GameOptions option) {
        Game game;
        if (option == GameOptions.CHECKERS) {
            game = new CheckersGame();
        } else {
            game = new DummyGame();
        }
        game.loadGame();
        game.start();
    }
}
