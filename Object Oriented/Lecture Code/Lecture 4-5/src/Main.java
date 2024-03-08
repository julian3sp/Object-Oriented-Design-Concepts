// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        RotaryPhone rp = new RotaryPhone("5559991234",1.2);
        System.out.println(rp.whatsMyPhoneNumber());
        SmartPhone sp = new SmartPhone("8881119876","T-Mobile",512);
        System.out.println(sp.whatsMyPhoneNumber());
    }
}