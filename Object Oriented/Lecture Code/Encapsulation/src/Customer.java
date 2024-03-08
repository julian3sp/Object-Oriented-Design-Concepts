import java.util.LinkedList;

class Customer {

    String name;

    int password;

    LinkedList<Account> accounts;



    // check whether the given password matches the one for this user

    // in a real system, this method would return some object with

    // info about the customer, not just a string

    String tryLogin(int withPwd) {

        if (this.password == withPwd)

            return "Welcome";

        else

            return "Try Again";

    }

}



class BankingService {

    ...

    String login(String custname, int withPwd) {

        for (Customer cust:customers) {

            if (cust.name.equals(custname)) {

                cust.tryLogin(withPwd);

            }

        }

        return "Oops -- don't know this customer";

    }

}

class Account {
    int number;
    Customer owner;
    double balance;
}

class BankingService {
    LinkedList<Account> accounts;
    LinkedList<Customer> customers;

    double getBalance(int forAcctNum) {
        for (Account acct:accounts) {
            if (acct.number == forAcctNum)
                return acct.balance;
        }
        return 0;
    }

    double withdraw(int forAcctNum, double amt) {
        for (Account acct:accounts) {
            if (acct.number == forAcctNum) {
                acct.balance = acct.balance - amt;
                return amt;
            }
        }
        return 0;
    }

    String login(String custname, int withPwd) {
        for (Customer cust:customers) {
            if (cust.name.equals(custname)) {
                if (cust.password == withPwd)
                    return "Welcome";
                else
                    return "Try Again";
            }}
        return "Oops -- don't know this customer";
    }

}