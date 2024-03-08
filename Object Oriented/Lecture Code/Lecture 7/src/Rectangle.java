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

    @Override
    public String toString(){
        return super.toString() +
                String.format(" w: %s h: %s",
                        this.width, this.height);
    }

    public boolean equals(Object o){
        //dynamic type checking
        if(! (o instanceof Rectangle)){
            return false;
        }

        Rectangle c = (Rectangle) o;
        return ((this.width == c.width && this.height == c.height)
                ||
                (this.height == c.width && this.width == c.height));
    }
}
