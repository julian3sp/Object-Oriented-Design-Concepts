import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

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
    public void testGreenHouseNursery1() {
        GregorianCalendar clock = new GregorianCalendar(2023, 9, 2, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        ghn.pollSensorData(sameMonth);
        //TEMP: 45.5, 46.6 --> 2 values --> 2/2 = 1 --> value at index 1
        //HUMIDITY: 45.5, 46.6 --> 2 values --> 2/2 = 1 --> value at index 1
        assertEquals(new SuperTempHumidReading(46.6, 40.0),
                ghn.middleReading(20231106.0));
    }

    @Test
    public void testGreenHouseNursery2() {
        GregorianCalendar clock = new GregorianCalendar(2023, 10, 10, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(32.2, 30.0),
                ghn.middleReading(20231130.0));
    }

    @Test
    public void testGreenHouseNursery3() {
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(),
                ghn.middleReading(-999.0));
    }

    @Test
    public void testGreenHouseNursery4() {
        GregorianCalendar clock = new GregorianCalendar(2023, 10, 9, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        ghn.pollSensorData(sameMonthTheSecond);
        assertEquals(new SuperTempHumidReading(37.5, 32.0),
                ghn.middleReading());
    }
    @Test
    public void testGreenHouseNursery5() {
        GregorianCalendar clock = new GregorianCalendar(2023, 10, 9, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        ghn.pollSensorData(sameMonthTheSecond);
        ghn.parse();
        System.out.println(ghn);
    }
/** GreenHouseProduce*/
    @Test
    public void testGreenHouseProduce1() {
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseProduce ghp = new GreenHouseProduce(clock, new CoolerGreenHouse());
        ghp.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(46.6, 40.0), ghp.middleReading(20231106.0));
    }

    @Test
    public void testGreenHouseProduce2() {
        GregorianCalendar clock = new GregorianCalendar(2023, 10, 7, 4, 35, 23);
        GreenHouseProduce ghp = new GreenHouseProduce(clock, new CoolerGreenHouse());
        ghp.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(32.2, 30.0),
                ghp.middleReading(20231130.0));
    }
    @Test
    public void testGreenHouseProduce3() {
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseProduce ghp = new GreenHouseProduce(clock, new CoolerGreenHouse());
        ghp.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(),
                ghp.middleReading(20231131.0));
    }

    @Test
    public void testGreenHouseProduce4() {
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseProduce ghp = new GreenHouseProduce(clock, new CoolerGreenHouse());
        ghp.pollSensorData(sameMonthTheSecond);
        assertEquals(new SuperTempHumidReading(40.6, 32.0),
                ghp.middleReading());
    }


    @Test
    public void TestRunBackTheClock(){
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        clock.add(Calendar.DAY_OF_YEAR, -2);
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(35.5, 31.0), ghn.middleReading());
    }
    @Test
    public void TestRunBackTheClock2(){
        GregorianCalendar clock = new GregorianCalendar(2023, 12, 2, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        clock.add(Calendar.MONTH, -3);
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(-999.0, -999.0), ghn.middleReading(20231106));
    }

    @Test
    public void TestRunBackTheClock3(){
        GregorianCalendar clock = new GregorianCalendar(2023, 10, 6,1, 1, 1);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        clock.add(Calendar.MONTH, 0);
        ghn.pollSensorData(sameMonth);
        assertEquals(new SuperTempHumidReading(46.6, 40.0), ghn.middleReading(20231106));
    }
    @Test
    public void testPercentError() {
        GregorianCalendar clock = new GregorianCalendar(2023, 10, 7, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        ghn.pollSensorData(sameMonth);
        assertEquals(25.0,
                ghn.percentError(), .1);
    }
    @Test
    public void testPercentError2() {
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
        ghn.pollSensorData(sameMonthTheSecond);
        assertEquals(33.3,
                ghn.percentError(), .1);
    }
    @Test
    public void testGreenHouseNurseryProducePollSensorTime() {
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseProduce ghp = new GreenHouseProduce(clock, new CoolerGreenHouse());
        GregorianCalendar clock2 = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
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
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseProduce ghp = new GreenHouseProduce(clock, new CoolerGreenHouse());
        GregorianCalendar clock2 = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseNursery ghn = new GreenHouseNursery(clock, new CoolerGreenHouse());
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
/** Switch Strategy Tests */
    @Test
    public void SwitchStrategyTest() {
    GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
    GreenHouseProduce ghp = new GreenHouseProduce(clock, new CoolerGreenHouse());
    ghp.switchStrategy(new EvenCoolerGreenHouse());
    ghp.pollSensorData(sameMonth);
    assertTrue(ghp.parsedDataStrategy.getData() instanceof ArrayList<?>);
}
    @Test
    public void SwitchStrategyTest2() {
        GregorianCalendar clock = new GregorianCalendar(2023, 8, 2, 4, 35, 23);
        GreenHouseProduce ghp = new GreenHouseProduce(clock, new EvenCoolerGreenHouse());
        ghp.switchStrategy(new CoolerGreenHouse());
        ghp.pollSensorData(sameMonth);
        assertTrue(ghp.parsedDataStrategy.getData() instanceof LinkedList<?>);
    }
    }




