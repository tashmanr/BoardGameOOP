package commands;

import io.DefaultIO;
import model.GameOptions;
import model.GameRunner;
import model.Tuple;
import model.players.ComputerPlayer;
import model.players.HumanPlayer;
import model.players.Player;

import java.util.EnumSet;

public class PlayGame extends Command {

    public PlayGame(DefaultIO dio) {
        super("Play a Game", dio);
    }

    @Override
    public void execute() {
        GameOptions o = pickGame();
        Tuple<Player, Player> players = getPlayers();
        boolean newGame = wantsNewGame();
        GameRunner gameRunner = GameRunner.getInstance(players, o, newGame);
    }

    private boolean wantsNewGame() {
        boolean valid = false;
        boolean newGame = false;
        while (!valid) {
            dio.write("Would you like to retrieve an old game? [y/n]");
            String input = dio.read();
            if (input.equals("y") || input.equals("n")) {
                valid = true;
                if (input.equals("n")) {
                    newGame = true;
                }
            }
        }
        return newGame;
    }

    private GameOptions pickGame() {
        // logic to pick kind of game
        EnumSet<GameOptions> options = EnumSet.range(GameOptions.CHECKERS, GameOptions.CHECKERS);
        while (true) {
            dio.write("Please pick a game");
            int i = 1;
            for (GameOptions o : options) {
                dio.write(String.valueOf(i) + ". " + o);
                i++;
            }
            // receive option choice
            String input = dio.read();
            int index = Integer.parseInt(input);
            index -= 1;
            for (GameOptions o : options) {
                if (index == o.ordinal()) {
                    return o;
                }
            }
        }
    }

    private Tuple<Player, Player> getPlayers() {
        int players = 0;
        boolean firstTime = true;
        while (players < 1 || players > 2) {
            if (!firstTime) {
                dio.write("Invalid input, must be 1 or 2 players");
            }
            dio.write("How many players?");
            String input = dio.read();
            players = Integer.parseInt(input);
            firstTime = false;
        }
        Player p1 = new HumanPlayer();
        Player p2;
        if (players == 1) {
            p2 = new ComputerPlayer();
        } else {
            p2 = new HumanPlayer();
        }
        return new Tuple<>(p1, p2);
    }
}
