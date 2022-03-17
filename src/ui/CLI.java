package ui;

import commands.Command;
import commands.StartGame;
import commands.ShutDown;
import commands.ViewScores;
import io.DefaultIO;
import io.TerminalIO;

import java.util.ArrayList;

public class CLI extends UI {
    protected DefaultIO dio;

    public CLI() {
        super();
        dio = new TerminalIO();
    }

    @Override
    public void start() {
        boolean indicator = true;
        while (indicator) { //as long as shut down has not been chosen, keep going
            write("Welcome to our board game. Please choose an option:");
            // show options
            int i = 1;
            for (Command c : commands) {
                write(i + ". " + c.description);
                i++;
            }
            // receive option choice
            String input = read();
            int index = 10;
            try {
                index = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                write("An error occurred");
            }
            if (index < 4 && index > 0) {
                commands.get(index - 1).execute();
            }
            if (index == 3) { //shutdown the program
                indicator = false;
            }
        }
    }

    @Override
    public String read() {
        return dio.read();
    }

    @Override
    public void write(String s) {
        dio.write(s);
    }
}
