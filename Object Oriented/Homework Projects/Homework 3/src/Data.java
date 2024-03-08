import java.util.ArrayList;
import java.util.List;

public class Data {
public Double Dates;
public List<Double> Temps;
public List<Double> Humids;


    public Data(Double Dates, List<Double> Temps, List<Double> Humids){
        this.Dates = Dates;
        this.Temps = new ArrayList<>(Temps);
        this.Humids = new ArrayList<>(Humids);
        }

}
