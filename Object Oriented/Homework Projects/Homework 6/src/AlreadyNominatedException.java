public class AlreadyNominatedException extends Exception{
    AlreadyNominatedException(String candidate){
        super(candidate + " has already been nominated");
    }
}
