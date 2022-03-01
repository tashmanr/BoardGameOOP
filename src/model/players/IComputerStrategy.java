package model.players;

import model.Tuple;

import java.util.ArrayList;

public interface IComputerStrategy {
    Tuple<Tuple<Integer, Integer>, Tuple<Integer, Integer>> pickMove(ArrayList<Tuple<Tuple<Integer, Integer>, Tuple<Integer, Integer>>> moves);
}
