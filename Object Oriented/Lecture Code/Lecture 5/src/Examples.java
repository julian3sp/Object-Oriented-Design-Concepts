import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {
    public Examples(){

    }

//    @Test
//    public void testflip(){
//        SmartPhone sp = new SmartPhone("(888) 111-9876","T-Mobile",512);
//        sp.flipFormat();
//        assertEquals("8881119876", sp.phoneNum);
//    }
//
//    @Test
//    public void testflip2(){
//        SmartPhone sp = new SmartPhone("8881119876","T-Mobile",512);
//        sp.flipFormat();
//        assertEquals("(888) 111-9876", sp.phoneNum);
//    }

    @Test
    public void testinfoAndroid(){
        AndroidPhone sp = new AndroidPhone("8881119876","T-Mobile",
                                            512,14.0,"Samsung", "Galaxy S23+");
        assertEquals("Num: 8881119876, carrier: T-Mobile, storage: 512 GB, version: 14.0 Samsung/Galaxy S23+",
                     sp.info());
    }
    @Test
    public void testinfoiPhone(){
        Infoable sp = new IPhone("8881119876","T-Mobile",
                512,"12+");
        assertEquals("Num: 8881119876, carrier: T-Mobile, storage: 512 GB, version: 12+ Apple/iPhone",
                sp.info());
    }
}
