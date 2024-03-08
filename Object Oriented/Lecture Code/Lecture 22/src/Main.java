import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner keyboard = new Scanner(System.in);

        boolean keepGoing = true;
        Random r = new Random();
        int number = r.nextInt(10);
        // Prompt the user to guess a number DONE
        // if they got it right, then tell them they won and ask if they want to play again
          // if they don't want to play again, terminate the program
          // if they do want to play again then set number to be a new random number
        // if they got it wrong, tell them whether their guess was too high or too low
        //  optional: keep track of how many guesses it takes them
        // if they enter quit instead of a number, then terminate the program DONE
        // if they enter restart instead of a number, set number to be a new random number DONE

        while(keepGoing){
            // Prompt the user to guess or enter "quit" or enter "restart"
            System.out.println("Please enter a number or quit or restart");
            // if the user's input is a guess
            if(keyboard.hasNextInt()) {
                int guess = keyboard.nextInt();
                keyboard.nextLine();
                // if they are correct
                if(guess == number) {
                    // print out "You win, do you want to play again"
                    System.out.println("You win, do you want to play again?");
                    // if "yes"
                    String yesNo = keyboard.nextLine();
                    System.out.println(yesNo);
                    if(yesNo.trim().toLowerCase().startsWith("y")){
                        // reset number
                        number = r.nextInt(10);
                    }
                    else{
                        // else if "no"
                        //set keep going to false
                        keepGoing = false;
                    }
                }
                else {
                    //if they are incorrect
                    // if their guess was too high
                    if(guess > number) {
                        //tell them too high
                        System.out.println("your guess is too high");

                    }
                    // else if their guess was too low
                    else {
                        System.out.println("your guess is too low");
                    }
                    //tell them too low
                }
            }
            else {

                // else if user's input is a string
                // if the user's input is quit
                String input = keyboard.nextLine();
                if(input.equals("quit")) {
                    keepGoing = false;
                }
                else{
                    number = r.nextInt(10);
                }
                //set keepGoing to false
                // else if the user's input is restart
                //reset number to a new number between 0 and 9
            }
        }

//        while(keepGoing){
//            String text = keyboard.nextLine();
//            boolean isNextAnInt = keyboard.hasNextInt();
//            int guess = keyboard.nextInt();
//            if(text.trim().equals("quit")){
//                keepGoing = false;
//            }
//            else{
//                String backwards = "";
//                for(int i = 0; i < text.length(); i++){
//                    backwards = text.charAt(i) + backwards;
//                }
//                System.out.println(text + backwards);
//            }
//        }



    }
}