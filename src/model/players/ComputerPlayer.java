package model.players;

import model.Game;
import model.Tuple;
import model.boards.Board;
import model.pieces.GamePiece;

import java.util.ArrayList;

public class ComputerPlayer extends Player {
    private IComputerStrategy strategy;

    public ComputerPlayer(IComputerStrategy s) {
        strategy = s;
    }

    private ArrayList<ArrayList<Tuple<Integer, Integer>>> getAllMoves(Board board) {
        ArrayList<ArrayList<Tuple<Integer, Integer>>> moves = new ArrayList<>();
        GamePiece[][] boardArray = board.getBoard();
        for (int i = 0; i < board.size; i++) {
            for (int j = 0; j < board.size; j++) {
                Tuple<Integer, Integer> t = new Tuple<>(i, j);
                ArrayList<Tuple<Integer, Integer>> result = new ArrayList<>();
                if (boardArray[i][j] != null && boardArray[i][j].getTeam() == 2) {//computerPlayer is ALWAYS team2
                    result = boardArray[i][j].calculateMoves(t, boardArray);
                }
                for (var v : result) {
                    if (board.isLegalMove(t, v)) {
                        ArrayList<Tuple<Integer, Integer>> tmp = new ArrayList<>();
                        tmp.add(t);
                        tmp.add(v);
                        moves.add(tmp);
                    }
                }
            }
        }
        return moves;
    }

    /**
     * Updates the board state to take a move for the current player.
     *
     * @param board the board to update.
     */
    public ArrayList<Tuple<Integer, Integer>> makeMove(Board board) {
        return strategy.pickMove(getAllMoves(board));
    }

    @Override
    public String getPlayerName() {
        return "Computer";
    }
}
