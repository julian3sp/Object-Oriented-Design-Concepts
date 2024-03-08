public class Chinchilla extends Pet {
    //getWeightInOz() should include the chinchilla's weight as well as the dust on its fur
    //eats 3 units of food when eats() is called with "pellets"
    //eats 1 unit of food when eats() is called with "hay"
    public int dustBathResidueInOz;


    public Chinchilla(String name,
                      int age,
                      int weightInOz,
                      Coord2D location,
                      int dustBathResidueInOz) {
        super(name, age, weightInOz, location);
        this.dustBathResidueInOz = dustBathResidueInOz;
    }


    @Override
    public int getWeightInOz() {
        return (this.weightInOZ + this.dustBathResidueInOz);
    }


    @Override
    public int eats(String foodLabel) {
        int yummy = 0;
        if (foodLabel == "pellets") {
            yummy = 3;
        } else if (foodLabel == "hay") {
            yummy = 1;
        } else {
            return 0;
        }
        return yummy;
    }
}
