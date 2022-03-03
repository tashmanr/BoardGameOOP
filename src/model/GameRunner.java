package model;

import io.DefaultIO;
import model.players.Player;
import scores.ScoreBoard;

public class GameRunner {
    private static GameRunner runnerInstance = null;
    private ScoreBoard scoreBoard;
    private Game game;
    private GameInitializer gameInitializer;
    private DefaultIO dio;

    private GameRunner(DefaultIO dio) {
        this.dio = dio;
        scoreBoard = ScoreBoard.getInstance();
    }

    public static GameRunner getInstance(DefaultIO dio) {
        if (runnerInstance == null) {
            runnerInstance = new GameRunner(dio);
        }
        return runnerInstance;
    }

    public void runGame(Tuple<Player, Player> players, GameOptions o, boolean newGame){
        gameInitializer = new GameInitializer();
        game = gameInitializer.getGame(o, players, newGame, dio);
        game.start();
        Player winner = game.getWinner();
        if (winner != null) {
            dio.write(winner.getPlayerName() + " is the winner!\n");
            scoreBoard.addGameResults(winner.getPlayerName());
        }
    }


}
