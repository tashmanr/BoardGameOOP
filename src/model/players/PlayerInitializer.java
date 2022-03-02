package model.players;

import io.DefaultIO;
import model.Tuple;

public class PlayerInitializer {
    public Tuple<Player, Player> getPlayers(int players, String name1, String name2, int level, DefaultIO io) {
        Player p1 = new HumanPlayer(name1, io, 1);
        Player p2;
        if (players == 1) {
            IComputerStrategy strategy;
            if (level == 2) {
                strategy = new MostJumpsOption();
            } else {
                strategy = new FirstOption();
            }
            p2 = new ComputerPlayer(strategy, 2);
        } else {
            p2 = new HumanPlayer(name2, io, 2);
        }
        return new Tuple<>(p1, p2);
    }
}
