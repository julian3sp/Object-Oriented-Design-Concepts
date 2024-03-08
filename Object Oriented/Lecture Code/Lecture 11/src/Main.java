//package edu.wpi.ahrens.Lecture11;

import java.util.ArrayList;
import java.util.List;

public class Main {
        /* Lecture 11 instructions:
       - https://www.japantrendshop.com/img/takaratomy/life-size-pokemon-gashapon-machine-1.jpg
       - Run through code and see what it does
       - what if we want to separate responsibilities:
         - storing the money (i.e. payment storage)
         - toy exchange (i.e. list of toys and the quarter:toy ratio)
       - make an interface for the toy exchange
       - declare a field with this interface as its type
         - delegate to it instead
       - implement the interface for the current behavior and update the main method (in lieu of testing)
       - implement the interface for a rigged strategy that always gives the low-rarity toys first
       - oh no, we've been caught! implement "how many rare toys left" in prep for lecture 12 on encapsulation

       Vocabulary:
       - Strategy pattern: using composition rather than inheritance to swap out method implementations at runtime
       - composition: objects storing other objects as fields
     */

    public static void main(String[] args){
        //generated with the help of ChatGPT4.0
        List<Toy> pokemonToys = new ArrayList<>();

        // A pool of Pokemon names
        String[] pokemonNames = {"Pikachu", "Charizard", "Bulbasaur",
                "Squirtle", "Jigglypuff",
                "Eevee", "Snorlax", "Mewtwo", "Gengar"};

        // Creating 100 Pokemon toys with possible repeats
        for (int i = 0; i < 100; i++) {
            String name = pokemonNames[i % pokemonNames.length];
            int rarity = i % 12;
            pokemonToys.add(new Toy(name, rarity));
        }

        Gachapon g = new Gachapon(pokemonToys);

        for(int i = 0; i < 25; i++) {
            System.out.println(g.loadQuarter().loadQuarter().loadQuarter().loadQuarter().receiveToys());
        }
        g.switchStrategies(new RiggedToyBin());
        for(int i = 0; i < 25; i++) {
            System.out.println(g.loadQuarter().loadQuarter().loadQuarter().loadQuarter().receiveToys());
        }
        //Task:
        // be able to swap out the logic for how a toy is received while keeping the "paying for toy" mechanism the same

    }


}
