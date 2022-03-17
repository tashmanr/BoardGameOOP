package commands;

import ui.UI;

public abstract class Command {
    public String description;
    protected UI ui;

    public Command(String s, UI ui){
        description = s;
        this.ui = ui;
    }

    public abstract void execute();
}
