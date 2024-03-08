

/**
 * The dillo class which can do everything a dillo can do
 */
public class Dillo implements Cageable{

    /** The name of the dillo */
    public String name;
    /** The length of the dillo in inches */
    public int length;
    /** the aliveness of the dillo */
    public boolean isDead;

    /**
     * The data constructor for the dillo
     * @param name the name of the dillo
     * @param length the length of the dillo
     * @param isDead the aliveness of the dillo
     */
    public Dillo(String name, int length, boolean isDead){
        this.name = name;
        this.length = length;
        this.isDead = isDead;
    }

    /**
     * Determines if the dillo fits in the cage when curled up in a ball
     * @param cageLength the side length given in inches
     * @return true if the radius of the dillo is less than the side length, false otherwise
     */
    public boolean fitsInCage(int cageLength){
        return (this.length / 2) < cageLength;
    }


}
