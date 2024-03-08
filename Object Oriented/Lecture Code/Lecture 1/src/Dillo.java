
/**
 * A Dillo Data Transfer Object (DTO) (e.g.A methodless Data Class, a struct, a record, etc.)
 */
public class Dillo {


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

}
