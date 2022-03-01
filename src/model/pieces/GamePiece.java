package model.pieces;

import model.Tuple;

import java.util.ArrayList;

public abstract class GamePiece {
    public ArrayList<Integer> moves = new ArrayList<>();
    protected Integer team;

    protected GamePiece(Integer team) {
        this.team = team;
    }

    public Integer getTeam() {
        return team;
    }

    public ArrayList<Integer> getMoveDirection() {
        return moves;
    }

    public abstract ArrayList<Tuple<Integer,Integer>> calculateMoves(Tuple<Integer, Integer> location, GamePiece[][] board);

    abstract public String toString();
}
