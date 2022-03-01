package model.pieces;

public enum CheckerPieceOptions {
    // Possible moves for piece in  game
    Up(1), Down(-1), Invalid(0);

    private final int value;

    CheckerPieceOptions(int value){
        this.value = value;
    }
    public int toInt() {
        return value;
    }
}
