package model.boards;

import model.Tuple;
import model.pieces.GamePiece;
import model.pieces.KingPiece;
import model.pieces.ManPiece;


import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

public class CheckersBoard extends Board {
    ManPiece men1;
    ManPiece men2;
    KingPiece king1;
    KingPiece king2;

    @Override
    public void createPieces() {
        men1 = new ManPiece(1);
        men2 = new ManPiece(2);
        king1 = new KingPiece(1);
        king2 = new KingPiece(2);
        team1.put(men1, new ArrayList<>());
        team2.put(men2, new ArrayList<>());
    }

    @Override
    public void loadNewBoard() {
        createPieces();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i % 2 != j % 2) {
                    if (i < 3) {
                        pieces[i][j] = men1;
                        team1.get(men1).add(new Tuple<>(i, j));
                    } else if (i > 4) {
                        pieces[i][j] = men2;
                        team2.get(men2).add(new Tuple<>(i, j));
                    } else {
                        pieces[i][j] = null;
                    }
                } else {
                    pieces[i][j] = null;
                }
            }
        }
    }

    @Override
    public void loadSavedBoard(Tuple<HashMap<String, ArrayList<Tuple<Integer, Integer>>>, HashMap<String, ArrayList<Tuple<Integer, Integer>>>> teams) {
        createPieces();
        for (var entry : teams.x.entrySet()) {
            for (var gp : team1.entrySet()) {
                if (gp.getKey().toString().equals(entry.getKey())) {
                    team1.put(gp.getKey(), entry.getValue());
                    for (var t : entry.getValue()) {
                        pieces[t.x][t.y] = gp.getKey();
                    }
                    break;
                }
            }
        }
        for (var entry : teams.y.entrySet()) {
            for (var gp : team2.entrySet()) {
                if (gp.getKey().toString().equals(entry.getKey())) {
                    team2.put(gp.getKey(), entry.getValue());
                    for (var t : entry.getValue()) {
                        pieces[t.x][t.y] = gp.getKey();
                    }
                    break;
                }
            }
        }

    }
    @Override
    public boolean makeMove(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end){
        GamePiece mover = pieces[start.x][start.y];
        if (mover != null && isLegalMove(start, end)){
            pieces[start.x][start.y] = null;
            pieces[end.x][end.y] = mover;
            if(Math.abs(start.x - end.x) == 2){
                // meaning there is a piece in between we need to eliminate
                int axis_x = (start.x+end.x)/2;
                int axis_y = (start.y + end.y)/2;
                pieces[axis_x][axis_y] = null;
            }
            return true;
        }
        return false;
    }


    @Override
    public boolean isLegalMove(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end) {
        // check that positions are inside of board dimensions
        if ( (0 <= start.x && start.x < size)  && (0 <= start.y && start.y < size) &&
                (0 <= end.x && end.x < size) && ((0 <= end.y && end.y < size)) ){

            // check that there is a piece in start and the end position is empty
            if (pieces[start.x][start.y] != null && pieces[end.x][end.y] == null){
                // no piece in this place
                return true;
            }
        }
        return false;
    }
}





