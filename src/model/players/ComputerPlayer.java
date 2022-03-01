package model.players;

import model.Game;
import model.Tuple;

import java.util.ArrayList;

public class ComputerPlayer extends Player {
    private IComputerStrategy strategy;

    public ComputerPlayer(IComputerStrategy s) {
        strategy = s;
    }

    private ArrayList<Tuple<Tuple<Integer, Integer>, Tuple<Integer, Integer>>> getAllMoves() {
        ArrayList<Tuple<Tuple<Integer, Integer>, Tuple<Integer, Integer>>> moves = new ArrayList<>();
        // Todo: actually calculate moves, this is temporary
        moves.add(new Tuple<>(new Tuple<>(1, 1), new Tuple<>(1, 2)));
        return moves;
    }

    /**
     * Updates the game state to take a move for the current player.
     *
     * @param game the game to update.
     */
    public Tuple<Tuple<Integer, Integer>, Tuple<Integer, Integer>> makeMove(Game game) {
        return strategy.pickMove(getAllMoves());
    }

    @Override
    public String getPlayerName() {
        return "Computer";
    }
}
