package edu.wpi.ahrens.lecture19.part2_addKeyGeneric;

public class Main {

    public static void main(String[] args){
        BinarySearchTreeDB<Integer,String> someBST = new BinarySearchTreeDB<>(new BSTStrategyDB<Integer,String>(), new BSTValidatorDB<>());
        someBST.addKeyValue(4,"d");
        someBST.addKeyValue(2,"b");
        someBST.addKeyValue(6,"f");
        someBST.addKeyValue(1,"a");
        someBST.addKeyValue(3, "c");
        someBST.addKeyValue(5, "e");
        someBST.addKeyValue(7,"g");
        System.out.println(someBST.search(5));
        System.out.println(someBST.search(9));

        BinarySearchTreeDB<Integer,Double> someOtherBST = new BinarySearchTreeDB<>(new BSTStrategyDB<Integer,Double>(), new BSTValidatorDB<>());
        someOtherBST.addKeyValue(4,4.444);
        someOtherBST.addKeyValue(2,2.2);
        someOtherBST.addKeyValue(6,6.66666);
        someOtherBST.addKeyValue(1,1.0);
        someOtherBST.addKeyValue(3, 3.33);
        someOtherBST.addKeyValue(5, 5.555);
        someOtherBST.addKeyValue(7,7.777777);
        System.out.println(someOtherBST.search(5));
        System.out.println(someOtherBST.search(9));

        BinarySearchTreeDB<String,Integer> someStrBST = new BinarySearchTreeDB<>(new BSTStrategyDB<String, Integer>(), new BSTValidatorDB<>());
        someStrBST.addKeyValue("d",4);
        someStrBST.addKeyValue("b",2);
        someStrBST.addKeyValue("f",6);
        someStrBST.addKeyValue("a",1);
        someStrBST.addKeyValue("c",3);
        someStrBST.addKeyValue("e",5);
        someStrBST.addKeyValue("g",7);
        System.out.println(someStrBST.search("e"));
        System.out.println(someStrBST.search("z"));

        
        


    }
}
