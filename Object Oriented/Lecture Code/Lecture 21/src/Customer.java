import java.math.BigInteger;

public class Customer {
    private String name;

    private String phone;

    public Customer(String name, String phone){
        this.name = name;
        this.phone = phone;
    }


    @Override
    public boolean equals(Object o){
        if(! (o instanceof Customer)){
            return false;
        }
        Customer co = (Customer) o;
        return this.name.equals(co.name) && this.phone.equals(co.phone);
    }

    @Override // If two keys are interchangable, they must have the same hashcode
    public int hashCode(){
        return (13 * this.name.hashCode()) ^ (17 * this.phone.hashCode());
    }
}
