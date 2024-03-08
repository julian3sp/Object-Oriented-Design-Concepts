import java.io.IOException;
import java.util.Scanner;

public class WordGuesserAfter {

    private Scanner scanner = new Scanner(System.in);

    private IWords wordGenerator;

	private WordGame wg;




    



    public static void main(String[] args) {
    	try {
          WordGuesserAfter wg = new WordGuesserAfter(new AnimalWords());
          wg.play();
    	}
    	catch(IOException e) {
    		System.out.println("where the heck the file?");
    	}
        
    	
    	
    }

    public WordGuesserAfter(IWords wordGenerator){
        this.wordGenerator = wordGenerator;
        wg = new WordGame(wordGenerator.randomWord().toLowerCase());
    }

    public void play(){
        while(wg.currentStatus() == WordGame.STATUS.KEEP_PLAYING){
        	// PRINT THE CURRENT GUESS
        	System.out.printf("Current guess: %s\n", wg.currentProgress());
         	// PRINT THE NUMBER OF GUESSES LEFT
        	System.out.printf("Number of guesses left: %d\n", wg.remainingGuesses());
        	// ASK THE USER IF THEY WANT TO GUESS THE WORD OR GUESS A LETTER OR QUIT
        	System.out.println("Do you want to guess a [l]etter, a [w]ord, or [q]uit?");

        	// TAKE THE INPUT
        	String input = scanner.nextLine().toLowerCase().trim();
        	// HANDLE EACH CASE
        	if(input.startsWith("l")) { // guess a letter
        		//Prompt them to guess a letter
        		System.out.println("Guess a letter");
        		//take the letter
        		String letter = scanner.nextLine().toLowerCase().trim().substring(0,1);
        		boolean goodGuess = wg.guessLetter(letter);
				if(goodGuess) {
					System.out.println("You guessed correctly!");
				} else {
					System.out.println("You guessed incorrectly!");
				}
        	}
        	else if(input.startsWith("w")) { //guess a word
        		//Prompt them to guess a word
        		System.out.println("Guess a word");
        		//take the word
        		String word = scanner.nextLine().toLowerCase().trim();
        		boolean goodGuess = wg.guessWord(word);
				if(goodGuess) {
					System.out.println("You guessed correctly!");
				} else {
					System.out.println("You guessed incorrectly!");
				}
        	}
        	else { //want to quit
        		System.out.println("Thanks for playing!");
				wg.quit();
        	}
        	if(wg.currentStatus() == WordGame.STATUS.WON){
				System.out.println("You won!");
			}
			else if(wg.currentStatus() == WordGame.STATUS.LOSE){
				System.out.printf("You lose! The answer was: %s", wg.getCurrentWord());

			}
        }
    }


}