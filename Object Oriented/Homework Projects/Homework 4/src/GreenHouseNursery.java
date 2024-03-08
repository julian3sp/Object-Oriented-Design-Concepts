import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class GreenHouseNursery extends AbsGreenHouse implements Sensible{
    public GreenHouseNursery(GregorianCalendar clock, ParsedDataStrategy inPDS){
        super(clock, inPDS);
    }

    @Override
    public List<Data> getData(){
        return parsedDataStrategy.getData();
    }

    @Override
    public void pollSensorData(List<Double> values) {
        this.getSensorData().addAll(values);
    }

    @Override
    public TempHumidReading middleReading() {
        this.process();
        return parsedDataStrategy.middleReading();
    }

    @Override
    public TempHumidReading middleReading(double onDate) {
        this.process();
        return parsedDataStrategy.middleReading(onDate);
    }


}

