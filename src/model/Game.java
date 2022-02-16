package model;

import model.boards.Board;
import model.players.Player;

public abstract class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;
    private boolean player1Turn = true;
    private boolean isOver = false;
    private Player winner;

    public void loadGame() {
        board.loadBoard();
    }

    public void setPlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public void start() {
        while (!isOver) {
            //play turn
            System.out.print(board);
            System.out.print("\n");
            if (player1Turn) {
                player1.makeMove(this);
            } else {
                player2.makeMove(this);
            }
            //check if game is over
            //switch turn
            player1Turn = !player1Turn;
        }
        // TODO: need to define logic to declar winner
        if (player1Turn) {
            winner = player1;
        } else {
            winner = player2;
        }
    }

    public Player getWinner() {
        return winner;
    }
}
