import java.util.LinkedList;

public class CatZone extends Zone{
    LinkedList<Cat> cats;
    public CatZone(LinkedList<Cat> cats){
    this.cats = cats;
    }
   // A cat's age "in human years" is its actual age * 6
   // Cats eat "cans" of cat food and "treats"
   // The pantry label should be of the format: "Cat: # cans, # treats"
    public LinkedList<? extends Petable> getPets() {
        return this.cats;
    }
    public double distance(int x, int y, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
    }
    public double distance(int x, int y, int z, int x2, int y2, int z2){
        return Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2) + Math.pow((z2 - z), 2));
    }


    @Override
    public int inHumanYears(String petName) {
        int petAge = Integer.MIN_VALUE;
        for(Cat c : this.cats) {
            if (c.name == petName) {
                petAge = c.age * 6;
            }
        }
            if(petAge == Integer.MIN_VALUE ){
                return -1;
            }
            else
                return petAge;
        }

    @Override
    public Zoneable feedZone() {
        for (Cat c : this.cats){
            c.eats("cans");
            c.eats("treats");
            cans -= 1;
            treats -=1;
        }
        if (cans < 0){
            cans = 0;
        }
        if (treats < 0){
            treats = 0;
        }
        return this;
    }



    @Override
    public String getPantryLabel() {
        return "Cat: " + cans + " cans, " + treats + " treats";
    }

    @Override
    public String closestPet(int x, int y) {
        if (cats.isEmpty()) {
            return "No Pets Found";
        }
        Cat closest;
        closest = null;

        for (Cat c : cats) {
            if (closest == null) {
                closest = c;
            }
            double currentDistance = this.distance(x, y, c.location.x, c.location.y);
            double closestDistance = this.distance(x, y, closest.location.x, closest.location.y);
            if (currentDistance < closestDistance) {
                closest = c;
            }

        }
        return closest.name;
    }

}
