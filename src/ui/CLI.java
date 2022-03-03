package ui;

import commands.Command;
import commands.StartGame;
import commands.ShutDown;
import commands.ViewScores;
import io.DefaultIO;
import java.util.ArrayList;

public class CLI extends UI {
    protected ArrayList<Command> commands;
    protected DefaultIO dio;

    public CLI(DefaultIO d) {
        dio = d;
        commands = new ArrayList<>();
        commands.add(new StartGame(dio));
        commands.add(new ViewScores(dio));
        commands.add(new ShutDown(dio));
    }

    @Override
    public void start() {
        boolean indicator = true;
        while (indicator) { //as long as shut down has not been chosen, keep going
            dio.write("Welcome to our board game. Please choose an option:");
            // show options
            int i = 1;
            for (Command c : commands) {
                dio.write(i + ". " + c.description);
                i++;
            }
            // receive option choice
            String input = dio.read();
            int index = 10;
            try {
                index = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                dio.write("An error occurred");
            }
            if (index < 4 && index > 0) {
                commands.get(index - 1).execute();
            }
            if (index == 3) { //shutdown the program
                indicator = false;
            }
        }
    }
}
