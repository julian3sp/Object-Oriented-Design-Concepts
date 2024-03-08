
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    Dillo dillanTheDillo;
    Boa bettyTheBoa;

    public Examples() {
        dillanTheDillo = new Dillo("Dillan", 10, false);
        bettyTheBoa = new Boa( "Betty" , 6,  "Popcorn",  "FTC");
    }

   @Test
   public void testDillanShouldFitInA6InchCage(){
        int dillanRadiusInInches = dillanTheDillo.length / 2;
        assertTrue("Dillian's radius should be less than 6", dillanRadiusInInches < 6);
   }

    @Test
    public void testDillanShouldNotFitInA4InchCage(){
        int dillanRadiusInInches = dillanTheDillo.length / 2;
        assertFalse("Dillian's radius should be less than 6", dillanRadiusInInches < 4);
    }

    @Test
    public void testDillansNameIsDillan(){
        assertEquals("dillian's name should be Dillian", dillanTheDillo.name, "Dillan");
    }

    @Test
    public void testSeveralDillos(){
        LinkedList<Dillo> dillos = new LinkedList<>(); /* LL1. Initialize an empty list */
        dillos.add(new Dillo("Andi",4,false));
        dillos.add(new Dillo("Bandi", 5, false));
        dillos.add(new Dillo("Candi",6,false));
        dillos.add(new Dillo("Dandi(ed)",7,true));

        assertEquals("There should be 4 dillos", dillos.size(),4);
    }

    /* CHALLENGE PROBLEMS */

    /* 1. Add a constructor to the Boa class
     * 2. Add a Boa field (instance variable) to this file
     * 3. Initialize the Boa to whatever you want in the constructor
     * 4. Add a test that checks if the Boa's length is < some number
     * 5. Add a test that checks if the Boa's favorite food is "Popcorn with Hot Butter"
     * 6. Add a test that checks if the Boa's favorite food is "Popcorn by Hot Butter"
     *        and  also if both the Boa's favorite song is "Popcorn by Hot Butter"
     *        Use 2 assertEquals in the same method
     *        Imaginary Bonus points if you make a helper method and call it from both test 5 and test 6
     *        https://www.youtube.com/watch?v=YK3ZP6frAMc
     *          Note: We only want to put multiple assertEquals into a single test if they both RELATE TO EACH OTHER
     *                If we are testing different properties, they should be separate test
     * 7. Turn the logic of the dillo fitting in a cage of a certain sideLength into an instance method
     * 8. Add a test to test this method
     */


@Test
public void testBettyIsLessThan7InchesLong() {
    assertTrue("Betty should be less than 7 inches", bettyTheBoa.length < 7);
}


@Test
public void testBettyLikePopcorn(){
    assertEquals("Popcorn with hot butter", bettyTheBoa.favoriteFood, "Popcorn");
}
}

