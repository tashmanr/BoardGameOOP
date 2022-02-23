package model;

import io.DefaultIO;
import model.players.Player;

public class GameInitializer {

    public Game getGame(GameOptions option, Tuple<Player, Player> players, boolean newGame, DefaultIO dio) {
        Game game = null;
        if (option == GameOptions.CHECKERS) {
            game = new CheckersGame(dio);
        }
        assert game != null;
        game.loadGame(newGame);
        game.setPlayers(players.x, players.y);
        return game;
    }
}
