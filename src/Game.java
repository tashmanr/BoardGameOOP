public abstract class Game {
    protected Board board;
    protected Player player1;
    protected Player player2;
    private boolean player1Turn = true;
    private boolean isOver = false;

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
            if (player1Turn) {
                player1.makeMove(this);
            } else {
                player2.makeMove(this);
            }
            //check if game is over
            //switch turn
            player1Turn = !player1Turn;
        }
    }
}
