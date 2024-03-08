import java.util.LinkedList;



public class PetRescue implements PetRescueable {


    public int pelletCount;
    public int hayCount;

    LinkedList<Integer> birdWeights;
    LinkedList<Integer> dogYears;
    String petOfTheMonth;
    LinkedList<Coord> catCoords;

    public PetRescue(LinkedList<Integer> birdWeights,
                     LinkedList<Integer> dogYears,
                     String petOfTheMonth,
                     LinkedList<Coord> catCoords) {
    this.birdWeights = birdWeights;
    this.dogYears = dogYears;
    this.petOfTheMonth = petOfTheMonth;
    this.catCoords = catCoords;
    hayCount = 0;
    pelletCount = 0;
    }

    @Override
    public int biggestBird() {
        int maxValue;
        if (birdWeights.isEmpty()) {
            return 0;
        }
        else {
            maxValue = Integer.MIN_VALUE;
            for (Integer x : birdWeights) {
                if (x > maxValue)
                    maxValue = x;
            }
        }
        return maxValue;
    }

    @Override
    public LinkedList<Integer> inHumanYears() {
        LinkedList<Integer> inHumanYears = new LinkedList<Integer>();
        for (Integer x : dogYears){
            inHumanYears.add(x * 7);
        }
        return inHumanYears;
    }

    @Override
    public void bestowHonor(String title, String credential) {
        if (title.isEmpty() && credential.isEmpty()) {
            petOfTheMonth = petOfTheMonth;
        } else if (title.length() > 0 && credential.isEmpty()) {
            petOfTheMonth = (title + " " + petOfTheMonth);
        } else if (title.isEmpty() && credential.length() > 0) {
            if (petOfTheMonth.contains(",")) {
                petOfTheMonth = (petOfTheMonth + " " + credential);
            } else {
                petOfTheMonth = (petOfTheMonth + ", " + credential);
            }
        } else if (title.length() > 0 && credential.length() > 0) {
            if (petOfTheMonth.contains(",")) {
                petOfTheMonth = (title + " " + petOfTheMonth + " " + credential);
            } else {
                petOfTheMonth = (title + " " + petOfTheMonth + ", " + credential);
            }
        }
    }


    @Override
    public String feedChinchillas(int pellets, int hay) {
pelletCount = pelletCount + pellets;
hayCount = hayCount + hay;
        String result = "";
        if (pelletCount >= 0 && hayCount >= 0) {
            result = ("Chinchilla: " + Integer.toString(pelletCount) + " pellets" + ", " + Integer.toString(hayCount) + " hay");
        } else if (pelletCount < 0 && hayCount >= 0) {
            result = ("Chinchilla: unknown pellets, " + Integer.toString(hayCount) + " hay");
            pelletCount = 0;
        } else if (pelletCount >= 0 && hayCount < 0) {
            result = ("Chinchilla: " + Integer.toString(pelletCount) + " pellets, unknown hay");
            hayCount = 0;
        } else if (pelletCount < 0 && hayCount < 0){
            result = ("Chinchilla: unknown pellets, unknown hay");
            pelletCount = 0;
            hayCount = 0;
        }
        return result;
    }



    public double distance(int x, int y, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x), 2) + Math.pow((y2 - y), 2));
    }
    @Override
    public String closestTo(int x, int y) {
    if(catCoords.isEmpty()){
        return "Conspiciously Catless";
    }
        Coord closest;
        closest = null;
        for (Coord cat : catCoords){
            if (closest == null){
                closest = cat;
            }
            double currentDistance = this.distance(x, y, cat.x, cat.y);
            double closestDistance = this.distance(x, y, closest.x, closest.y);
            if( currentDistance < closestDistance){
                closest = cat;
            }

        }
        return closest.name;
    }

}


