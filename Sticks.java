import java.util.*;
public class Sticks {
    //<editor-fold desc="Main Method">
    public static void main(String[] args) {
        int wincounter = 0;
        int losscounter = 0;
        boolean loop = false;
        while (!loop) {
            int randomInt = (int) (10 * Math.random());
            int sticks = 30 - randomInt;
            Scanner scan = new Scanner(System.in);
            System.out.println("Currently our score is you "+wincounter+" me "+ losscounter+". There are " + sticks + " sticks. Who goes first? Enter 'you' if you want me to go first, and 'me' if you want to go first");
            String order = scan.next();
            boolean turn;
            if (order.equalsIgnoreCase("you")) {
                turn = false;
            } else {
                turn = true;
            }
            while (sticks > 0) {
                if (turn)
                    sticks = playerMove(sticks, scan);
                else
                    sticks = computerMove(sticks);
                System.out.println("There are " + sticks + " sticks left.");
                if (sticks == 0 && turn) {
                    System.out.println("You win!");
                    wincounter = wincounter + 1;
                }
                if (sticks == 0 && !turn) {
                    System.out.println("You Lose!");
                    losscounter = losscounter + 1;
                }
                turn = !turn;
            }
        }
    }
    //</editor-fold>
    //<editor-fold desc="PlayerMove">
    public static int playerMove(int sticks, Scanner scan){
            System.out.println("Choose sticks to take?");
            int take = scan.nextInt();
            if (take<1){
                take = 1;
            }
            if(take >3){
                take = 3;
            }
            else if(take > sticks)
                take = sticks;
            System.out.println("You took "+take+" sticks.");
            return sticks - take;
        }
    //</editor-fold>
    //<editor-fold desc="ComputerMove">
    public static int computerMove(int sticks){
            int take;
            if (sticks % 4 != 0){
                take = sticks % 4;
            }
            else{
                take = (int)(Math.random() * 3) + 1;
            }
            System.out.println("I took "+take+" sticks");
            return sticks - take;
        }
    //</editor-fold>
    }