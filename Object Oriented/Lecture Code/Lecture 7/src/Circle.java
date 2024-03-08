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
        return super.toString() +
                " radius: " + this.radius;
    }
//override the signature exactly
    public boolean equals(Object o){
        //dynamic type checking
        if(! (o instanceof Circle)){
            return false;
        }

        Circle c = (Circle) o;
        return this.radius ==c.radius;
    }
}
