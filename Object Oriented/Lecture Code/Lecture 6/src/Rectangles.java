

import java.util.LinkedList;

public class Rectangles extends AbsShapes{

    public LinkedList<Rectangle> rects;

    public Rectangles(LinkedList<Rectangle> rects){
        this.rects = rects;
    }

    public int biggestSquareSide(){
        int bigSquareside = -1;
        for(Rectangle r : this.rects){
            if(r.width == r.height && r.width > bigSquareside){
                bigSquareside = r.width;
            }
        }
        return bigSquareside;
    }

 /*   public double biggestPerimeter(){
        double perimeter = 0.0;
        for(Perimeterable r : this.rects){
            if(r.perimeter() > perimeter){
                perimeter = r.perimeter();
            }
        }
        return perimeter;
    }
*/
    @Override
    public LinkedList<? extends Perimeterable> getPerimeterables() {
        return this.rects;
    }
}
