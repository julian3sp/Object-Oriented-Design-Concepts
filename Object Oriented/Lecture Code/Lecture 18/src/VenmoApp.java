import javax.swing.text.html.Option;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VenmoApp {
   private List<VenmoAccount> accounts = new LinkedList<>();

    public void registerAccount(String name) throws AccountAlreadyExistsException{
        Optional<VenmoAccount> account = this.lookUpAccount(name);
        if(account.isPresent()){
            // throw an account already exists error
            throw new AccountAlreadyExistsException(account.get().getName());
        }
    }

    public Optional<VenmoAccount> lookUpAccount(String name){
        Optional<VenmoAccount> acc = Optional.empty();
        for (VenmoAccount va : this.accounts){
            if(va.getName().equals(name)){
                return Optional.of(va);
            }
        }
        return Optional.empty();
    }

    public void transfer(String from, double amount, String to){
        Optional<VenmoAccount> fromAcc = this.lookUpAccount(from);
        Optional<VenmoAccount> toAcc = this.lookUpAccount(to);
        if(fromAcc.isEmpty()){
            throw new AccountDoesntExistsException(from);
        }
        if(toAcc.isEmpty()){
            throw new AccountDoesntExistsException(to);
        }
        VenmoAccount fromAccount = fromAcc.get();
        VenmoAccount toAccount = toAcc.get();

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

    }
}
