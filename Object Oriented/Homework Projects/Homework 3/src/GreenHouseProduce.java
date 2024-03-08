import java.util.List;

public class GreenHouseProduce extends AbsGreenHouse implements Sensible{
    @Override
    public void pollSensorData(List<Double> values) {
        this.sensorData.addAll(values);
        process();

    }

    @Override
    public TempHumidReading middleReading() {
        return super.middleReading();
    }

    @Override
    public TempHumidReading middleReading(double onDate) {
        return super.middleReading(onDate);
    }
}
