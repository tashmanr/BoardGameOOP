package model.players;

import io.DefaultIO;
import model.Tuple;

public class PlayerInitializer {
    public Tuple<Player, Player> getPlayers(int players, String name1, String name2, int level, DefaultIO io) {
        Player p1;
        Player p2;
        switch (players) {
            case 2:
                p1 = new HumanPlayer(name1, io, 1);
                p2 = new HumanPlayer(name2, io, 2);
                break;
            case 1:
                p1 = new HumanPlayer(name1, io, 1);
                IComputerStrategy strategy;
                if (level == 2) {
                    strategy = new MostJumpsOption();
                } else {
                    strategy = new FirstOption();
                }
                p2 = new ComputerPlayer(strategy, 2);
                break;
            default:
                p1 = new ComputerPlayer(new MostJumpsOption(), 1);
                p2 = new ComputerPlayer(new FirstOption(), 2);
        }
        return new Tuple<>(p1, p2);
    }
}
