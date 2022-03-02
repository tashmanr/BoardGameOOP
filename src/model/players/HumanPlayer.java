package model.players;

import io.DefaultIO;
import model.Game;
import model.Tuple;
import model.boards.Board;

import java.util.ArrayList;

import java.util.Scanner;

public class HumanPlayer extends Player {
    /**
     * Updates the game state to take a move for the current player.
     * @param game	the game to update.
     */
    
    //private Scanner sc;
    private DefaultIO io;
    private String playerName = "Human";

    public HumanPlayer(String name, DefaultIO io){
        // Using Scanner for Getting Input from User
        //this.sc = new Scanner(System.in);
        playerName = name;
        this.io = io;
    }

    /**
     * Accept the
     * @param board	the board to update.
     * @return
     */
    public ArrayList<Tuple<Integer,Integer>> makeMove(Board board){
        ArrayList<Tuple<Integer,Integer>> move = new ArrayList<Tuple<Integer,Integer>>();

        Boolean valid_input = false;
        String[] arrOfStr;
        do{
            io.write("please enter your move, if you finished entering the move enter 0, to exit the game enter -1:\n");
            //System.out.print("please enter your move, if you finished entering the move enter 0, to exit the game enter -1:\n");
            //String str= sc.nextLine();
            String str = io.read();
            if(str.equals("0")){
                // the user finished entering his move
                break;
            }
            else if(str.equals("-1")){
                // the user wishes to exit the game
                move.clear();
                move.add(new Tuple(0,0));
                break;
                //return move;
            }
            else{
                arrOfStr = str.split(",");
                if(arrOfStr.length != 2){
                    io.write("Incorrect Input! Try again! \n");
                    //System.out.print("Incorrect Input! Try again! \n");
                }
                else{
                    move.add(new Tuple(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1])));
                }
            }
        }while(true);

        return move;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}
