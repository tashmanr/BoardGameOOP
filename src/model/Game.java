package model;

import io.DefaultIO;
import model.boards.Board;
import model.players.Player;
import savedGames.ISavedGamesDatabase;
import savedGames.SavedGamesDatabaseCSV;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;
    private boolean player1Turn = true;
    private Player currentPlayer;
    private boolean isOver = false;
    private boolean shouldQuit = false;
    private Player winner;
    private ISavedGamesDatabase sgdb;
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
        boolean answered = false;
        while (!answered) {
            dio.write("Would you like to save your game? [y/n]");
            String input = dio.read();
            if (input.equals("y")) {
                sgdb.saveData(board.getTeam(1), board.getTeam(2));
                answered = true;
            } else if (input.equals("n")) {
                answered = true;
            }
        }
    }

    public void setPlayers(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    public void start() {
        currentPlayer = player1;
        while (!isOver && !shouldQuit) {
            //play turn
            dio.write(board.toString());
            boolean played = false;
            while (!played && !shouldQuit) {
                ArrayList<Tuple<Integer, Integer>> move = currentPlayer.makeMove(board);
                if (move.size() == 1 && move.get(0).x == 0 && move.get(0).y == 0) {
                    shouldQuit = true;
                } else {
                    if (checkMoveLegal(move, currentPlayer)) {
                        played = true;
                        makeMove(move, currentPlayer);
                    }
                }
            }
            //check if game is over
            //switch turn
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
        if (shouldQuit) {
            saveBoard();
        } else {
            // if player1 has no more pieces left, player 2 wins, else player1
            if (board.getTeam(1).isEmpty()) {
                winner = player2;
            } else {
                winner = player1;
            }
        }
    }

    public abstract Boolean makeMove(ArrayList<Tuple<Integer, Integer>> moves, Player player);

    public abstract Boolean checkMoveLegal(ArrayList<Tuple<Integer, Integer>> moves, Player player);

    public Player getWinner() {
        return winner;
    }
}
