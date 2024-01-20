import org.testng.Assert;
import org.testng.annotations.*;
import vehicles.Bus;

@Test(groups = "bus")
public class BusTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("BusTest::beforeTest @" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BusTest::beforeMethod @" + Thread.currentThread().getName());
    }

    public void hasRampTrue() {
        var newbus = new Bus(1, "schoolbus", "VI7672637328", "BMW", true, true, true, true, 39, true, false);
        Assert.assertEquals(newbus.isHasRamp(), true);
    }

    public void hasAutomaticDoors() {
        var newbus = new Bus(1, "schoolbus", "VI7672637328", "BMW", true, true, true, true, 39, true, false);
        Assert.assertEquals(newbus.isAutomaticDoors(), true);
    }

    public void verifyNumberOfSeats() {
        var newbus = new Bus(1, "schoolbus", "VI7672637328", "BMW", true, true, true, true, 39, true, false);
        Assert.assertEquals(newbus.getNumberOfSeats(), 39);
    }

    public void hasCargoBelts() {
        var newbus = new Bus(1, "schoolbus", "VI7672637328", "BMW", true, true, true, true, 39, true, false);
        Assert.assertEquals(newbus.isCargoBelts(), true);
    }

    public void hasRouteNumber() {
        var newbus = new Bus(1, "schoolbus", "VI7672637328", "BMW", true, true, true, true, 39, true, false);
        Assert.assertEquals(newbus.isRouteNumber(), false);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("BusTest::afterTest @" + Thread.currentThread().getName());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("BusTest::afterMethod @" + Thread.currentThread().getName());
    }
}
