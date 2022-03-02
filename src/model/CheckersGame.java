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
     * @param start a tuple of the move (start, end)
     * @param end a tuple of the move (start, end)
     * @return CheckersPieceOptions enum represents the direction of the move
     */
    private CheckerPieceOptions getMoveDirection(Tuple<Integer,Integer> start, Tuple<Integer,Integer> end){
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
    public Boolean checkMoveLegal(ArrayList<Tuple<Integer,Integer>> moves, Player player){

        int move_index = 0; // the index of the move in arraylist moves
        Tuple<Integer,Integer> start = moves.get(move_index);
        move_index++;

        // get the piece in start position
        GamePiece movingPiece = board.getPieceByLocation(start);
        if (movingPiece == null){
            return false;
        }

        // get moving piece possible direction of movement
        ArrayList<Integer> directions = movingPiece.getMoveDirection();

        do{
            Tuple<Integer,Integer> next = moves.get(move_index);

            // check this move is legitimate on the board
            if(!board.isLegalMove(start, next)){
                return false;
            }

            // check if next position is empty
            if ( board.getPieceByLocation(next) != null ){
                return false;
            }

            //determine the direction of this move
            CheckerPieceOptions moveDirection = getMoveDirection(start, next);

            // check if this moveDirection is valid for the gamePiece
            if (directions.contains(moveDirection.toInt())){
                int jumpNumber = Math.abs(start.x - next.x);

                if (jumpNumber != 1) {
                    Tuple<Integer, Integer> middlePlace = new Tuple((start.x + next.x) / 2, (start.y + next.y) / 2);
                    GamePiece consumedPiece = board.getPieceByLocation(middlePlace);
                    if (consumedPiece == null) {
                        return false;
                    }
                    if (consumedPiece.getTeam() == movingPiece.getTeam()) {
                        return false;
                    }
                }
                move_index++;
            }
            //TODO change the start and next position
            start = moves.get(move_index-1);
        }while(move_index < moves.size());

        for (int i = 0; i < moves.size()-1; i++){
            board.makeMove(moves.get(i), moves.get(i+1));
        }
        return true;
    }
}
