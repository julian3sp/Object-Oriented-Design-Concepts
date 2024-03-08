public class MoreThanOnceException extends Exception{
    MoreThanOnceException(String candidate){
        super("you already voted for " + candidate);
    }
}
