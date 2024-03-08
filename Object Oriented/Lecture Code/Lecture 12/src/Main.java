

import java.util.ArrayList;
import java.util.List;

public class Main {
    /* Lecture 12 instructions:
       - make all fields private
       - add getters to all of the DTOs, but do not add setters (immutable data is happy data)
       - fix all the errors
       - get rid of getToys from the ToyBinStrategy
       - define a new interface that extends ToyBinStrategy that adds the new "rarity" behavior
       - think about extension
         - what fields should be protected instead of private? how do we know ahead of time?

       Vocabulary:
       - Encapsulation:
         - limiting access to data (fields) either by input, mutation, or output to protect invariants
         - prioritizing letting the class that has the data answer questions about it / own it rather than
           getting data out of it and answering yourself
       - Interface Segregation principle: only have methods in the same interface that need each other to function
       - Dependency Inversion Principle:
         - specifics should depend on abstractions (not the other way around)
         - I.e. use the most generic type you can get away with for your implementations for maximum flexibility
     */

    public static void main(String[] args){
        //generated with the help of ChatGPT4.0
        List<Toy> pokemonToys = new ArrayList<>();

        // A pool of Pokemon names
        String[] pokemonNames = {"Pikachu", "Charizard", "Bulbasaur", "Squirtle", "Jigglypuff",
                "Eevee", "Snorlax", "Mewtwo", "Gengar"};

        // Creating 100 Pokemon toys with possible repeats
        for (int i = 0; i < 100; i++) {
            String name = pokemonNames[i % pokemonNames.length];
            int rarity = i % 11;
            pokemonToys.add(new Toy(name, rarity));
        }

        Gachapon g = new Gachapon(pokemonToys);

        for(int i = 0; i < 50; i++) {
            System.out.println(g.loadQuarter().loadQuarter().receiveToys());
        }

        g.setStrategy(new Rigged2QtrStrat());

        for(int i = 0; i < 50; i++) {
            System.out.println(g.loadQuarter().loadQuarter().receiveToys());
        }


       
    }


}
