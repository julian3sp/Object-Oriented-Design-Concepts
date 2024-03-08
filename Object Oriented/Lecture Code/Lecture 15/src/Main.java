// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        IBinTree mt = new EmptyBT();
        IBinTree someTree =
                new NodeBT(3,
                        new NodeBT(1,mt,mt),
                        new NodeBT(-2,mt,mt));
        System.out.println(someTree);

        BinaryTree bt = new BinaryTree();
        bt.setStrategy(new BSTStrategy());
        for(int i = 0 ; i < 20; i++){
            bt.addInt((int) (Math.random() * 100));
        }
        System.out.println(bt);

        //bt.removeInt(12);
        //System.out.println(bt);




    }
}