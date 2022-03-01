package model.pieces;

import model.Tuple;

import java.util.ArrayList;

public class KingPiece extends GamePiece {
    public KingPiece(Integer team) {
        super(team);
        moves.add(CheckerPieceOptions.Up.toInt());
        moves.add(CheckerPieceOptions.Down.toInt());
    }

    @Override
    public ArrayList<Tuple<Integer, Integer>> calculateMoves(Tuple<Integer, Integer> location, GamePiece[][] board) {
        ArrayList<Tuple<Integer, Integer>> tmp = new ArrayList<>();
        for (var a : moves) {
            if (location.x + 1 < 8 && location.y + a >= 0 && location.y + a < 8) {
                if (board[location.x + 1][location.y + a] == null) {
                    tmp.add(new Tuple<>(location.x + 1, location.y + a));
                } else if (!board[location.x + 1][location.y + a].getTeam().equals(team)) { // else if it's blocked by opposing team, see if we can jump
                    if (location.x + 2 < 8 && location.y + (2 * a) >= 0 && location.y + (2 * a) < 8 &&
                            board[location.x + 2][location.y + (2 * a)] == null) {
                        tmp.add(new Tuple<>(location.x + 2, location.y + (2 * a)));
                    }
                }
            }
            if (location.x - 1 >= 0 && location.y + a >= 0 && location.y + a < 8) {
                if (board[location.x - 1][location.y + a] == null) {
                    tmp.add(new Tuple<>(location.x - 1, location.y + a));
                } else if (!board[location.x - 1][location.y + a].getTeam().equals(team)) { // else if it's blocked by opposing team, see if we can jump
                    if (location.x - 2 >= 0 && location.y + (2 * a) >= 0 && location.y + (2 * a) < 8 &&
                            board[location.x - 2][location.y + (2 * a)] == null) {
                        tmp.add(new Tuple<>(location.x - 2, location.y + (2 * a)));
                    }
                }
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        return "K" + team.toString();

    }
}
