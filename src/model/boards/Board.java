package model.boards;

import model.Tuple;
import model.pieces.GamePiece;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Board {
    public GamePiece[][] pieces;
    public HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team1 = new HashMap<>();
    public HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> team2 = new HashMap<>();
    public Integer size = 8;

    public Board() {
        this.pieces = new GamePiece[size][size];
    }

    protected abstract void createPieces();

    public abstract void loadNewBoard();

    public abstract void loadSavedBoard(Tuple<HashMap<String, ArrayList<Tuple<Integer, Integer>>>, HashMap<String, ArrayList<Tuple<Integer, Integer>>>> teams);

    public GamePiece[][] getBoard() {
        return pieces;
    }

    public HashMap<GamePiece, ArrayList<Tuple<Integer, Integer>>> getTeam(Integer i) {
        if (i == 1) {
            return team1;
        } else return team2;
    }

    public abstract boolean makeMove(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end);

    public abstract boolean isLegalMove(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end);

    @Override
    public String toString() {
        String temp = "";

        for (int i = 0; i < size; i++) {
            temp += "-------------------------\n";
            for (int j = 0; j < size; j++) {
                if(j==0){
                    temp+="|";
                }
                if (pieces[i][j] == null) {
                    temp += "  ";
                }
                else{
                    temp += pieces[i][j].toString();
                }
                temp+= "|";
            }
            temp += "\n";
        }
        temp += "-------------------------\n";
        return temp;
    }

    public GamePiece getPieceByLocation(Tuple<Integer, Integer> location){
        return pieces[location.x][location.y];
    }
}
