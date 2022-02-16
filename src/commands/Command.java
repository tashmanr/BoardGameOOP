package commands;

import io.DefaultIO;

public abstract class Command {
    public String description;
    protected DefaultIO dio;

    public Command(String s, DefaultIO d){
        description = s;
        dio = d;
    }

    public abstract void execute();
}
