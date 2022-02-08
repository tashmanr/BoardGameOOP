public abstract class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;

    public void loadGame(){
        board.loadBoard();
    }

    public void setPlayers(Player p1, Player p2){
        player1 = p1;
        player2 = p2;
    }

    public abstract void  start();
}
