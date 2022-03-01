package model.players;

import model.Game;
import model.Tuple;
import java.util.ArrayList;

import java.util.Scanner;

public class HumanPlayer extends Player {
    /**
     * Updates the game state to take a move for the current player.
     * @param game	the game to update.
     */
    
    private Scanner sc;
    private String playerName = "Human";

    public HumanPlayer(String name){
        // Using Scanner for Getting Input from User
        this.sc = new Scanner(System.in);
        playerName = name;
    }
    
    public ArrayList<Tuple<Integer,Integer>> makeMove(Game game){
        ArrayList<Tuple<Integer,Integer>> move = new ArrayList<Tuple<Integer,Integer>>();

        Boolean valid_input = false;
        String[] arrOfStr;
        do{
            // the input needs to be in format 1,2 3,4 while 1,2 is starting pos and 3,4 is new desired position
            System.out.print("please enter your move:\n");
            String str= sc.nextLine();
            arrOfStr = str.split("[ ,]+");

            System.out.print(str);
            System.out.print("\n\n");
            System.out.print(arrOfStr.length+"\n");

            // TODO add if there are multiple jumps

            if(arrOfStr.length != 4){
                System.out.print("Incorrect Input! Try again! \n");
            }
            else{
                valid_input = true;
            }
        }while(!valid_input);

        move.add(new Tuple(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1])));
        move.add(new Tuple(Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3])));
        return move;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}
