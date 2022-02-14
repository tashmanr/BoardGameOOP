import java.util.ArrayList;

public class ScoreBoard {
    private static ScoreBoard scoreBoardInstance = null;
    private static ArrayList<Tuple<String, Integer>> scoreboard;
    private static IScoresDatabase db;

    private ScoreBoard() {
        scoreboard = db.getData();
    }

    public static ScoreBoard getInstance() {
        if (scoreBoardInstance == null) {
            db = new ScoresDatabaseCSV();
            scoreBoardInstance = new ScoreBoard();
        }
        return scoreBoardInstance;
    }

    public void addScore(String player, Integer score) {
        scoreboard.add(new Tuple<>(player, score));
        db.saveData(scoreboard);
    }

    public ArrayList<Tuple<String, Integer>> getScores() {
        return scoreboard;
    }
}
