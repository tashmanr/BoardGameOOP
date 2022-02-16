package model.pieces;

import model.pieces.GamePiece;

public class KingPiece extends GamePiece {
    public KingPiece(Integer team) {
        super(team);
        moves.add(1);
        moves.add(-1);
    }

    @Override
    public String toString() {
        return "K" + team.toString();

    }
}
