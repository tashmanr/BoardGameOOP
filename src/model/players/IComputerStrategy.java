package model.players;

import model.Tuple;

import java.util.ArrayList;

public interface IComputerStrategy {
    ArrayList<Tuple<Integer,Integer>> pickMove(ArrayList<ArrayList<Tuple<Integer,Integer>>> moves);
}
