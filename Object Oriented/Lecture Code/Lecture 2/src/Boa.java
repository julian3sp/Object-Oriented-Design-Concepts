

public class Boa implements Cageable{
    public String name;
    public double length;

    public String favoriteFood;

    public String favoriteSong;

    public Boa(String name, double length, String favoriteFood, String favoriteSong){
        this.name = name;
        this.length = length;
        this.favoriteFood = favoriteFood;
        this.favoriteSong = favoriteSong;
    }


    @Override
    public boolean fitsInCage(int sideLength) {
        return this.length < sideLength;
    }
}
