package model;

import model.boards.CheckersBoard;

public class CheckersGame extends Game {
    public CheckersGame() {
        super();
        this.board = new CheckersBoard();
    }

}
