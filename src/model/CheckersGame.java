package model;

import model.boards.CheckersBoard;

public class CheckersGame extends Game {
    public CheckersGame(){
        this.board = new CheckersBoard();
    }

}
