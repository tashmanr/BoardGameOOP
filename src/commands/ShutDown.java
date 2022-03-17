package commands;

import io.DefaultIO;
import ui.UI;

public class ShutDown extends Command {
    public ShutDown(UI ui){
        super("Shut Down", ui);
    }

    @Override
    public void execute() {
        ui.write("Goodbye");
    }
}
