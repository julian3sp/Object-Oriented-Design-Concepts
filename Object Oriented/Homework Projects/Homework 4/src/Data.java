import java.util.ArrayList;
import java.util.List;

public class Data {
    private Double Dates;
    private List<Double> Temps;
    private List<Double> Humids;


    public Data(Double Dates, List<Double> Temps, List<Double> Humids){
        this.Dates = Dates;
        this.Temps = new ArrayList<>(Temps);
        this.Humids = new ArrayList<>(Humids);
    }
    public List<Double> getTemps(){
    return this.Temps;
    }
    public List<Double> getHumids(){
    return this.Humids;
    }
    public double getDate(){
    return this.Dates;
    }

}

