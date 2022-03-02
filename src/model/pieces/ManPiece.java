package model.pieces;

public class ManPiece extends CheckersGamePiece {

    public ManPiece(Integer team) {
        super(team);
        if (team == 1) {
            // white
            moves.add(CheckerPieceOptions.Down.toInt());
        } else {
            //black
            moves.add(CheckerPieceOptions.Up.toInt());
        }
    }

    @Override
    public String toString() {
        return "M" + team.toString();

    }

}
