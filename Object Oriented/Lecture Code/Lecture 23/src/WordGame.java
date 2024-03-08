public class WordGame {

    private String[] currentGuess;
    private String currentWord;

    private int guesses;

    private STATUS currentStatus;

    public WordGame(String word){
        this.startGame(word);

    }

    // WHAT logical operations do I need a WordGame perform?
      // STEPS: Look at WordGuesserAfter's loop and think of the different actions
      //        the game is performing currently mixed in with IO

    public void startGame(String word){
        this.currentWord = word;
        this.guesses = 10;
        this.currentGuess = new String[this.currentWord.length()];
        this.currentStatus = STATUS.KEEP_PLAYING;
    }

    public boolean guessLetter(String letter){
        if(this.currentWord.contains(letter)) {
            for (int i = 0; i < this.currentWord.length(); i++) {
                // character at i is equal to letter
                if (String.valueOf(this.currentWord.charAt(i)).equals(letter)) {
                    this.currentGuess[i] = letter;
                }
            }
            return true;
        }
        else {
            this.guesses--;
            return false;
        }
    }

    public boolean guessWord(String word){
        if(this.currentWord.equals(word)) {
            this.currentStatus = STATUS.WON;
            return true;
        }
        else {
            this.guesses--;
            return false;
        }
    }

    public String currentProgress(){
       String progress = "";
       for(String letter : this.currentGuess){
           if(letter == null){
               progress+= "_";
           }
           else{
               progress += letter;
           }
       }
       return progress;
    }

    public enum STATUS {
        LOSE,KEEP_PLAYING,WON
    }

    public STATUS currentStatus(){
        if(guesses < 0){
            this.currentStatus = STATUS.LOSE;
        }
        return this.currentStatus;
    }

    public int remainingGuesses(){
        return this.guesses;
    }

    public String getCurrentWord(){
        return this.currentWord;
    }

    public void quit(){
        this.currentStatus = STATUS.LOSE;
    }



}
