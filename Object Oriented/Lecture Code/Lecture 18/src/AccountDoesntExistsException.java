public class AccountDoesntExistsException extends Exception {
    public AccountDoesntExistsException(String name) {
        super(name + "doesnt exist");
    }
}
