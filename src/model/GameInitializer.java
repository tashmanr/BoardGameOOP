package model;

import model.players.Player;

public class GameInitializer {

    public Game getGame(GameOptions option, Tuple<Player, Player> players) {
        Game game = null;
        if (option == GameOptions.CHECKERS) {
            game = new CheckersGame();
        }
        game.loadGame();
        game.setPlayers(players.x, players.y);
        return game;
    }
}
