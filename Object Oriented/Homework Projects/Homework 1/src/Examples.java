

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {

    PetRescue pr;
    LinkedList<Integer> someBirdWeights = new LinkedList<Integer>();
    LinkedList<Integer> emptyBirdWeights = new LinkedList<Integer>();
    LinkedList<Integer> someDogYears = new LinkedList<Integer>();

    LinkedList<Integer> emptyDogYears = new LinkedList<Integer>();
    LinkedList<String> somePetOfMonth = new LinkedList<String>();
    LinkedList<String> bestPetOfMonth = new LinkedList<String>();

    LinkedList<String> nonPetOfMonth = new LinkedList<String>();
    LinkedList<String> emptyPetOfMonth = new LinkedList<String>();
    LinkedList<Coord> someCoords = new LinkedList<Coord>();
    LinkedList<Coord> zeroCoords = new LinkedList<Coord>();

    LinkedList<Coord> noNameCoords = new LinkedList<Coord>();
    LinkedList<Coord> emptyCoords = new LinkedList<Coord>();



    public Examples(){
        someBirdWeights.add(7); // 10oz
        someBirdWeights.add(8);
        someBirdWeights.add(7);
        someDogYears.add(1);
        someDogYears.add(2);
        someDogYears.add(5);
        somePetOfMonth.add("Charles");
        nonPetOfMonth.add("Carmen");
        emptyPetOfMonth.add("");
        bestPetOfMonth.add("Mark");
        someCoords.add(new Coord("Walter", 2, 6));
        someCoords.add(new Coord("Mob", 4, 3));
        zeroCoords.add(new Coord("Bob", 0, 0) );
        noNameCoords.add(new Coord("", 4, 7));







    }

    @Test
    public void testBirdWeightsNonEmpty(){
        pr = new PetRescue(someBirdWeights, new LinkedList<Integer>(), "", new LinkedList<Coord>());
        assertEquals("8 should be the biggest bird out of 3 birds", 8, pr.biggestBird()); // label text (optional), expected value, actual/check value
    }

    @Test
    public void testBirdWeightEmpty(){
        pr = new PetRescue(emptyBirdWeights, new LinkedList<Integer>(), "", new LinkedList<Coord>());
        assertEquals(0, pr.biggestBird());
    }
    @Test
    public void testDogYearsNonEmpty(){
        pr = new PetRescue(new LinkedList<Integer>(), someDogYears, "", new LinkedList<Coord>());
        LinkedList<Integer> someHumanYears = new LinkedList<Integer>();
        someHumanYears.add(7);
        someHumanYears.add(14);
        someHumanYears.add(35);
        assertEquals(someHumanYears, pr.inHumanYears());

    }
    @Test
    public void testDogYearsEmpty(){
        pr = new PetRescue(new LinkedList<Integer>(), emptyDogYears, "", new LinkedList<Coord>());
        LinkedList<Integer> someHumanYears = new LinkedList<Integer>();
        assertEquals(someHumanYears, pr.inHumanYears());
    }
    @Test
    public void testBestowHonorTitleAndCredential(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Mark", new LinkedList<Coord>());
        pr.bestowHonor("Capt.", "MD");
        assertEquals("Capt. Mark, MD", pr.petOfTheMonth);
    }
    @Test
    public void testBestowHonorMultipleTitleAndCredential(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Carmen", new LinkedList<Coord>());
        pr.bestowHonor("", "MD PhD");
        assertEquals("Carmen, MD PhD", pr.petOfTheMonth);
    }
    @Test
    public void testBestowHonorNonEmpty(){
    pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Charles", new LinkedList<Coord>());
    pr.bestowHonor("Capt.", "");
    assertEquals("Capt. Charles", pr.petOfTheMonth);
    }

    @Test
    public void testBestowHonorJustTitle(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.bestowHonor("Capt.", "");
        assertEquals("Capt. ", pr.petOfTheMonth);
    }
    @Test
    public void testBestowHonorNoTitleJustCredential(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "Carmen", new LinkedList<Coord>());
        pr.bestowHonor("", "MD");
        assertEquals("Carmen, MD", pr.petOfTheMonth);
    }
    @Test
    public void testBestowHonorJustCredential(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.bestowHonor("", "MD");
        assertEquals(", MD", pr.petOfTheMonth);
    }

    @Test
    public void testBestowHonorAllEmpty(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.bestowHonor("", "");
        assertEquals("", pr.petOfTheMonth);
    }
    @Test
    public void testBestowJustTitleAndCredential(){
        pr = new PetRescue(new LinkedList<Integer>(), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.bestowHonor("Capt.", "MD");
        pr.bestowHonor("Capt.", "MD");
        assertEquals("Capt. Capt. , MD MD", pr.petOfTheMonth);
    }
    @Test
    public void testFeedChinchillas(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        String Chinchilla = pr.feedChinchillas(5, 4);
        assertEquals("Chinchilla: 5 pellets, 4 hay", Chinchilla);

    }
    @Test
    public void testZeroFeedChinchillas(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        String Chinchilla = pr.feedChinchillas(0, 0 );
        assertEquals("Chinchilla: 0 pellets, 0 hay", Chinchilla);

    }
   @Test
    public void testPelletNegativeFeedChinchillas(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.feedChinchillas(5, 4);
        String negPelletsChinchilla = pr.feedChinchillas(-6, -1);
    assertEquals("Chinchilla: unknown pellets, 3 hay", negPelletsChinchilla);
    }
    @Test
    public void testBothNegativeFeedChinchillas(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.feedChinchillas(5, 4);
        String negBothChinchilla = pr.feedChinchillas(-6, -5);
        assertEquals("Chinchilla: unknown pellets, unknown hay", negBothChinchilla);
    }
    @Test
    public void testHayNegativeFeedChinchillas(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", new LinkedList<Coord>());
        pr.feedChinchillas(5, 4);
        String negHayChinchilla =  pr.feedChinchillas(4, -5);
        assertEquals("Chinchilla: 9 pellets, unknown hay", negHayChinchilla);
    }
    @Test
    public void testClosestToZeroCoords(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", zeroCoords);
        assertEquals("Bob", pr.closestTo(3, 0));

    }
    @Test
    public void testClosestToSomeCoords(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", someCoords);
        assertEquals("Mob", pr.closestTo(3, 2));

    }
    @Test
    public void testClosestToEmptyCoords(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", emptyCoords);
        assertEquals("Conspiciously Catless", pr.closestTo(3, 2));

    }
    @Test
    public void testDistanceZero(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", someCoords);
        assertEquals(0, pr.distance(0, 0, 0, 0), 0.1);
    }
    @Test
    public void testDistance(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", someCoords);
        assertEquals(2.8, pr.distance(4, 5, 6, 7), 0.1);
    }
    @Test
    public void testDistanceNeg(){
        pr = new PetRescue((new LinkedList<Integer>()), new LinkedList<Integer>(), "", someCoords);
        assertEquals(2.23, pr.distance(-4, 5, -5, 7), 0.1);
    }
}

