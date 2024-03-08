public class SuperTempHumidReading extends TempHumidReading{


        
   public SuperTempHumidReading(double temperature, double humidity){
   super(temperature, humidity);
   }

   public SuperTempHumidReading(){
       super(-999, -999);
   }

   public SuperTempHumidReading(TempHumidReading thr){
       super(thr.temperature, thr.humidity);
   }


   public boolean equals(Object o){
       if (o instanceof TempHumidReading){
           return(Math.abs(this.temperature - ((TempHumidReading) o).temperature) < .0001) && (Math.abs(this.humidity - ((TempHumidReading) o).humidity) < .0001);
       }
       else return false;
   }

   public String toString(){
       String s = "";
       if (this.temperature == -999){
           s += "{Err;";
       }
       if(! (this.temperature == -999)){
           s += String.format("{%,.1fF;", this.temperature);
       }
       if (this.humidity == -999){
          s += "Err}";

       }
       if (!(this.humidity == -999)){
           s+= String.format("%,.1f%%}", this.humidity);
       }
       return s;
   }
}
