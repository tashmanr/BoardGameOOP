package ui;

import commands.Command;
import commands.ShutDown;
import commands.StartGame;
import commands.ViewScores;

import java.util.ArrayList;

public abstract class UI {
    protected ArrayList<Command> commands;
    public UI(){
        commands = new ArrayList<>();
        commands.add(new StartGame(this));
        commands.add(new ViewScores(this));
        commands.add(new ShutDown(this));
    }
    public abstract void start();
    public abstract String read();
    public abstract void write(String s);
}
