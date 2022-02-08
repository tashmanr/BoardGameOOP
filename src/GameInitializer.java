public class GameInitializer {

    public Game getGame(GameOptions option, Tuple<Player, Player> players) {
        Game game;
        if (option == GameOptions.CHECKERS) {
            game = new CheckersGame();
        } else {
            game = new DummyGame();
        }
        game.loadGame();
        game.setPlayers(players.x, players.y);
        return game;
    }
}
