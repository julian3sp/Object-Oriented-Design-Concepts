import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Examples {
    public Examples(){

    }

    @Test
    public void testflip(){
        SmartPhone sp = new SmartPhone("(888) 111-9876","T-Mobile",512);
        sp.flipFormat();
        assertEquals("8881119876", sp.phoneNum);
    }

    @Test
    public void testflip2(){
        SmartPhone sp = new SmartPhone("8881119876","T-Mobile",512);
        sp.flipFormat();
        assertEquals("(888) 111-9876", sp.phoneNum);
    }
}
