package model.players;

import model.Game;
import model.Tuple;
import model.boards.Board;

import java.util.ArrayList;

public class ComputerPlayer extends Player {
    private IComputerStrategy strategy;

    public ComputerPlayer(IComputerStrategy s) {
        strategy = s;
    }

    private ArrayList<ArrayList<Tuple<Integer,Integer>>> getAllMoves(Board board) {
        ArrayList<ArrayList<Tuple<Integer,Integer>>> moves = new ArrayList<>();
        // Todo: actually calculate moves, this is temporary
        ArrayList<Tuple<Integer,Integer>> tmp = new ArrayList<>();
        tmp.add(new Tuple<>(1,1));
        tmp.add(new Tuple<>(2,2));
        moves.add(tmp);
        return moves;
    }

    /**
     * Updates the game state to take a move for the current player.
     *
     * @param game the game to update.
     */
    public ArrayList<Tuple<Integer,Integer>> makeMove(Board board) {
        return strategy.pickMove(getAllMoves(board));
    }

    @Override
    public String getPlayerName() {
        return "Computer";
    }
}
