package commands;

import io.DefaultIO;

public class ShutDown extends Command {
    public ShutDown(DefaultIO dio){
        super("Shut Down", dio);
    }

    @Override
    public void execute() {
        dio.write("Goodbye");
    }
}
