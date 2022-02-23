package model;

import io.DefaultIO;
import model.players.Player;
import scores.ScoreBoard;

public class GameRunner {
    private static GameRunner runnerInstance = null;
    private ScoreBoard scoreBoard;

    private GameRunner(Tuple<Player, Player> players, GameOptions o, boolean newGame, DefaultIO dio) {
        Game game = new GameInitializer().getGame(o, players, newGame, dio);
        scoreBoard = ScoreBoard.getInstance();
        game.start();
        Player winner = game.getWinner();
        scoreBoard.addGameResults(winner.getPlayerName());
    }

    public static GameRunner getInstance(Tuple<Player, Player> players, GameOptions o, boolean newGame, DefaultIO dio) {
        if (runnerInstance == null) {
            runnerInstance = new GameRunner(players, o, newGame, dio);
        }
        return runnerInstance;
    }


}
