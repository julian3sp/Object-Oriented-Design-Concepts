import java.util.Scanner;

public class WordGuesser {

    private Scanner scanner = new Scanner(System.in);

    private IWords wordGenerator;

    private String currentWord;

    private String currentGuess;


    public static void main(String[] args) {
        // WordGuesser wg = new WordGuesser(new AnimalWords());
        // wg.play()
    }

    public WordGuesser(IWords wordGenerator){
        this.wordGenerator = wordGenerator;
        this.currentWord = wordGenerator.randomWord();
        this.clearGuess();
    }

    public void play(){
        boolean keepPlaying = true;

        while(keepPlaying){


        }
    }

    public void clearGuess(){

    }


}