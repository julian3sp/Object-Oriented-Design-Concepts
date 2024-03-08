public class Tiger implements Cageable{
public String name;
public int length;
public boolean isDead;

public Tiger(String name, int length, boolean isDead){
    this.name = name;
    this.length = length;
    this.isDead = isDead;
}

    @Override
    public boolean fitsInCage(int sideLength) {
        return true;
    }
}
