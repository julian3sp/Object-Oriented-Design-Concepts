import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Examples {
    LinkedList<Double> sameMonth = new LinkedList<>();
    LinkedList<Double> sameMonthTheSecond = new LinkedList<>();
    LinkedList<Double> sameMonthTheThird = new LinkedList<>();

    public Examples() {
        sameMonth.addAll(List.of(20231106010101.0, 45.5, 34.0, 46.6, 40.0, 20231130020202.0, 22.2, 20.0, 35.5, 30.0, -999.0, 31.0, 32.2, -999.0));
        sameMonthTheSecond.addAll(List.of(20231107230101.0, 46.5, 32.0, 40.6, 40.0, 20231122020202.0, 20.2, 20.9, 37.5, 32.0, 20231230200101.0, -999.0, -999.0, -999.0, -999.0));
        sameMonthTheThird.addAll(List.of(20231107230101.0, 46.5, 32.0, 40.6, 40.0, 20231122020202.0, 20.2, 20.9, 37.5, 32.0, 20231230200101.0, -999.0, -999.0, -999.0, -999.0));
    }


    /**
     * SuperTempReading
     */

    @Test
    public void TestSuperHumidityReadingEquals1() {
        assertEquals(new SuperTempHumidReading(), new SuperTempHumidReading());
    }

    @Test
    public void TestSuperHumidityReadingEquals2() {
        assertEquals(new SuperTempHumidReading(80.0, 33.3), new SuperTempHumidReading(80.0, 33.3));
    }

    @Test
    public void TestSuperHumidityReadingEqualsMethod() {
        SuperTempHumidReading sthr = new SuperTempHumidReading(55.5, 33.3);
        assertFalse(new SuperTempHumidReading(80.0, 34.3).equals(sthr));
    }

    @Test
    public void TestSuperHumidityReadingToString1() {
        assertEquals("{80.0F;33.3%}", new SuperTempHumidReading(80.0, 33.3).toString());
    }

    @Test
    public void TestSuperHumidityReadingToString2() {
        assertEquals("{Err;33.3%}", new SuperTempHumidReading(-999, 33.3).toString());
    }

    @Test
    public void TestSuperHumidityReadingToString3() {
        assertEquals("{Err;Err}", new SuperTempHumidReading(-999, -999).toString());
    }

    @Test
    public void TestSuperHumidityReadingCopyConstructor() {
        SuperTempHumidReading sthr = new SuperTempHumidReading(55.5, 33.3);
        assertEquals(sthr, new SuperTempHumidReading(sthr));
        assertNotSame(sthr, new SuperTempHumidReading(sthr));
    }


    /**
     * GreenHouseNursery
     */
    @Test
    public void testGreenHouseNurserySameMonth1() {
        Sensible ghn = new GreenHouseNursery();
        ghn.pollSensorData(sameMonth);
        //TEMP: 45.5, 46.6 --> 2 values --> 2/2 = 1 --> value at index 1
        //HUMIDITY: 45.5, 46.6 --> 2 values --> 2/2 = 1 --> value at index 1
        assertEquals(new SuperTempHumidReading(46.6, 40.0),
                ghn.middleReading(20231106.0));
    }

    @Test
    public void testGreenHouseNurserySameMonth2() {
        Sensible ghn = new GreenHouseNursery();
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(32.2, 30.0),
                ghn.middleReading(20231130.0));
    }

    @Test
    public void testGreenHouseNurserySameMonth3() {
        Sensible ghn = new GreenHouseNursery();
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(-999, -999),
                ghn.middleReading(-999.0));
    }

    @Test
    public void testGreenHouseNurserySameMonthTheSecond1() {
        Sensible ghn = new GreenHouseNursery();
        ghn.pollSensorData(sameMonthTheSecond);
        assertEquals(new SuperTempHumidReading(40.6, 32.0),
                ghn.middleReading());
    }

    @Test
    public void testGreenHouseProduceSameMonth1() {
        GreenHouseProduce ghn = new GreenHouseProduce();
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(46.6, 40.0),
                ghn.middleReading(20231106.0));
    }

    @Test
    public void testGreenHouseProduceSameMonth2() {
        GreenHouseProduce ghn = new GreenHouseProduce();
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(32.2, 30.0),
                ghn.middleReading(20231130.0));
    }
    @Test
    public void testGreenHouseProduceSameMonth3() {
        GreenHouseProduce ghn = new GreenHouseProduce();
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(-999.0, -999.0),
                ghn.middleReading(20231131.0));
    }

    @Test
    public void testGreenHouseProduceSameMonthTheSecond1() {
        GreenHouseProduce ghp = new GreenHouseProduce();
        ghp.pollSensorData(sameMonthTheSecond);
        assertEquals(new SuperTempHumidReading(40.6, 32.0), ghp.middleReading());
    }


    @Test
    public void testGreenHouseNurseryProducePollSensorTime() {
        GreenHouseProduce ghp = new GreenHouseProduce();
        GreenHouseNursery ghn = new GreenHouseNursery();
        long time1 = System.nanoTime();
            ghn.pollSensorData(sameMonth);
        long time2 = System.nanoTime();
            ghp.pollSensorData(sameMonth);
        long time3 = System.nanoTime();
        System.out.println(String.format("ghnPollDataTime : ghpPollDataTime :: %s : %s", time2 - time1, time3 - time2));
        assertTrue(time2 - time1 < time3 - time2); // assert that computation 1 is faster
    }
    @Test
    public void testNurseryProduceMiddleReadingTime() {
            GreenHouseProduce ghp = new GreenHouseProduce();
            GreenHouseNursery ghn = new GreenHouseNursery();
            ghp.pollSensorData(sameMonth);
            ghn.pollSensorData(sameMonth);
            long time1 = System.nanoTime();
                ghp.middleReading();
            long time2 = System.nanoTime();
                ghn.middleReading();
            long time3 = System.nanoTime();
            System.out.println(String.format("ghnMiddleReadingTime : ghpMiddleReadingTime :: %s : %s", time2 - time1, time3 - time2));
            assertTrue(time2 - time1 < time3 - time2); // assert that computation 1 is faster
        }
    @Test
    public void testToString(){
        SuperTempHumidReading sthr = new SuperTempHumidReading(55.5, 33.3);
        assertEquals("{55.5F;33.3%}", sthr.toString() );
    }

    }

