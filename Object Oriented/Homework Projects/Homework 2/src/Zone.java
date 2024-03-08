import java.util.LinkedList;

public abstract class Zone implements Zoneable{

    public abstract LinkedList<? extends Petable> getPets();

   public int pellets;
   public int hay;
   public int cans;
   public int treats;
   public int seeds;



    @Override
    public int petsInZone() {
        int petsHere = 0;
        for( Petable c : getPets()){
            petsHere += 1;
        }
        return petsHere;
    }

    @Override
    public Petable heaviestPet() {
        Petable heaviestestPet = null;
        int heaviestWeight = 0;
        for(Petable c : this.getPets()){
            if(c.getWeightInOz() > heaviestWeight){
                heaviestWeight = c.getWeightInOz();
                heaviestestPet = c;

            }
        }
        return heaviestestPet;
    }

    @Override
    public Zoneable restockPetFood(String foodName, int foodAmt) {
        if( foodName == "seeds"){
            seeds += foodAmt;
        } else if (foodName == "pellets") {
            pellets += foodAmt;
        } else if (foodName == "hay") {
            hay += foodAmt;
        } else if (foodName == "cans") {
            cans += foodAmt;
        } else if (foodName == "treats") {
            treats += foodAmt;
        }
        return this;
    }

    @Override
    public Petable getPet(String petName) {
        Petable thePet = null;
        for(Petable c : this.getPets()){
            if(c.getName().equals(petName)){
                thePet = c;
            }
        }
        return thePet;
    }}





