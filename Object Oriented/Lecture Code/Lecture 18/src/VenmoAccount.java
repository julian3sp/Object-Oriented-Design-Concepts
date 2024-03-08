public class VenmoAccount {
    private String name;
    private double balance;

    public String getName(){
        return this.name;
    }

    public VenmoAccount(String name) {
        this.name = name;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws OverdrawException {
        balance -= amount;
        if (balance < 0) {
            OverdrawException oe = new OverdrawException(0 - balance);
            balance = 0;
            throw oe;
        }
    }
}
