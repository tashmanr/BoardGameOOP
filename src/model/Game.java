package model;

import model.boards.Board;
import model.pieces.GamePiece;
import model.players.Player;
import savedGames.ISavedGamesDatabase;
import savedGames.SavedGamesDatabaseCSV;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;
    private boolean player1Turn = true;
    private boolean isOver = false;
    private Player winner;
    private ISavedGamesDatabase sgdb = null;

    public Game() {
        sgdb = new SavedGamesDatabaseCSV();
    }

    public void loadGame(boolean newGame) {
        if (newGame) {
            board.loadNewBoard();
        } else board.loadSavedBoard(getSavedBoard());
    }

    public Tuple<HashMap<String, ArrayList<Tuple<Integer, Integer>>>, HashMap<String, ArrayList<Tuple<Integer, Integer>>>> getSavedBoard() {
        return sgdb.getData();
    }

    public void saveBoard() {
        sgdb.saveData(board.getTeam(1), board.getTeam(2));
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
            isOver = true;
            //switch turn
            player1Turn = !player1Turn;
        }
        // TODO: need to define logic to declare winner
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
