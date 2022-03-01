package commands;

import io.DefaultIO;
import model.GameOptions;
import model.GameRunner;
import model.Tuple;
import model.players.Player;
import model.players.PlayerInitializer;

import java.util.EnumSet;

public class PlayGame extends Command {
    GameRunner gameRunner;
    PlayerInitializer playerInitializer;

    public PlayGame(DefaultIO dio) {
        super("Play a Game", dio);
    }

    @Override
    public void execute() {
        GameOptions o = pickGame();
        Tuple<Player, Player> players = getPlayers();
        boolean newGame = wantsNewGame();
        gameRunner = GameRunner.getInstance(players, o, newGame, dio);
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
                dio.write(i + ". " + o);
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
        String name1 = getName(1);
        String name2 = "";
        if (players == 2){
            name2 = getName(2);
        }
        playerInitializer = new PlayerInitializer();
        return playerInitializer.getPlayers(players, name1, name2);
    }

    private String getName(int player){
        dio.write("Please enter name for player " + player);
        return dio.read();
    }
}
