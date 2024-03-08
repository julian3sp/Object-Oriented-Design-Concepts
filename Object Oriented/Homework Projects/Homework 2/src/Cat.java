public class Cat extends Pet {
    public boolean hasBeenPetToday;
    public Cat (String name,
               int age,
               int weightInOz,
               Coord2D location,
               boolean hasBeenPetToday){
       super(name, age, weightInOz, location);
        this.hasBeenPetToday = hasBeenPetToday;
    }
    //eats 1 unit when eats() is called with "cans" and the cat has not been pet today
   // eats 2 units when eats() is called with "cans" and the cat has been pet today
   // eats 1 "treat" plus 1 extra treat for every 8 oz they weigh when eats() is called with "treats"

    @Override
    public int eats(String foodLabel) {
        int yummy = 0;
        if( this.hasBeenPetToday == false && foodLabel == "cans"){
            yummy = 1;
        }
        else if(this.hasBeenPetToday == true && foodLabel == "cans"){
            yummy = 2;
        }
        else if(foodLabel == "treats") {
            if ((this.weightInOZ / 8) >= 1) {
                yummy = (1 + (int) Math.floor(this.weightInOZ / 8));
            } else if ((this.weightInOZ / 8) < 1) {
                yummy = 1;
            }
        }
        else{
            yummy = 0;
            }


        return yummy;

    }
}
