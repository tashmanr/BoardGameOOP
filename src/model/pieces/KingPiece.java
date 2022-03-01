package model.pieces;

import model.pieces.GamePiece;

public class KingPiece extends GamePiece {
    public KingPiece(Integer team) {
        super(team);
        moves.add(CheckerPieceOptions.RightUp.toInt());
        moves.add(CheckerPieceOptions.LeftUp.toInt());
        moves.add(CheckerPieceOptions.RightDown.toInt());
        moves.add(CheckerPieceOptions.LeftDown.toInt());
    }

    @Override
    public String toString() {
        return "K" + team.toString();

    }
}
