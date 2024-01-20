import org.testng.Assert;
import org.testng.annotations.*;
import vehicles.HomeFuel;
@Test(groups = "homefuel")
public class HomeFuelTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("HomeFuelTest::beforeTest @" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("HomeFuelTest::beforeMethod @" + Thread.currentThread().getName());
    }

    public void hasBarrelOfFuel() {
        var newhomefuel = new HomeFuel(3, "Delivery", "DF56783984934893", "Audi", true, false, 0, true, 13, true, true, false, 12, false, true, false);
        Assert.assertEquals(newhomefuel.isBarrelOfFuel(), false);
    }

    public void sizeBarrelVolume() {
        var newhomefuel = new HomeFuel(3, "Delivery", "DF56783984934893", "Audi", true, false, 0, true, 12, true, true, false, 12, false, true, false);
        Assert.assertEquals(newhomefuel.getBarrelVolume(), 12);
    }

    public void hasBarrelNeck() {
        var newhomefuel = new HomeFuel(3, "Delivery", "DF56783984934893", "Audi", true, false, 0, true, 11, true, true, false, 12, false, true, false);
        Assert.assertEquals(newhomefuel.isBarrelNeck(), false);
    }

    public void hasDrainer() {
        var newhomefuel = new HomeFuel(3, "Delivery", "DF56783984934893", "Audi", true, false, 0, true, 11, true, true, false, 12, false, true, false);
        Assert.assertEquals(newhomefuel.isDrainer(), true);
    }

    public void hasGrounding() {
        var newhomefuel = new HomeFuel(3, "Delivery", "DF56783984934893", "Audi", true, false, 0, true, 11, true, true, false, 12, false, true, false);
        Assert.assertEquals(newhomefuel.isGrounding(), false);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("HomeFuelTest::afterTest @" + Thread.currentThread().getName());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("HomeFuelTest::afterMethod @" + Thread.currentThread().getName());
    }
}
