public class IPhone extends SmartPhone{

    String version;
    public IPhone(String phoneNum, String carrier,
                  int hdSizeGB, String version) {
        super(phoneNum, carrier, hdSizeGB);
        this.version = version;
    }

    @Override
    public String version() {
        return this.version;
    }

    @Override
    public String make() {
        return "Apple";
    }

    @Override
    public String model() {
        return "iPhone";
    }


}
