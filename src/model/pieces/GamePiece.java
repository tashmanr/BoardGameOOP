package model.pieces;

import java.util.ArrayList;

public abstract class GamePiece {
    public ArrayList<Integer> moves = new ArrayList<>();
    protected Integer team;

    protected GamePiece(Integer team) {
        this.team = team;
    }
    public Integer getTeam(){
        return team;
    }
    public ArrayList<Integer> getMoveDirection() {
        return moves;
    }

	abstract public String toString();
}
