

public class Toy implements Comparable<Toy>{
    /** the name of this toy */
    public String name;
    /** 0 - common ~ 10 - ultra rare SSS+ */
    public int rarity;

    public Toy(String name, int rarity){
        this.name = name;
        this.rarity = rarity;
    }

    @Override
    public boolean equals(Object o){
        if(! (o instanceof Toy)){
            return false;
        }
        Toy t = (Toy) o;
        return t.name.equals(this.name) && t.rarity == this.rarity;
    }

    @Override
    public String toString(){
        return String.format("%s[%d]",this.name, this.rarity);
    }

    @Override
    public int compareTo(Toy o) {
        return (new Integer(this.rarity)).compareTo(o.rarity);
    }


}
