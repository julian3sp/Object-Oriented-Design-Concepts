

public class Rectangle implements Perimeterable{
    public int height;
    public int width;

    public Rectangle(int height, int width){
        this.height = height;
        this.width = width;
    }

    @Override
    public double perimeter() {
        return (2 * this.height) + (2 * this.width);
    }

}
