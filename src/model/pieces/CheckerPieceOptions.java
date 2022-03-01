package model.pieces;

public enum CheckerPieceOptions {
    // Possible moves for piece in  game
    Up(0), Down(1), Invalid(-1);

    private final int value;

    private CheckerPieceOptions(int value){
        this.value = value;
    }
    public int toInt() {
        return value;
    }
}
