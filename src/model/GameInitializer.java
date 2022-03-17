package model;

import model.players.Player;
import ui.UI;

public class GameInitializer {

    public Game getGame(GameOptions option, Tuple<Player, Player> players, boolean newGame, UI ui) {
        Game game = null;
        if (option == GameOptions.CHECKERS) {
            game = new CheckersGame(ui);
        }
        assert game != null;
        game.loadGame(newGame);
        game.setPlayers(players.x, players.y);
        return game;
    }
}
