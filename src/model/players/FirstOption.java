package model.players;

import model.Tuple;

import java.util.ArrayList;

public class FirstOption implements IComputerStrategy {
    @Override
    public Tuple<Tuple<Integer, Integer>, Tuple<Integer, Integer>> pickMove(ArrayList<Tuple<Tuple<Integer, Integer>, Tuple<Integer, Integer>>> moves) {
        return moves.get(0);
    }
}
