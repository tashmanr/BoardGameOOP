package commands;

import io.DefaultIO;
import model.Tuple;
import scores.ScoreBoard;

import java.util.ArrayList;

public class ViewScores extends Command {
    public ViewScores(DefaultIO dio){
        super("View Scoreboard", dio);
    }
    @Override
    public void execute() {
        ArrayList<Tuple<String, Integer>> scores = ScoreBoard.getInstance().getScores();
        dio.write("Top Scores:");
        for (var s: scores){
            dio.write(s.x + ": " + s.y);
        }
    }
}
