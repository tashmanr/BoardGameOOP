import java.util.ArrayList;

public class ManPiece extends GamePiece{

    public ManPiece(Integer team) {
        super(team);
    }

    @Override
    public ArrayList<Integer> getMoveDirection() {
        if (team == 1){
            return new ArrayList<>(1);
        }
        else{
            return new ArrayList<>(-1);
        }
    }


}
