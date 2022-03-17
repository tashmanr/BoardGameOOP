package commands;

import model.Tuple;
import scores.ScoreBoard;
import ui.UI;

import java.util.ArrayList;

public class ViewScores extends Command {
    public ViewScores(UI ui){
        super("View Scoreboard", ui);
    }
    @Override
    public void execute() {
        ArrayList<Tuple<String, Integer>> scores = ScoreBoard.getInstance().getScores();
        ui.write("Top Scores:");
        for (var s: scores){
            ui.write(s.x + ": " + s.y);
        }
    }
}
