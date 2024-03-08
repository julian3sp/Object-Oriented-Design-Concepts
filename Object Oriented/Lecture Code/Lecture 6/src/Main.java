

import java.util.LinkedList;

public class Main {
    /*
     *   AGENDA:
     *   1. go over a quirk of abstract classes/methods that you can use on the homework
     *   2. Overwrite equals() and toString()
     *   3. Overload constructors to provide a copy constructor
     */
    public static void main(String[] args){
        // Circle and Rectangle are like our animals in HW2
        Circle c1 = new Circle(1);
        Circle c2 = new Circle(2);

        Rectangle r23 = new Rectangle(2,3);
        Rectangle r44 = new Rectangle(4,4);
        Rectangle r33 = new Rectangle(3,3);

        // NOT ALLOWED - Subtype mismatch - Java is sad
        //LinkedList<Perimeterable> perimeterables = new LinkedList<Circle>();

        // ALLOWED - Java is happy for some reason
        //LinkedList<? extends Perimeterable> perimeterables = new LinkedList<Circle>();

        LinkedList<Circle> circleList = new LinkedList<>();
        circleList.add(c1);
        circleList.add(c2);

        LinkedList<Rectangle> rectangleList = new LinkedList<>();
        rectangleList.add(r23);
        rectangleList.add(r44);
        rectangleList.add(r33);

        // Circles and Rectangles are like our Zones in HW2
        Circles circles = new Circles(circleList);
        Rectangles rectangles = new Rectangles(rectangleList);

        System.out.println(circles.smallestRadius());         // <- circle specific function
        System.out.println(rectangles.biggestSquareSide());   // <- rectangle specific function

        System.out.println(circles.smallestPerimeter());      // <- generic for any shape that implements Perimeterable
        System.out.println(rectangles.smallestPerimeter());
    }

    /*public class random {
        double dum(){
            double result = 10 / 4;
            return result;
        }

    }
*/
    double result = 10 / 4;
}
