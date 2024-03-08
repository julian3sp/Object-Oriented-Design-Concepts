import java.util.LinkedList;

public class CircRects extends AbsShapes{
    public LinkedList<Circle> circs = new LinkedList<>();
    public LinkedList<Rectangle> rects = new LinkedList<>();


    @Override
    public LinkedList<? extends Perimeterable> getPerimeterables() {
        LinkedList<Perimeterable> combined = new LinkedList<>();
        combined.addAll(circs);
        combined.addAll(rects);
        return combined;

    }
}
