import java.util.LinkedList;

public abstract class SmartPhone extends CellPhone implements Infoable, Callable{
    public int hdSizeGB;
    public LinkedList<String> missedCalls = new LinkedList<>();

    public SmartPhone(String phoneNum, String carrier, int hdSizeGB) {
        super(phoneNum, carrier);
        this.hdSizeGB = hdSizeGB;
    }

    @Override
    public String info() {
        return String.format("Num: %s, carrier: %s, storage: %d GB, version: %s %s/%s",
                this.phoneNum, this.carrier, this.hdSizeGB,this.version(), this.make(), this.model());
    }

    @Override
    public Callable receiveCall(String fromWho){
        this.missedCalls.add(fromWho);
        return this;
    }

    public abstract String version();
    public abstract String make();
    public abstract String model();


}
