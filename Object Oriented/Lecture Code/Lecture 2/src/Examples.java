

/* 1. Example class and methods: Look at Dillo.java */

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    Dillo dillanTheDillo;
    Boa bettyTheBoa;
    LinkedList<Dillo> dillos = new LinkedList<>();

    public Examples() {
        dillanTheDillo = new Dillo("Dillan", 10, false);
        bettyTheBoa = new Boa("Betty",
                30.0,
                "Popcorn with Hot Butter",
                "Popcorn by Hot Butter");
        dillos.add(dillanTheDillo);
        dillos.add(new Dillo("Arma D.",8,false));
        System.out.println(dillanTheDillo.fitsInCage(6));

    }
    @Test
    public void doesBettyFitIn10InchCage(){
        assertTrue(bettyTheBoa.fitsInCage(100));
    }

    @Test
    public void anyDillosCageableInA4InchCage(){
        boolean anyCageable = false;
        for(Dillo aDillo : dillos){
            anyCageable = anyCageable || aDillo.fitsInCage(4);

        }
        // 1a. Which is it?
        //assertTrue("At least 1 dillo should be cageable in a 4 inch cage",anyCageable);
        assertFalse("No dillos should be cageable in a 4 inch cage",anyCageable);
    }

    @Test
    public void allDillosCageableInA20InchCage(){
        boolean allCageable = true;
        for(Dillo dillo : dillos){
            allCageable = allCageable && dillo.fitsInCage(20);
        }
        assertTrue("All dillos should not be cageable in a 20 inch cage",allCageable);

    }

    @Test
    public void allAnimalsCageableInA20InchCage(){
        boolean allCageable = true;
        LinkedList<Cageable> animals = new LinkedList<>();
        animals.add(dillanTheDillo);
        animals.add(bettyTheBoa);
        animals.add(new Tiger("tony", 7, true));
        for(Cageable anAnimal : animals){
            allCageable = allCageable && anAnimal.fitsInCage(20);
        }
        assertFalse("Betty doesnt fit in a 20 inch cage",allCageable);

    }
    @Test
    public void allTigersFitInCage(){

    }

    /* 2. Together we will:
     * - Add javadocs to Boa
     * - Use an interface to group compound data by common methods (CS1101 folks: Itemization)
     *   - Look at Cageable
     * - Make Boa implement Cageable
     * - Write a test that creates a linked list of Cageables
     * - Add an assertTrue test that checks if all animals in a list fit in a 10 inch cage with a mix
     *   of Dillos and Boas
     */

    /* 3. CHALLENGE PROBLEMS */
    /* - Define a class Tiger
     *  - It can have any fields you like
     *  - it implements Cageable
     *    - fitsInCage always returns true since cats are liquid
     *  - Add a unit test that adds tigers to the list and checks if any or all of them are cageable, your choice
     *    - Whether you should assertTrue or assertFalse depends on what sideLength you choose and what animal data you make
     */




}
