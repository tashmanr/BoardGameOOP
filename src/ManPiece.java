import java.util.ArrayList;

public class ManPiece extends GamePiece{

    public ManPiece(Integer team) {
        super(team);
        if (team == 1){
            moves.add(1);
        }
        else{
            moves.add(-1);
        }
    }

}
