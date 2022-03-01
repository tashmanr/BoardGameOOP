package model.pieces;

public enum CheckerPieceOptions {
    // Possible moves for piece in  game
    RightUp(0), LeftUp(1), RightDown(2), LeftDown(3);

    private final int value;

    private CheckerPieceOptions(int value){
        this.value = value;
    }
    public int toInt() {
        return value;
    }
}
