package savedGames;

import model.Tuple;
import model.pieces.GamePiece;

import java.util.ArrayList;
import java.util.HashMap;

public interface ISavedGamesDatabase {
    void saveData(HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team1, HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team2);

    Tuple<HashMap<String, ArrayList<Tuple<Integer, Integer>>>, HashMap<String, ArrayList<Tuple<Integer, Integer>>>> getData();
}
