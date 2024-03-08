//package edu.wpi.ahrens.Lecture11;

public class Toy implements Comparable<Toy>{
    /** the name of this toy */
    private String name;
    /** 0 - common ~ 10 - ultra rare SSS+ */
    private int rarity;

    public Toy(String name, int rarity){
        this.name = name;
        if(rarity < 0 || rarity > 10){
            System.err.println("Bad rarity");
            this.rarity = 0;
        }
        else {
            this.rarity = rarity;
        }
    }

    public String getName(){
        return this.name;
    }

    public int getRarity(){
        return this.rarity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRarity(int rarity){
        if(rarity < 0 || rarity > 10){
            System.err.println("Bad rarity");
            this.rarity = 0;
        }
        else {
            this.rarity = rarity;
        }
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
