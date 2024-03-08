import java.util.LinkedList;

public class Circles extends AbsShapes{

    public LinkedList<Circle> circles;

    public Circles(LinkedList<Circle> circles){
        this.circles = circles;
    }

    public int smallestRadius(){
        int smallestSoFar = Integer.MAX_VALUE;
        for(Circle c : this.circles){
            if(c.radius < smallestSoFar){
                smallestSoFar = c.radius;
            }
        }
        return smallestSoFar;
    }

    @Override
    public LinkedList<? extends Perimeterable> getPerimeterables() {
        return this.circles;
    }



}
