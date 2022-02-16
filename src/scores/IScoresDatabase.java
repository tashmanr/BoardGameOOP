package scores;

import model.Tuple;

import java.util.ArrayList;

public interface IScoresDatabase {
    void saveData(ArrayList<Tuple<String, Integer>> scores);

    ArrayList<Tuple<String, Integer>> getData();
}
