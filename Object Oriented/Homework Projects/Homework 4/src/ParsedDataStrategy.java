import java.util.List;

public interface ParsedDataStrategy{
    public List<Data> getData();
    public void add(List<Data> newData);
    public TempHumidReading middleReading();
    public TempHumidReading middleReading(double onDate);
    public void switchStrategy(ParsedDataStrategy otherStrategy);
}
