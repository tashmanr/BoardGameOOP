package io;

import java.util.Scanner;

public class TerminalIO extends DefaultIO {
    private Scanner sc;

    public TerminalIO() {
        sc = new Scanner(System.in);
    }

    @Override
    public String read() {
        return sc.nextLine();
    }

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
