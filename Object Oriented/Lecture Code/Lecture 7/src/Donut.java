public class Donut extends Circle{
    public int innerRadius;
    public Donut(int radius, int innerRadius){
     super(radius);
     this.innerRadius = innerRadius;

    }

    @Override
    public String toString(){
        return super.toString() + " inner radius: " + this.innerRadius;
    }
}
