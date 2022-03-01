package model;

import io.DefaultIO;
import model.boards.CheckersBoard;
import model.pieces.CheckerPieceOptions;
import model.pieces.GamePiece;
import model.players.Player;
import java.lang.Math;

import java.util.ArrayList;

public class CheckersGame extends Game {
    public CheckersGame(DefaultIO dio) {
        super(dio);
        this.board = new CheckersBoard();
    }

    /***
     * get the direction of the move entered
     * @param move a tuple of the move (start, end)
     * @return CheckersPieceOptions enum represents the direction of the move
     */
    private CheckerPieceOptions getMoveDirection(Tuple<Tuple<Integer,Integer>, Tuple<Integer,Integer>> move){
        Tuple<Integer,Integer> start = move.x;
        Tuple<Integer,Integer> end = move.y;

        if (start.x > end.x){
            return CheckerPieceOptions.Up;
        }
        else if (start.x < end.x){
            return CheckerPieceOptions.Down;
        }
        else{
            // this move is not legal
            return CheckerPieceOptions.Invalid;
        }
    }


    @Override
    public Boolean checkMoveLegal(Tuple<Tuple<Integer,Integer>, Tuple<Integer,Integer>> move, Player player){
        Tuple<Integer,Integer> start = move.x;
        Tuple<Integer,Integer> end = move.y;

        // check if end position is empty
        if ( board.getPieceByLocation(end) != null ){
            return false;
        }
        // get the piece in start position
        GamePiece piece = board.getPieceByLocation(move.x);
        if (piece == null){
            return false;
        }

        // check this piece can do this move
        ArrayList<Integer> moves = piece.getMoveDirection();

        //determine the direction of this move
        CheckerPieceOptions moveDirection = getMoveDirection(move);

        // check if this moveDirection is valid
        if (moves.contains(moveDirection.toInt())){
            // the direction is valid
            int jumpNumber = Math.abs(start.x - end.x);
            if (jumpNumber == 1){
                board.makeMove(start, end);
                return true;
            }
            else{
                GamePiece consumedPiece; // TODO
            }


        }else{
            // the direction of this move is invalid for this piece
            return false;
        }

    return false;

    }
}
