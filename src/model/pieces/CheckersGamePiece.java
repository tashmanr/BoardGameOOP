package model.pieces;

import model.Tuple;

import java.util.ArrayList;

public abstract class CheckersGamePiece extends GamePiece {
    protected CheckersGamePiece(Integer team) {
        super(team);
    }

    @Override
    public ArrayList<Tuple<Integer, Integer>> calculateMoves(Tuple<Integer, Integer> location, GamePiece[][] board) {
        ArrayList<Tuple<Integer, Integer>> tmp = new ArrayList<>();
        for (var a : moves) {
            if (location.y + 1 < 8 && location.x + a >= 0 && location.x + a < 8) {
                if (board[location.x + a][location.y + 1] == null) {
                    tmp.add(new Tuple<>(location.x + a, location.y + 1));
                } else if (!board[location.x + a][location.y + 1].getTeam().equals(team)) { // else if it's blocked by opposing team, see if we can jump
                    if (location.y + 2 < 8 && location.x + (2 * a) >= 0 && location.x + (2 * a) < 8 &&
                            board[location.x + (2 * a)][location.y + 2] == null) {
                        tmp.add(new Tuple<>(location.x + (2 * a), location.y + 2));
                    }
                }
            }
            if (location.y - 1 >= 0 && location.x + a >= 0 && location.x + a < 8) {
                if (board[location.x + a][location.y - 1] == null) {
                    tmp.add(new Tuple<>(location.x + a, location.y - 1));
                } else if (!board[location.x + a][location.y - 1].getTeam().equals(team)) { // else if it's blocked by opposing team, see if we can jump
                    if (location.y - 2 >= 0 && location.x + (2 * a) >= 0 && location.x + (2 * a) < 8 &&
                            board[location.x + (2 * a)][location.y - 2] == null) {
                        tmp.add(new Tuple<>(location.x + (2 * a), location.y - 2));
                    }
                }
            }
        }
        return tmp;
    }

    @Override
    public abstract String toString();
}
