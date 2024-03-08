import java.util.*;

import static java.util.Collections.sort;

public class CoolerGreenHouse implements ParsedDataStrategy{
    private List<Data> storedData = new LinkedList<>();

    @Override
    public void add(List<Data> newData) {
        this.storedData.addAll(newData);
        Collections.sort(storedData, Comparator.comparingDouble(Data::getDate));
    }
    public List<Data> getData() {
        return this.storedData;
    }

    @Override
    public TempHumidReading middleReading(){
        SuperTempHumidReading STHR = new SuperTempHumidReading();
        ArrayList<Double> Temps = new ArrayList();
        ArrayList<Double> Humids = new ArrayList();
        for(Data o : storedData){
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
        for(Data o : storedData){
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
        otherStrategy.add(this.storedData);
        this.storedData.clear();
    }


}
