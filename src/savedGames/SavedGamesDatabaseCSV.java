package savedGames;

import model.Tuple;
import model.pieces.GamePiece;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SavedGamesDatabaseCSV implements ISavedGamesDatabase {
    private File gameFile;
    private final String fileName = "last_game.txt";

    public SavedGamesDatabaseCSV() {
        createFile();
    }

    private void createFile() {
        try {
            gameFile = new File(fileName);
            if (gameFile.createNewFile()) {
                System.out.println("Created file successfully");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    @Override
    public void saveData(HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team1, HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team2) {
        try {
            FileWriter writer = new FileWriter(fileName);
            // save team1 locations
            for (var entry : team1.entrySet()) {
                GamePiece p = entry.getKey();
                for (var t : entry.getValue()) {
                    writer.write(p.toString() + "," + String.valueOf(t.x) + "," + String.valueOf(t.y) + "\n");
                }
            }
            // save team2 locations
            for (var entry : team2.entrySet()) {
                GamePiece p = entry.getKey();
                for (var t : entry.getValue()) {
                    writer.write(p.toString() + "," + String.valueOf(t.x) + "," + String.valueOf(t.y) + "\n");
                }
            }
            writer.close();
            System.out.println("Data saved successfully");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    @Override
    public Tuple<HashMap<String, ArrayList<Tuple<Integer, Integer>>>, HashMap<String, ArrayList<Tuple<Integer, Integer>>>> getData() {
        HashMap<String, ArrayList<Tuple<Integer, Integer>>> team1 = new HashMap<>();
        HashMap<String, ArrayList<Tuple<Integer, Integer>>> team2 = new HashMap<>();
        try {
            Scanner scanner = new Scanner(gameFile);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("[,]", 0);
                if (data[0].endsWith("1")) {
                    if (team1.containsKey(data[0])) {
                        team1.get(data[0]).add(new Tuple<Integer, Integer>(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                    } else {
                        ArrayList<Tuple<Integer, Integer>> tmp = new ArrayList<>();
                        tmp.add(new Tuple<>(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                        team1.put(data[0], tmp);
                    }
                } else {
                    if (team2.containsKey(data[0])) {
                        team2.get(data[0]).add(new Tuple<Integer, Integer>(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                    } else {
                        ArrayList<Tuple<Integer, Integer>> tmp = new ArrayList<>();
                        tmp.add(new Tuple<>(Integer.parseInt(data[1]), Integer.parseInt(data[2])));
                        team2.put(data[0], tmp);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return new Tuple<>(team1, team2);
    }
}
