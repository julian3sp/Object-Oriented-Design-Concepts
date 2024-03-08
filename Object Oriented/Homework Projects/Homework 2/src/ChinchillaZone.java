import java.util.LinkedList;

public class ChinchillaZone extends Zone{

    LinkedList<Chinchilla> chinchillas;
    public ChinchillaZone(LinkedList<Chinchilla> chinchillas){
    this.chinchillas = chinchillas;
    }
    //a chinchilla's age "in human years" is its actual age * 10


    public LinkedList<? extends Petable> getPets() {
        return this.chinchillas;
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
        for(Chinchilla c : this.chinchillas){
            if (c.name == petName){
                petAge = c.age * 10;
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
        for (Chinchilla c : this.chinchillas){
            c.eats("pellets");
            c.eats("hay");
            pellets -= 1;
            hay -=1;
        }
        if (pellets < 0){
            pellets = 0;
        }
        if(hay < 0){
            hay = 0;
        }
        return this;
    }

    @Override
    public String getPantryLabel() {
        return "Chinchilla: " + pellets + " pellets, " + hay + " hay";
    }

    @Override
    public String closestPet(int x, int y) {
        if (chinchillas.isEmpty()) {
            return "No Pets Found";
        }
        Chinchilla closest;
        closest = null;

        for (Chinchilla c : chinchillas) {
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
