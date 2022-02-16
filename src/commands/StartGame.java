package commands;

import io.DefaultIO;
import model.GameRunner;

public class StartGame extends Command {

    public StartGame(DefaultIO dio) {
        super("Start Game\n", dio);
    }

    @Override
    public void execute() {
        dio.write("Starting Game");
        //GameRunner gameRunner = GameRunner.getInstance();
    }
}
