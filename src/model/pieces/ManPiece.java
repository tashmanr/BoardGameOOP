package model.pieces;

import model.Tuple;

import java.util.ArrayList;

public class ManPiece extends GamePiece {

    public ManPiece(Integer team) {
        super(team);
        if (team == 1) {
            // white
            moves.add(CheckerPieceOptions.Down.toInt());
        } else {
            //black
            moves.add(CheckerPieceOptions.Up.toInt());
        }
    }

    @Override
    public ArrayList<Tuple<Integer, Integer>> calculateMoves(Tuple<Integer, Integer> location, GamePiece[][] board) {
        ArrayList<Tuple<Integer, Integer>> tmp = new ArrayList<>();
        // if top right is empty, add it
        if (location.x + 1 < 8 && location.y + moves.get(0) >= 0 && location.y + moves.get(0) < 8) {
            if (board[location.x + 1][location.y + moves.get(0)] == null) {
                tmp.add(new Tuple<>(location.x + 1, location.y + moves.get(0)));
            } else if (!board[location.x + 1][location.y + moves.get(0)].getTeam().equals(team)) { // else if it's blocked by opposing team, see if we can jump
                if (location.x + 2 < 8 && location.y + (2 * moves.get(0)) >= 0 && location.y + (2 * moves.get(0)) < 8 &&
                        board[location.x + 2][location.y + (2 * moves.get(0))] == null) {
                    tmp.add(new Tuple<>(location.x + 2, location.y + (2 * moves.get(0))));
                }
            }
        }
        if (location.x - 1 >= 0 && location.y + moves.get(0) >= 0 && location.y + moves.get(0) < 8) {
            if (board[location.x - 1][location.y + moves.get(0)] == null) {
                tmp.add(new Tuple<>(location.x - 1, location.y + moves.get(0)));
            } else if (!board[location.x - 1][location.y + moves.get(0)].getTeam().equals(team)) { // else if it's blocked by opposing team, see if we can jump
                if (location.x - 2 >= 0 && location.y + (2 * moves.get(0)) >= 0 && location.y + (2 * moves.get(0)) < 8 &&
                        board[location.x - 2][location.y + (2 * moves.get(0))] == null) {
                    tmp.add(new Tuple<>(location.x - 2, location.y + (2 * moves.get(0))));
                }
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        return "M" + team.toString();

    }

}
