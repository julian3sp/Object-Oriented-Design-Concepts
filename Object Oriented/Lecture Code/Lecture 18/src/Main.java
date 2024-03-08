import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        VenmoAccount julianVenmo = new VenmoAccount("julian");
        julianVenmo.deposit(Math.random() * 500);
        try {
            julianVenmo.withdraw(100.0);
        }
        catch(OverdrawException oe){
            System.out.println(oe.getMessage());
            System.out.println("Julian has overdrawn by " + oe.getAmountOverdrawn());
            julianVenmo.deposit(10);
        }

        VenmoApp app = new VenmoApp();
       try {
           app.registerAccount("Kyle");
           app.registerAccount("Julia");
           app.lookUpAccount("Kyle").get().deposit(100.0);
           app.transfer("Kyle", 50, "Julia");
       }
     catch (Exception e){

     }
// Dont do this
//        String x = null;
//        try{
//            x.length();
//        }
//        catch (NullPointerException npe){
//            System.out.println("x is null");
//        }
//
        System.out.println("got here");
    }
}