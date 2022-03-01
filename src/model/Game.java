package model;

import io.DefaultIO;
import model.boards.Board;
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
    private DefaultIO dio;

    public Game(DefaultIO dio) {
        sgdb = new SavedGamesDatabaseCSV();
        this.dio = dio;
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
            dio.write(board.toString());
            if (player1Turn) {
                ArrayList<Tuple<Integer,Integer>> move = player1.makeMove(this);

            } else {
                ArrayList<Tuple<Integer,Integer>> move = player2.makeMove(this);
            }
            //check if game is over
            //switch turn
            player1Turn = !player1Turn;
        }
        // if player1 has no more pieces left, player 2 wins, else player1
        if (board.getTeam(1).isEmpty()) {
            winner = player2;
        } else {
            winner = player1;
        }
    }

    public Boolean checkMoveLegal(Tuple<Tuple<Integer,Integer>, Tuple<Integer,Integer>> move, Player player){return false;}

    public Player getWinner() {
        return winner;
    }
}
