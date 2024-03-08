import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Examples {
    LinkedList<Bird> birds = new LinkedList<Bird>();
    BirdZone birdZone = new BirdZone(birds);
    LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
    ChinchillaZone chinchillaZone = new ChinchillaZone(chinchillas);
    LinkedList<Cat> cats = new LinkedList<Cat>();
    CatZone catZone = new CatZone(cats);



    int yummy;

    public Examples() {
        birds.add(new Bird("Walt", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Mark", 3, 8, new Coord2D(4, 2), true));


        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));


        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));

    }

    /** ANIMAL TESTS */

    /**
     * getName() function
     */

    @Test
    public void testBirdName() {
        Bird b = new Bird("Blue", 4, 12, new Coord2D(2, 2), false);
        assertEquals("Blue", b.getName());
    }

    @Test
    public void animalGetName() {
        Bird b = new Bird("Blue", 4, 3, new Coord2D(0, 0), true);
        Cat c = new Cat("Aria", 4, 20, new Coord2D(0, 0), true);
        Chinchilla ch = new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4);
        assertEquals("Blue", b.getName());
        assertEquals("Aria", c.getName());
        assertEquals("Dusty", ch.getName());
    }

    /**
     * getWeightInOz() function
     */

    @Test
    public void testBirdWeightInOz() {
        Bird b = new Bird("Blue", 4, 12, new Coord2D(2, 2), false);
        assertEquals(12, b.getWeightInOz());
    }

    @Test
    public void testCatWeightInOz() {
        Cat c = new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true);
        assertEquals(16, c.getWeightInOz());
    }

    @Test
    public void testChinchillaWeightInOz() {
        Chinchilla ch = new Chinchilla("Dusty", 4, 24, new Coord2D(0, 0), 4);
        assertEquals(28, ch.getWeightInOz());
    }

    @Test
    public void testChinchillaWeightInOzNoFur() {
        Chinchilla ch = new Chinchilla("Dusty", 4, 24, new Coord2D(0, 0), 0);
        assertEquals(24, ch.getWeightInOz());
    }

    /**
     * getAge() function
     */
    @Test
    public void testBirdAge() {
        Bird b = new Bird("Blue", 4, 12, new Coord2D(2, 2), false);
        assertEquals(4, b.getAge());
    }

    @Test
    public void testCatAge() {
        Cat c = new Cat("Fat Cat", 10, 16, new Coord2D(2, 2), true);
        assertEquals(10, c.getAge());
    }

    @Test
    public void testChinchillaAge() {
        Chinchilla ch = new Chinchilla("Dusty", 5, 24, new Coord2D(0, 0), 0);
        assertEquals(5, ch.getAge());
    }

    /**
     * eats() function
     */

    @Test
    public void testBirdEats() {
        Bird b = new Bird("Blue", 4, 12, new Coord2D(2, 2), false);
        assertEquals(1, b.eats("seeds"));
    }

    @Test
    public void testBirdNoEats() {
        Bird b = new Bird("Blue", 4, 12, new Coord2D(2, 2), false);
        assertEquals(0, b.eats("cans"));
    }

    @Test
    public void testCatEatsYesPet() {
        Cat c = new Cat("Aria", 4, 12, new Coord2D(2, 2), true);
        assertEquals(2, c.eats("cans"));
    }

    @Test
    public void testCatEatsNoPet() {
        Cat c = new Cat("Ariel", 4, 12, new Coord2D(2, 2), false);
        assertEquals(1, c.eats("cans"));
    }

    @Test
    public void testCatEatsTreatsBaby() {
        Cat c = new Cat("Kitten", 4, 6, new Coord2D(2, 2), true);
        assertEquals(1, c.eats("treats"));
    }

    @Test
    public void testCatEatsTreatsAdult() {
        Cat c = new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true);
        assertEquals(3, c.eats("treats"));
    }

    @Test
    public void testChinchillaPellets() {
        Chinchilla c = new Chinchilla("Bob", 4, 16, new Coord2D(2, 2), 3);
        assertEquals(3, c.eats("pellets"));
    }

    @Test
    public void testChinchillaHay() {
        Chinchilla c = new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3);
        assertEquals(1, c.eats("hay"));
    }

    @Test
    public void testChinchillaFoodNone() {
        Chinchilla c = new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3);
        assertEquals(0, c.eats("chocolate"));
    }

    /** ZONE Tests */

    /**
     * petsInZone() function
     */
    @Test
    public void birdZoneBirdsInZone() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 3, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(2, bz.petsInZone());
    }
    @Test
    public void catZoneCatsInZone() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals(3, cz.petsInZone());
    }
    @Test
    public void chinchillaZoneChinchillasInZone() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(3, chz.petsInZone());
    }

    /**
     * heaviestPet() function
     */
    @Test
    public void birdZoneTestHeaviest1Bird() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Blue", bz.heaviestPet().getName());
    }
    @Test
    public void birdZoneTestHeaviestSomeBirds() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 3, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Ray", bz.heaviestPet().getName());
    }
    @Test
    public void catZoneTestHeaviest1Cat() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals("Aria", cz.heaviestPet().getName());
    }
    @Test
    public void catZoneTestHeaviestSomeCats() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals("Fat Cat", cz.heaviestPet().getName());
    }
    @Test
    public void ChinchillaZoneTestHeaviest1Chinch() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Dusty", chz.heaviestPet().getName());
    }
    @Test
    public void ChinchillaZoneTestHeaviestSomeChinch() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals("Dusty", chz.heaviestPet().getName());
    }

    /**
     * inHumanYears() function
     */
    @Test
    public void birdZoneHumanYearsTest() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 3, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(27, bz.inHumanYears("Ray"));
    }
    @Test
    public void birdZoneHumanYearsTestNeg() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", -2, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(-18, bz.inHumanYears("Ray"));
    }
    @Test
    public void birdZoneHumanYearsTestNoName() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 2, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(-1, bz.inHumanYears("Mark"), .1);
    }
    @Test
    public void catZoneHumanYearsTest() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals(24, cz.inHumanYears("Fat Cat"));
    }
    @Test
    public void ChinchillaZoneHumanYearsTest() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(40, chz.inHumanYears("Mark"));
    }
    /**
     * restockPetFood function
     */
    @Test
    public void birdZoneRestockFoodTest() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 3, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(bz, bz.restockPetFood("seeds", 5));
    }
    @Test
    public void catZoneRestockFoodTest() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        cz.restockPetFood("cans", 2);
        cz.restockPetFood("cans", -5);
        assertEquals(cz.getPantryLabel(), "Cat: -3 cans, 0 treats");
    }
    @Test
    public void catZoneRestockFoodTestBug() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals(cz, cz.restockPetFood("treats", -2));
        assertEquals(cz, cz.restockPetFood("cans", -3));
    }

    @Test
    public void ChinchillaZoneRestockFoodTest() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(chz, chz.restockPetFood("pellets", 4));
        assertEquals(chz, chz.restockPetFood("hay", 4));
    }
    /**
     * feedZone() function
     */
    @Test
    public void birdZoneFeedZone() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 3, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        bz.restockPetFood("seeds", 5);
        assertEquals(bz, bz.feedZone());
    }
    @Test
    public void catZoneFeedZone() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals(cz, cz.feedZone());
        assertEquals(cz, cz.feedZone());
    }
    @Test
    public void ChinchillaZoneFeedZone() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(chz, chz.feedZone());
    }
    @Test
    public void ChinchillaZoneFeedZoneBug() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        chz.restockPetFood("pellets", 2);
        chz.restockPetFood("hay", 2);
         chz.feedZone();
         assertEquals("Chinchilla: 0 pellets, 0 hay", chz.getPantryLabel());
    }
    /**
     * getPet function
     */
    @Test
    public void birdZoneGetPetTest() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 3, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        assertEquals(null, bz.getPet("Mark"));
    }
    @Test
    public void catZoneGetPetTest() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        System.out.println(cats.getFirst());
        assertEquals(cats.getFirst(), cz.getPet("Aria"));
    }
    @Test
    public void ChinchillaGetPetTest() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        assertEquals(null, chz.getPet("Mark"));
    }
    /**
     * getPantryLabel function
     */
    @Test
    public void birdZoneGetPantryLabel() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Ray", 3, 5, new Coord2D(2, 2), true));
        BirdZone bz = new BirdZone(birds);
        bz.restockPetFood("seeds", 5);
        bz.restockPetFood("pellets", 5);
        assertEquals("Bird: 5 seeds", bz.getPantryLabel());
    }
    @Test
    public void catZoneGetPantryLabel() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        cz.restockPetFood("cans", 3);
        cz.restockPetFood("treats", 2);
        assertEquals("Cat: 3 cans, 2 treats", cz.getPantryLabel());
    }
    @Test
    public void catZoneGetPantryLabelNeg() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(2, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 2), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(2, 2), true));
        CatZone cz = new CatZone(cats);
        cz.restockPetFood("cans", -3);
        cz.restockPetFood("treats", -2);
        assertEquals("Cat: -3 cans, -2 treats", cz.getPantryLabel());
    }
    @Test
    public void ChinchillaZoneGetPantryLabel() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        chinchillas.add(new Chinchilla("Dusty", 4, 20, new Coord2D(0, 0), 4));
        chinchillas.add(new Chinchilla("Bob", 5, 16, new Coord2D(2, 2), 3));
        chinchillas.add(new Chinchilla("Mark", 4, 12, new Coord2D(5, 2), 3));
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
        chz.restockPetFood("chips", 5);
        assertEquals("Chinchilla: 0 pellets, 0 hay", chz.getPantryLabel());
    }
    /**
     * closestPet function
     */

    @Test
    public void birdZoneTestClosestClipped() {
        LinkedList<Bird> birds = new LinkedList<Bird>();
        birds.add(new Bird("Blue", 1, 3, new Coord2D(2, 2), true));
        birds.add(new Bird("Red", 1, 3, new Coord2D(3, 2), false));
        birds.add(new Bird("Green", 1, 3, new Coord2D(4, 3), false));
        BirdZone bz = new BirdZone(birds);
        assertEquals("Green", bz.closestPet(4, 5));
    }
    @Test
    public void catZoneTestClosestClipped() {
        LinkedList<Cat> cats = new LinkedList<Cat>();
        cats.add(new Cat("Aria", 4, 12, new Coord2D(4, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 5), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(1, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals("Fat Cat", cz.closestPet(2,2));
    }
    @Test
    public void ChinchillaZoneClosestClippedNoPetsInZone() {
        LinkedList<Chinchilla> chinchillas = new LinkedList<Chinchilla>();
        ChinchillaZone chz = new ChinchillaZone(chinchillas);
      assertEquals("No Pets Found" , chz.closestPet(1, 2));
    }

    /** SuperPetRescue Tests */

    /**
     * totalPets function
     */

    @Test
    public void totalPetsTest() {
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(birdZone);
        zones.add(chinchillaZone);
        zones.add(catZone);
        SuperPetRescue spr = new SuperPetRescue(zones);
        assertEquals(8, spr.totalPets());

    }

    /**
     * getHeaviestPetsName() function
     */
    @Test
    public void heaviestPetTest() {
        LinkedList<Zoneable> zones = new LinkedList<Zoneable>();
        zones.add(birdZone);
        zones.add(chinchillaZone);
        zones.add(catZone);
        SuperPetRescue spr = new SuperPetRescue(zones);
        assertEquals("Dusty", spr.getHeaviestPetsName());

    }

    /** Distance functions */
    @Test
    public void testDistanceZero(){
        cats.add(new Cat("Aria", 4, 12, new Coord2D(4, 2), true));
        cats.add(new Cat("Kitten", 4, 6, new Coord2D(2, 5), true));
        cats.add(new Cat("Fat Cat", 4, 16, new Coord2D(1, 2), true));
        CatZone cz = new CatZone(cats);
        assertEquals(0, cz.distance(0, 0, 0, 0), 0.1);
        assertEquals(2.8, cz.distance(4, 5, 6, 7), 0.1);
        assertEquals(2.23, cz.distance(-4, 5, -5, 7), 0.1);
        assertEquals(2.23, cz.distance(4, 5, 5, 7, 4, 3), 0.1);
        // im not entirely sure why the distance function is not working with three variables
    }

}

