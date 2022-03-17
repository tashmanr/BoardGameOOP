package model;

import model.players.Player;
import scores.ScoreBoard;
import ui.UI;

public class GameRunner {
    private static GameRunner runnerInstance = null;
    private ScoreBoard scoreBoard;
    private Game game;
    private GameInitializer gameInitializer;
    private UI ui;

    private GameRunner(UI ui) {
        this.ui = ui;
        scoreBoard = ScoreBoard.getInstance();
    }

    public static GameRunner getInstance(UI ui) {
        if (runnerInstance == null) {
            runnerInstance = new GameRunner(ui);
        }
        return runnerInstance;
    }

    public void runGame(Tuple<Player, Player> players, GameOptions o, boolean newGame){
        gameInitializer = new GameInitializer();
        game = gameInitializer.getGame(o, players, newGame, ui);
        game.start();
        Player winner = game.getWinner();
        if (winner != null) {
            ui.write(winner.getPlayerName() + " is the winner!\n");
            scoreBoard.addGameResults(winner.getPlayerName());
        }
    }


}
