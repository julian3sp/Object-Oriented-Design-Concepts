import java.util.LinkedList;

public abstract class AbsShapes {


    public abstract LinkedList<? extends Perimeterable> getPerimeterables();

    public double smallestPerimeter(){
        double smallPerimeter = Double.MAX_VALUE;
        for(Perimeterable p : this.getPerimeterables()){
            if(p.perimeter() < smallPerimeter){
                smallPerimeter = p.perimeter();
            }
        }
        return smallPerimeter;
    }
}
