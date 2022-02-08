public abstract class Board {
    public GamePiece[][] pieces;

    public Board(){
        this.pieces = new GamePiece[8][8];
    }

    @Override
    public void LoadBoard();
}
