public abstract class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;

    public void loadGame(){
        board.loadBoard();
    }

    public abstract void  start();
}
