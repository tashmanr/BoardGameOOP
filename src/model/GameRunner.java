package model;

import model.players.Player;
import scores.ScoreBoard;

public class GameRunner {
    private static GameRunner runnerInstance = null;
    private ScoreBoard scoreBoard;

    private GameRunner(Tuple<Player, Player> players, GameOptions o, boolean newGame) {
        Game game = new GameInitializer().getGame(o, players, newGame);
        scoreBoard = ScoreBoard.getInstance();
        game.start();
        Player winner = game.getWinner();
        scoreBoard.addGameResults(winner.getPlayerName());
    }

    public static GameRunner getInstance(Tuple<Player, Player> players, GameOptions o, boolean newGame) {
        if (runnerInstance == null) {
            runnerInstance = new GameRunner(players, o, newGame);
        }
        return runnerInstance;
    }


}
