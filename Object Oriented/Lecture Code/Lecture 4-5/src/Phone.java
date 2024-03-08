public class Phone { //super class
    public String phoneNum;
    public Phone(String phoneNum){
        this.phoneNum = phoneNum;
    }
    public String whatsMyPhoneNumber(){
        return this.phoneNum;
    }

    /**
     * If the phone number is in ########## convert it to "(###) ###-####"
     * otherwise, go the otherway
     */
    public void flipFormat(){
        //if it's in format 1
        if(this.phoneNum.startsWith("(")){
            String newPhoneNum = this.phoneNum.substring(1,4); // first 3
            newPhoneNum += this.phoneNum.substring(6,9);
            newPhoneNum += this.phoneNum.substring(10);
            this.phoneNum = newPhoneNum;
        }
        else{
            String newPhoneNum = "(" + this.phoneNum.substring(0,3) + ") " +
                    this.phoneNum.substring(3,6) + "-" +
                    this.phoneNum.substring(6);
            this.phoneNum = newPhoneNum;
            
        }
          // convert to format 2
        //else (assume in format 1)
          // convert to format 1
    }
}
