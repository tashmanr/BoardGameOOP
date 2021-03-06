package model.players;

import model.Tuple;
import model.boards.Board;
import ui.UI;

import java.util.ArrayList;

public class HumanPlayer extends Player {
    /**
     * Updates the game state to take a move for the current player.
     *
     * @param game    the game to update.
     */

    private UI ui;
    private String playerName;

    public HumanPlayer(String name, UI ui, Integer team) {
        super(team);
        playerName = name;
        this.ui = ui;
    }

    /**
     * Accept the
     *
     * @param board the board to update.
     * @return
     */
    public ArrayList<Tuple<Integer, Integer>> makeMove(Board board) {
        ArrayList<Tuple<Integer, Integer>> move = new ArrayList<>();

        Boolean valid_input = false;
        String[] arrOfStr;
        do {
            ui.write("please enter your move, if you finished entering the move enter 0, to exit the game enter -1:\n");
            String str = ui.read();
            if (str.equals("0")) {
                // the user finished entering his move
                if (move.isEmpty()) {
                    move.add(new Tuple<>(1, 1));
                }
                break;
            } else if (str.equals("-1")) {
                // the user wishes to exit the game
                move.clear();
                move.add(new Tuple<>(0, 0));
                break;
                //return move;
            } else {
                arrOfStr = str.split(",");
                if (arrOfStr.length != 2) {
                    ui.write("Incorrect Input! Try again! \n");
                } else {
                    move.add(new Tuple<>(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1])));
                }
            }
        } while (true);

        return move;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}
