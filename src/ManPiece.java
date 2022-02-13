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
    
    @Override
    public String toString() {
        return "M" + team.toString();

    }

}
