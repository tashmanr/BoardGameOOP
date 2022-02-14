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

    public void addGameResults(String player) {
        int score = 1;
        Tuple<String, Integer> element = null;
        for (Tuple<String, Integer> t : scoreboard) {
            if (t.x.equals(player)) {
                score += t.y;
                element = t;
            }
        }
        if (element != null) {
            scoreboard.remove(element);
        }
        addScore(player, score);
    }

    public ArrayList<Tuple<String, Integer>> getScores() {
        return scoreboard;
    }
}
