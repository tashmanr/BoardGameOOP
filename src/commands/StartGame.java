package commands;

import io.DefaultIO;
import model.GameOptions;
import model.GameRunner;
import model.Tuple;
import model.players.Player;
import model.players.PlayerInitializer;

import java.util.EnumSet;

public class StartGame extends Command {
    GameRunner gameRunner;
    PlayerInitializer playerInitializer;

    public StartGame(DefaultIO dio) {
        super("Game", dio);
    }

    @Override
    public void execute() {
        GameOptions o = pickGame();
        Tuple<Player, Player> players;
        boolean newGame = false;
        if (!demoMode()) {
            players = getPlayers();
            newGame = wantsNewGame();
        } else {
            players = setDemoPlayers();
        }
        gameRunner = GameRunner.getInstance(dio);
        gameRunner.runGame(players, o, newGame);
    }

    private Tuple<Player, Player> setDemoPlayers() {
        playerInitializer = new PlayerInitializer();
        return playerInitializer.getPlayers(0, "", "", 0, dio);
    }

    private boolean demoMode() {
        boolean valid = false;
        boolean demo = false;
        while (!valid) {
            dio.write("Please pick a mode:\n1.Demo\n2.Play game");
            String input = dio.read();
            int result = Integer.parseInt(input);
            if (result >= 1 && result <= 2) {
                valid = true;
                if (result == 1) {
                    demo = true;
                }
            }
        }
        return demo;
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
        int players = -1;
        boolean firstTime = true;
        while (players < 0 || players > 2) {
            if (!firstTime) {
                dio.write("Invalid input, must be 1 or 2 players");
            }
            dio.write("How many players?");
            String input = dio.read();
            players = Integer.parseInt(input);
            firstTime = false;
        }
        int level = 0;
        String name1 = "";
        String name2 = "";
        if (players != 0) {
            name1 = getName(1);
            if (players == 2) {
                name2 = getName(2);
            } else {
                dio.write("Choose playing level:\n1.Easy\n2.Hard");
                String input = dio.read();
                level = Integer.parseInt(input);
            }
        }
        playerInitializer = new PlayerInitializer();
        return playerInitializer.getPlayers(players, name1, name2, level, dio);
    }

    private String getName(int player) {
        dio.write("Please enter name for player " + player);
        return dio.read();
    }
}
