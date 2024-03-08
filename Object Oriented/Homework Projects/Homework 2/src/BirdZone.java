import java.util.LinkedList;

public class BirdZone extends Zone{
    //A bird's age "in human years" is its actual age * 9
    //The food stored in the BirdZone is "seeds"
    //The pantry label has the form "Bird: # seeds"
    //We assume a bird has a z-coordinate in 3D space of 2 if its wings are not clipped
            //(its perched up high)
    //and so a high up, non-wing-clipped bird's distance is calculated 3-dimensionallyLinks to an external site.
            //(assume the z-coordinate of the point given to closestTo(x,y) is 0)
    LinkedList<Bird> birds;
    public BirdZone(LinkedList<Bird> birds){
        this.birds = birds;
    }
    public LinkedList<? extends Petable> getPets() {
        return this.birds;
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
        for(Bird c : this.birds){
            if (c.name == petName){
                petAge = c.age * 9;
            }
        }
        if(petAge == Integer.MIN_VALUE){
            return -1;
        }
        else
            return petAge;
    }

    @Override
    public Zoneable feedZone() {
        for (Bird c : this.birds){
            c.eats("seeds");
            seeds -= 1;
        }
        if (seeds < 0){
            seeds = 0;
        }
        return this;
    }


    @Override
    public String getPantryLabel() {
        return "Bird: " + seeds + " seeds";
    }


    public String closestPet(int x, int y) {
        if (getPets().isEmpty()) {
            return "No Pets Found";
        }
        Bird closest;
        closest = null;

        for (Bird c : birds) {
            if (closest == null) {
                closest = c;
            }
            if (c.wingsClipped != true) {
                double currentDistance = this.distance(x, y, 0, c.location.x, c.location.y, 2);
                double closestDistance = this.distance(x, y, 0, closest.location.x, closest.location.y, 2);
                if (currentDistance < closestDistance) {
                    closest = c;
                }
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
