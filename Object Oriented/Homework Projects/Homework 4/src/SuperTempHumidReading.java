public class SuperTempHumidReading extends TempHumidReading{



    public SuperTempHumidReading(double temperature, double humidity){
        super(temperature, humidity);
    }

    public SuperTempHumidReading(){
        super(-999, -999);
    }

    public SuperTempHumidReading(TempHumidReading thr){
        super(thr.getTHRTemp(), thr.getTHRHumid());
    }


    public boolean equals(Object o){
        if (o instanceof TempHumidReading){
            return(Math.abs(this.getTHRTemp() - ((TempHumidReading) o).getTHRTemp()) < .0001) && (Math.abs(this.getTHRHumid() - ((TempHumidReading) o).getTHRHumid()) < .0001);
        }
        else return false;
    }

    public String toString(){
        String s = "";
        if (this.getTHRTemp() == -999){
            s += "{Err;";
        }
        if(! (this.getTHRTemp() == -999)){
            s += String.format("{%,.1fF;", this.getTHRTemp());
        }
        if (this.getTHRHumid() == -999){
            s += "Err}";

        }
        if (!(this.getTHRHumid() == -999)){
            s+= String.format("%,.1f%%}", this.getTHRHumid());
        }
        return s;
    }
}

