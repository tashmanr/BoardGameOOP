package model.players;

import model.Tuple;

import java.util.ArrayList;

public class MostJumpsOption implements IComputerStrategy {
    @Override
    public ArrayList<Tuple<Integer, Integer>> pickMove(ArrayList<ArrayList<Tuple<Integer, Integer>>> moves) {
        int maxLength = 0;
        ArrayList<Tuple<Integer, Integer>> maxJumps = null;
        for (var m: moves){
            if (m.size() > maxLength){
                maxJumps = m;
                maxLength = m.size();
            }
        }
        return maxJumps;
    }
}
