public class AndroidPhone extends SmartPhone{
    double version;
    String make;
    String model;
    public AndroidPhone(String phoneNum, String carrier,
                        int hdSizeGB, double version,
                        String make, String model) {
        super(phoneNum, carrier, hdSizeGB);
        this.version = version;
        this.make = make;
        this.model = model;
    }

    @Override
    public String version() {
        return String.valueOf(this.version);
    }

    @Override
    public String make() {
        return this.make;
    }

    @Override
    public String model() {
        return this.model;
    }

    /**
     * provides the info string for the smartphone
     *
     * @return "Num: ##########, carrier: WHO, storage: ## GB, make/model/version"
     */

}
