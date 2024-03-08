import java.util.*;


//contains helper methods for detecting, comparing, and converting a date / datetime as a double
//      a date is YYYYMMDD.0 format
//    a datetime is YYYYMMDDhhmmss.0 format
/**
 * An abstract superclass to provide template methods for performance specific subclasses.
 */
public abstract class AbsGreenHouse implements Sensible, QualityControlable{
    private List<Double> sensorData = new LinkedList<>();
    private List<Data> newData = new LinkedList<>();
    private GregorianCalendar clock;
    protected ParsedDataStrategy parsedDataStrategy;

    public AbsGreenHouse(GregorianCalendar aClock, ParsedDataStrategy inPDS){
        this.clock = (GregorianCalendar) aClock.clone();
        this.parsedDataStrategy = inPDS;
    }
    public List<Double> getSensorData(){
        return this.sensorData;
    }
    public void addSensors(List<Double> values){
        this.sensorData.addAll(values);
    }

    public double clockAsDatetime(){
        double year = clock.get(Calendar.YEAR);
        double month = clock.get(Calendar.MONTH) + 1;
        double day = clock.get(Calendar.DAY_OF_MONTH);
        double hour = clock.get(Calendar.HOUR_OF_DAY);
        double minute = clock.get(Calendar.MINUTE);
        double second = clock.get(Calendar.SECOND);
        return second +
                (minute * 100.0) + //shifted 2 decimal places
                (hour * 100.0 * 100.0) + //shifted 4 decimal places
                (day * 100.0 * 100.0 * 100.0) + //shifted 6 decimal places
                (month * 100.0 * 100.0 * 100.0 * 100.0) + //shifted 8 decimal places
                (year * 100.0 * 100.0 * 100.0 * 100.0 * 100.0); //shifted 10 decimal places
    }
    public void setClockTo(double datetime) {
        String datetimeStr = String.format("%.0f", datetime);

        int year = Integer.parseInt(datetimeStr.substring(0, 4));
        // Subtract 1 from month because GregorianCalendar months are 0-based
        int month = Integer.parseInt(datetimeStr.substring(4, 6)) - 1;
        int day = Integer.parseInt(datetimeStr.substring(6, 8));
        int hour = Integer.parseInt(datetimeStr.substring(8, 10));
        int minute = Integer.parseInt(datetimeStr.substring(10, 12));
        int second = Integer.parseInt(datetimeStr.substring(12, 14));
        this.clock = new GregorianCalendar(year, month, day, hour, minute, second);
    }


    public List<Data> gregorianCleanse() {
        boolean foundDate = false;
        newData.removeIf(o -> o.getDate() < this.clockAsDatetime());
        for(Data o : newData){
            if(o.getDate() >= this.clockAsDatetime()){
              setClockTo(o.getDate());
            }
        }
        return newData;
    }
    public void parse() {
        Double Date = 0.0;
        boolean doubleDate = false;
        boolean isTemp = true;
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
                isTemp = true;
            }
            else {
                if(isTemp){
                    temps.add(d);
                    isTemp = false;
                }
                else {
                    humids.add(d);
                    isTemp = true;
                }
            }
        }
        if (!temps.isEmpty()) {
            newData.add(new Data(Date, temps, humids));
        }
        this.gregorianCleanse();
        sensorData.clear();
    }


    public void clean(){
        for(Data o : newData){
            while(o.getTemps().contains(-999.0)){
                o.getTemps().remove(-999.0);
            }
            while(o.getHumids().contains(-999.0)){
                o.getHumids().remove(-999.0);
            }
        }
    }

    public void process(){
        parse();
        clean();
        switchStrategy(parsedDataStrategy);
    }
    @Override
    public double percentError(){
        parse();
        List<Double> TempsHumidsDates = new LinkedList<>();
        List<Double> TempsHumids = new LinkedList<>();
        double errorCount = 0.0;
        for(Data o : newData){
            TempsHumidsDates.addAll(o.getTemps());
            TempsHumidsDates.addAll(o.getHumids());
            TempsHumidsDates.add(o.getDate());
            TempsHumids.addAll(o.getTemps());
            TempsHumids.addAll(o.getHumids());
        }
        for(Double d : TempsHumidsDates){
            if(d == -999.0){
                errorCount += 1;
            }
        }
        return (errorCount/TempsHumids.size())*100.0;
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


    /**
     * compares two YYYYMMDD.0 for equality
     * @param date1 one YYYYMMDD.0
     * @param date2 another YYYYMMDD.0
     * @return true if they are within some error tolerance (0.001) of each other
     */
    public boolean sameDate(double date1, double date2){
        return Math.abs(date1 - date2) < 0.001;
    }

    public void switchStrategy(ParsedDataStrategy strat){
        strat.add(this.newData);
        this.newData.clear();
        parsedDataStrategy=strat;
    }


}
