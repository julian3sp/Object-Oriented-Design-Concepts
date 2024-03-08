import java.util.LinkedList;

public class Bird extends Pet{
public boolean wingsClipped;

    public Bird(String name, int age, int weightInOz, Coord2D location, boolean wingsClipped){
       super(name, age, weightInOz, location);
        this.wingsClipped = wingsClipped;
    }

    //eats 1 unit when eats() is called with "seeds"

    @Override
    public int eats(String foodLabel) {
        int yummy = 0;
        if (foodLabel == "seeds"){
            yummy = 1;
            return yummy;
        }
        else
            return 0;

    }
}
