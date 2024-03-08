public class OverdrawException extends Exception{

    private double amountOverdrawn;

    public OverdrawException(double amountOverdrawn){
        super("amount overdrawn: " + amountOverdrawn);
        this.amountOverdrawn = amountOverdrawn;
    }

    public double getAmountOverdrawn(){
        return amountOverdrawn;
    }
}
