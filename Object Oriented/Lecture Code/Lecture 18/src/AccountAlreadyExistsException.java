public class AccountAlreadyExistsException extends Exception{
    public AccountAlreadyExistsException(String name){
        super(name + " already exists");
    }
}
