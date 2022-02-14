import java.util.Scanner;

public class HumanPlayer extends Player{
    /**
     * Updates the game state to take a move for the current player.
     * @param game	the game to update.
     */
    
    private Scanner sc;
    private String playerName = "Human";

    public HumanPlayer(){
        // Using Scanner for Getting Input from User
        this.sc = new Scanner(System.in);
        // TODO: need to get player to input name
    }
    
    public Tuple<Tuple<Integer,Integer>, Tuple<Integer,Integer>> makeMove(Game game){
        
        Boolean valid_input = false;
        String[] arrOfStr;
        do{
            // the input needs to be in format 1,2 3,4 while 1,2 is starting pos and 3,4 is new desired position
            System.out.print("please enter your move:\n");
            String str= sc.nextLine();
            arrOfStr = str.split("[ ,]+");

            System.out.print(str);
            System.out.print("\n\n");
            System.out.print(arrOfStr.length);

            if(arrOfStr.length != 4){
                System.out.print("Incorrect Input! Try again! \n");
            }
            else{
                valid_input = true;
            }
        }while(!valid_input);


        Tuple<Integer, Integer> start = new Tuple(Integer.parseInt(arrOfStr[0]), Integer.parseInt(arrOfStr[1]));
        Tuple<Integer, Integer> end = new Tuple(Integer.parseInt(arrOfStr[2]), Integer.parseInt(arrOfStr[3]));
        Tuple<Tuple<Integer,Integer>, Tuple<Integer,Integer>> move = new Tuple<>(start, end);
        return move;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}
