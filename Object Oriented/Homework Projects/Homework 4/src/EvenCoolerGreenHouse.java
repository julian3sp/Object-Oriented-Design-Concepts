import java.util.*;

public class EvenCoolerGreenHouse implements ParsedDataStrategy{
    private List<Data> coolData = new ArrayList<>();


    @Override
    public void add(List<Data> newData) {
        this.coolData.addAll(newData);
        Collections.sort(coolData, Comparator.comparingDouble(Data::getDate));
    }
    public List<Data> getData(){
        return this.coolData;
    }


    @Override
    public TempHumidReading middleReading(){
        SuperTempHumidReading STHR = new SuperTempHumidReading();
        ArrayList<Double> Temps = new ArrayList();
        ArrayList<Double> Humids = new ArrayList();
        for(Data o : coolData){
            Temps.addAll(o.getTemps());
            Humids.addAll(o.getHumids());
        }
        Temps.sort(Double::compareTo);
        Humids.sort(Double::compareTo);
        if (!Temps.isEmpty()) { STHR.temperature = Temps.get(Temps.size()/2); }
        if (!Humids.isEmpty()) { STHR.humidity = Humids.get(Humids.size()/2); }
        return STHR;
    }

    @Override
    public TempHumidReading middleReading(double onDate){
        SuperTempHumidReading STHR = new SuperTempHumidReading();
        ArrayList<Double> Temps = new ArrayList();
        ArrayList<Double> Humids = new ArrayList();
        for(Data o : coolData){
            if(toDate(o.getDate()) == onDate){
                Temps.addAll(o.getTemps());
                Humids.addAll(o.getHumids());
            }
        }
        Temps.sort(Double::compareTo);
        Humids.sort(Double::compareTo);
        if (!Temps.isEmpty()) { STHR.temperature = (Temps.get(Temps.size()/2)); }
        if (!Humids.isEmpty()) { STHR.humidity = Humids.get(Humids.size()/2); }
        return STHR;
    }
    public double toDate(double dateTime){
        return Math.floor(dateTime / 1000000.0); // convert YYYYMMDDhhmmss -> YYYYMMDD
    }

    @Override
    public void switchStrategy(ParsedDataStrategy otherStrategy){
        otherStrategy.add(this.coolData);
        this.coolData.clear();
    }


}
