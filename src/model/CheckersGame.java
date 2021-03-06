package model;

import model.boards.CheckersBoard;
import model.pieces.CheckerPieceOptions;
import model.pieces.GamePiece;
import model.players.Player;
import ui.UI;

import java.lang.Math;

import java.util.ArrayList;

public class CheckersGame extends Game {
    public CheckersGame(UI ui) {
        super(ui);
        this.board = new CheckersBoard();
    }

    /***
     * get the direction of the move entered
     * @param start a tuple of the move (start, end)
     * @param end a tuple of the move (start, end)
     * @return CheckersPieceOptions enum represents the direction of the move
     */
    private CheckerPieceOptions getMoveDirection(Tuple<Integer, Integer> start, Tuple<Integer, Integer> end) {
        if (start.x > end.x) {
            return CheckerPieceOptions.Up;
        } else if (start.x < end.x) {
            return CheckerPieceOptions.Down;
        } else {
            // this move is not legal
            return CheckerPieceOptions.Invalid;
        }
    }

    @Override
    public Boolean makeMove(ArrayList<Tuple<Integer, Integer>> moves, Player player) {
        boolean legal = checkMoveLegal(moves, player);
        if (legal) {
            for (int i = 0; i < moves.size() - 1; i++) {
                legal = board.makeMove(moves.get(i), moves.get(i + 1));
                if (!legal) {
                    return false;
                } else {
                    Tuple<Integer, Integer> destination = moves.get(i + 1);
                    Tuple<Integer, Integer> start = moves.get(i);
                    if ((destination.x == 0 || destination.x == 7) && board.getBoard()[destination.x][destination.y].toString().startsWith("M")) {
                        kingMe(destination.x, destination.y);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean checkMoveLegal(ArrayList<Tuple<Integer, Integer>> moves, Player player) {

        int move_index = 0; // the index of the move in arraylist moves
        Tuple<Integer, Integer> start = moves.get(move_index);
        move_index++;

        // get the piece in start position
        GamePiece movingPiece = board.getPieceByLocation(start);
        if (movingPiece == null || !movingPiece.getTeam().equals(player.getTeam())) {
            return false;
        }

        // get moving piece possible direction of movement
        ArrayList<Integer> directions = movingPiece.getMoveDirection();

        do {
            Tuple<Integer, Integer> next = moves.get(move_index);

            // check this move is legitimate on the board
            if (!board.isLegalMove(start, next)) {
                return false;
            }

            // check if next position is empty
            if (board.getPieceByLocation(next) != null) {
                return false;
            }

            //determine the direction of this move
            CheckerPieceOptions moveDirection = getMoveDirection(start, next);

            // check if this moveDirection is valid for the gamePiece
            if (directions.contains(moveDirection.toInt())) {
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
            start = moves.get(move_index - 1);
        } while (move_index < moves.size());

        return true;
    }

    @Override
    public boolean gameOver() {
        return board.getTeam(1).isEmpty() || board.getTeam(2).isEmpty();
    }

    private void kingMe(Integer x, Integer y) {
        CheckersBoard b = (CheckersBoard) board;
        b.upgradePiece(x, y);
    }
}
