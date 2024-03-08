import java.util.LinkedList;
import java.util.List;

public class GreenHouseNursery extends AbsGreenHouse implements Sensible{


    public GreenHouseNursery(){
        sensorData = new LinkedList<>();
    }

    @Override
    public void pollSensorData(List<Double> values) {
        this.sensorData.addAll(values);
    }

    @Override
    public TempHumidReading middleReading() {
        this.process();
        return super.middleReading();
    }

    @Override
    public TempHumidReading middleReading(double onDate) {
        this.process();
        return super.middleReading(onDate);
    }
}
