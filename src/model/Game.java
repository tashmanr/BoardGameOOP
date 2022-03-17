package model;

import model.boards.Board;
import model.players.Player;
import savedGames.ISavedGamesDatabase;
import savedGames.SavedGamesDatabaseCSV;
import ui.UI;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;
    private Player currentPlayer;
    private boolean isOver = false;
    private boolean shouldQuit = false;
    private Player winner;
    private ISavedGamesDatabase sgdb;
    private UI ui;

    public Game(UI ui) {
        sgdb = new SavedGamesDatabaseCSV();
        this.ui = ui;
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
            ui.write("Would you like to save your game? [y/n]");
            String input = ui.read();
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
            ui.write(board.toString());
            boolean played = false;
            while (!played && !shouldQuit) {
                ArrayList<Tuple<Integer, Integer>> move = currentPlayer.makeMove(board);
                if (move == null) {
                    //player can't make any more moves, game over
                    isOver = true;
                    played = true;
                } else if (move.size() == 1) {
                    if (move.get(0).x == 0 && move.get(0).y == 0) {
                        shouldQuit = true;
                    } else {
                        ui.write("Invalid move.");
                    }
                } else {
                    if (checkMoveLegal(move, currentPlayer)) {
                        played = true;
                        makeMove(move, currentPlayer);
                    } else {
                        ui.write("Invalid move.");
                    }
                }
            }
            //check if game is over
            if (!isOver && gameOver()) {
                isOver = true;
            }
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
            if (!player1.toString().equals("ComputerPlayer")) {
                // if player1 has no more pieces left, player 2 wins, else player1
                if (board.getTeam(1).isEmpty()) {
                    winner = player2;
                } else {
                    winner = player1;
                }
            }
        }
    }

    public abstract Boolean makeMove(ArrayList<Tuple<Integer, Integer>> moves, Player player);

    public abstract Boolean checkMoveLegal(ArrayList<Tuple<Integer, Integer>> moves, Player player);

    public abstract boolean gameOver();

    public Player getWinner() {
        return winner;
    }
}
