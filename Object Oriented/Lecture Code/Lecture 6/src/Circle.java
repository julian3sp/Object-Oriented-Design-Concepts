

public class Circle implements Perimeterable{

    public int radius;
    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * this.radius;
    }
    @Override
    public String toString(){
        return super.toString() + "radius: " + this.radius;
    }
}
