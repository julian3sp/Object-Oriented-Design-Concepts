

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

 /*   public double biggestPerimeter(){
        double perimeter = 0.0;
        for(Perimeterable r : this.circles){
            if(r.perimeter() > perimeter){
                perimeter = r.perimeter();
            }
        }
        return perimeter;
    }
*/
    @Override
    public LinkedList<? extends Perimeterable> getPerimeterables() {
        return this.circles;
    }

}
