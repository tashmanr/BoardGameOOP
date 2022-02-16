import io.TerminalIO;
import ui.CLI;

public class Main {
    public static void main(String[] args) {
        CLI cli = new CLI(new TerminalIO());
        cli.start();
    }
}
