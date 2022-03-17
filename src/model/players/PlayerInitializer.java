package model.players;

import model.Tuple;
import ui.UI;

public class PlayerInitializer {
    public Tuple<Player, Player> getPlayers(int players, String name1, String name2, int level, UI ui) {
        Player p1;
        Player p2;
        switch (players) {
            case 2:
                p1 = new HumanPlayer(name1, ui, 1);
                p2 = new HumanPlayer(name2, ui, 2);
                break;
            case 1:
                p1 = new HumanPlayer(name1, ui, 1);
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
