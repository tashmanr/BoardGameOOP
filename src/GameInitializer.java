public class GameInitializer {
    private Game game;

    public GameInitializer(){
        game = new CheckersGame();
        game.loadGame();
        game.start();
    }
}
