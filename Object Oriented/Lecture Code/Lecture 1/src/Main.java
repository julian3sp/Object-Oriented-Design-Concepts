
/* Instructors Notes
 *  - We will uncomment the //s as we go
 *  - Some vocabulary is given
 */

/* 1. Every file in java is a single class. Ignore that for now. Think of it like a code container*/
public class Main { /* 2. {...}s denote a block of code */

    /*  3. The main method is the method that the java virtual machine (JVM) calls first */
    public static void main(String[] args) { /* <- imperative code. CS1101 folks: implicit (begin ...) */
        /* 4.
         * public - any other code can call this function
         * static - this function does not depend on external state, like the functions from CS1101 in BSL / ISL
         * void   - this function produces nothing.
         * main   - the name of the function
         * String[]
         *   - array notation, we will learn more later.
         * (String[] args)
         *   - a parameter list of if this function is called from the command line/terminal.
         *   - the computer can pass input to it.
         */


        /* 5. Print stuff out to the console: */
        //System.out.println("Hello world!");

        /* 6. Do some integer arithmetic:  */
        //System.out.println(10/3);

        /*   decimal arithmetic: */
        //System.out.println(10.0 / 3); // double precision


        /*   String arithmetic (that's a joke, it's append/concat) */
        //System.out.println("Hello" + " " + "Everyone");


        /* 7. local variables */
        //double aNum = 3.3;
        //float anotherNum = 3.33f;
        //boolean thisVariableIsFalse = false;
        //int x;
        //String everyone = "Everyone";
        //System.out.println(String.format("Hello %s", everyone));
        //System.out.println(x);
        //System.out.println(1 + 2 + "3");

        /* 8. mutation of local variables */
        //String alphabet = "a";
        //alphabet = alphabet + "b";
        //alphabet += "c"; // Operators were posted in the readings
        //System.out.println(alphabet);

        /* 9. Booleans */
        //System.out.println(String.format("bool 1: %s", true));
        //System.out.println(String.format("bool 2: %s", false));
        //System.out.println(String.format("bool 3: %s", true && false));
        //System.out.println(String.format("bool 4: %s", true || false));
        //System.out.println(String.format("bool 5: %s", ! true));

        /* 10. in void functions, return is optional */
        //return;

        //System.out.println("unreachable!");
        int[][] myArray = { {1, 2},

                {3, 4} };
        System.out.print(myArray[1][1] + 10);



    }
}