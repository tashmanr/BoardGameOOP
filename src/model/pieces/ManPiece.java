package model.pieces;

import model.pieces.GamePiece;

public class ManPiece extends GamePiece {

    public ManPiece(Integer team) {
        super(team);
        if (team == 1){
            // white
            moves.add(CheckerPieceOptions.RightUp.toInt());
            moves.add(CheckerPieceOptions.LeftUp.toInt());
        }
        else{
            //black
            moves.add(CheckerPieceOptions.RightDown.toInt());
            moves.add(CheckerPieceOptions.LeftDown.toInt());
        }
    }
    
    @Override
    public String toString() {
        return "M" + team.toString();

    }

}
