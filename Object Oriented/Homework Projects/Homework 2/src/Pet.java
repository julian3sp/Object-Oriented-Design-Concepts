import java.util.LinkedList;

public abstract class Pet implements Petable{
    public String name;
    public int age;
    public int weightInOZ;
    public Coord2D location;

    public Pet(String name, int age, int weightInOz, Coord2D location) {
        this.name = name;
        this.age = age;
        this.weightInOZ = weightInOz;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }


    public int getWeightInOz() {
        return this.weightInOZ;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public int eats(String foodLabel) {
        return 0;
    }
}
