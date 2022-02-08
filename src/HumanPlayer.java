import java.util.Scanner;

public class HumanPlayer extends Player{
    /**
     * Updates the game state to take a move for the current player.
     * @param game	the game to update.
     */
    
    private Scanner sc;

    public HumanPlayer(){
        // Using Scanner for Getting Input from User
        this.sc = new Scanner(System.in);
    }
    
    public void makeMove(Game game){
        
        Boolean valid_input = false;
        do{
            System.out.print("please enter your desired move:\n");
            String str= sc.nextLine();
            String[] arrOfStr = str.split("[ ,]+");

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
        Tuple<Integer, Integer> end = new Tuple(Integer.parseInt(arrOfStr[3]), Integer.parseInt(arrOfStr[4]));

        return;
    }
}
