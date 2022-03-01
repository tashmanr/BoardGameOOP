package model.pieces;

import model.pieces.GamePiece;

public class ManPiece extends GamePiece {

    public ManPiece(Integer team) {
        super(team);
        if (team == 1){
            // white
            moves.add(CheckerPieceOptions.Up.toInt());
        }
        else{
            //black
            moves.add(CheckerPieceOptions.Down.toInt());
        }
    }
    
    @Override
    public String toString() {
        return "M" + team.toString();

    }

}
