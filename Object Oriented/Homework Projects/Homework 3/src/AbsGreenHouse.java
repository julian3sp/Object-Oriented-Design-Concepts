import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


//contains helper methods for detecting, comparing, and converting a date / datetime as a double
  //      a date is YYYYMMDD.0 format
    //    a datetime is YYYYMMDDhhmmss.0 format
/**
 * An abstract superclass to provide template methods for performance specific subclasses.
 */
public abstract class AbsGreenHouse implements Sensible{


    public List<Double> sensorData = new LinkedList<>();
    public List<Data> newData = new LinkedList<>();

    public void addSensors(List<Double> values){
this.sensorData.addAll(values);
    }

    public void parse() {
        //ArrayList<Data> newData = new ArrayList<>();
        Double Date = 0.0;
        boolean ahhh = true;
        List<Double> temps = new ArrayList<>();
        List<Double> humids = new ArrayList<>();
        for (Double d : sensorData) {
            if(isDateTime(d)){
                if (!temps.isEmpty()) {
                    newData.add(new Data(Date, temps, humids));
                    temps.clear();
                    humids.clear();
                }
                Date = d;
                ahhh = true;
            }
            else {
                if(ahhh){
                    temps.add(d);
                    ahhh = false;
                }
                else {
                    humids.add(d);
                    ahhh = true;
                }
            }
        }
        if (!temps.isEmpty()) {
            newData.add(new Data(Date, temps, humids));
        }
        sensorData.clear();
    }

    public void clean(){
        for(Data o : newData){
            while(o.Temps.contains(-999.0)){
                o.Temps.remove(-999.0);
            }
            while(o.Humids.contains(-999.0)){
                    o.Humids.remove(-999.0);
                }
        }
    }

    public void process(){
        parse();
        clean();
    }

    public TempHumidReading middleReading(){
        SuperTempHumidReading STHR = new SuperTempHumidReading();
        ArrayList<Double> Temps = new ArrayList();
        ArrayList<Double> Humids = new ArrayList();
        for(Data o : newData){
            Temps.addAll(o.Temps);
            Humids.addAll(o.Humids);
        }
        Temps.sort(Double::compareTo);
        Humids.sort(Double::compareTo);
        if (!Temps.isEmpty()) { STHR.temperature = Temps.get(Temps.size()/2); }
        if (!Humids.isEmpty()) { STHR.humidity = Humids.get(Humids.size()/2); }
        return STHR;
    }
    public TempHumidReading middleReading(double onDate){
        SuperTempHumidReading STHR = new SuperTempHumidReading();
        ArrayList<Double> Temps = new ArrayList();
        ArrayList<Double> Humids = new ArrayList();
        for(Data o : newData){
            if(toDate(o.Dates) == onDate){
                Temps.addAll(o.Temps);
                Humids.addAll(o.Humids);
            }
        }
        Temps.sort(Double::compareTo);
        Humids.sort(Double::compareTo);
        if (!Temps.isEmpty()) { STHR.temperature = Temps.get(Temps.size()/2); }
        if (!Humids.isEmpty()) { STHR.humidity = Humids.get(Humids.size()/2); }
        return STHR;
    }

    public void minimizeDate(){

    }


    // GIVEN CODE
    /**
     * Assume a sensor value is a date if it is greater jan 01, 1970
     * @param sensorDatum the datum which may be a date, datetime, temperature, or humidity
     * @return true if it is a formatted date number
     */
  public boolean isDate(double sensorDatum){
      return sensorDatum > 19700101.0;
  }

    /**
     * Assume a sensor value is a date if it is greater jan 01, 1970 00:00:00 represented as a double
     * @param sensorDatum the datum which may be a date, datetime, temperature, or humidity
     * @return true if it is a formatted date number
     */
  public boolean isDateTime(double sensorDatum){
      return sensorDatum > 19700101000000.0;
  }

    /**
     * Converts the double date time format to just the date part by dividing and rounding
     * @param dateTime YYYYMMDDhhmmss.0
     * @return YYYYMMDD.0
     */
  public double toDate(double dateTime){
      return Math.floor(dateTime / 1000000.0); // convert YYYYMMDDhhmmss -> YYYYMMDD
  }

    /**
     * compares two YYYYMMDD.0 for equality
     * @param date1 one YYYYMMDD.0
     * @param date2 another YYYYMMDD.0
     * @return true if they are within some error tolerance (0.001) of each other
     */
  public boolean sameDate(double date1, double date2){
      return Math.abs(date1 - date2) < 0.001;
  }
 




}
