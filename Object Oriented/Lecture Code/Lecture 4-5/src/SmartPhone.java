public class SmartPhone extends CellPhone{
    public int hdSizeGB;

    public SmartPhone(String phoneNum, String carrier, int hdSizeGB) {
        super(phoneNum, carrier);
        this.hdSizeGB = hdSizeGB;
    }
}
