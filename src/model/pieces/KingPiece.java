package model.pieces;

public class KingPiece extends CheckersGamePiece {
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
