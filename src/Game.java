public abstract class Game {
    protected Board board;

    public void loadGame(){
        board.loadBoard();
    }

    public abstract void  start();
}
