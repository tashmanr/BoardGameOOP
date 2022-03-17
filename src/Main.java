import io.TerminalIO;
import ui.CLI;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        UI ui = new CLI();
        ui.start();
    }
}
