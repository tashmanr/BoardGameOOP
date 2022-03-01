package model.players;

import model.Tuple;

import java.util.ArrayList;

public class FirstOption implements IComputerStrategy {
    @Override
    public ArrayList<Tuple<Integer,Integer>> pickMove(ArrayList<ArrayList<Tuple<Integer,Integer>>> moves) {
        return moves.get(0);
    }
}
