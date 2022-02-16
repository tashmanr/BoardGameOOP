package scores;
import model.Tuple;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoresDatabaseCSV implements IScoresDatabase {
    private File scoresFile;
    private final String fileName = "scores.txt";

    public ScoresDatabaseCSV() {
        createFile();
    }

    private void createFile() {
        try {
            scoresFile = new File(fileName);
            if (scoresFile.createNewFile()) {
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
    public void saveData(ArrayList<Tuple<String, Integer>> scores) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Tuple<String, Integer> t : scores) {
                writer.write(t.x + "," + t.y.toString() + "\n");
            }
            writer.close();
            System.out.println("Data saved successfully");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Tuple<String, Integer>> getData() {
        ArrayList<Tuple<String, Integer>> scores = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(scoresFile);
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("[,]", 0);
                scores.add(new Tuple<>(data[0], Integer.valueOf(data[1])));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return scores;
    }
}
