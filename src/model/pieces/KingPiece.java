package model.pieces;

import model.pieces.GamePiece;

public class KingPiece extends GamePiece {
    public KingPiece(Integer team) {
        super(team);
        moves.add(CheckerPieceOptions.Up.toInt());
        moves.add(CheckerPieceOptions.Down.toInt());
    }

    @Override
    public String toString() {
        return "K" + team.toString();

    }
}
