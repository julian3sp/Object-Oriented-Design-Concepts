// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        RotaryPhone rp = new RotaryPhone("5559991234",1.2);
        System.out.println(rp.whatsMyPhoneNumber());
        //SmartPhone sp = new SmartPhone("8881119876","T-Mobile",512);
        //System.out.println(sp.whatsMyPhoneNumber());

        AndroidPhone a = new AndroidPhone("5559991234","T-mobile",
                512, 14.0, "Samsung", "Galexy S23+");
        a.receiveCall("9001234567").receiveCall("8881237654");
    }
}