import java.util.GregorianCalendar;
import java.util.List;

public class GreenHouseProduce extends AbsGreenHouse implements Sensible{
    public GreenHouseProduce(GregorianCalendar clock, ParsedDataStrategy inPDS){
        super(clock, inPDS);
    }
    @Override
    public void pollSensorData(List<Double> values) {
        this.getSensorData().addAll(values);
        process();
    }
    public List<Data> getData(){
        return this.parsedDataStrategy.getData();
    }

    @Override
    public TempHumidReading middleReading() {
        return parsedDataStrategy.middleReading();
    }

    @Override
    public TempHumidReading middleReading(double onDate) {
        return parsedDataStrategy.middleReading(onDate);
    }

    @Override
    public double percentError() {
        return 0;
    }
}

