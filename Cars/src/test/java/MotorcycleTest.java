import org.testng.Assert;
import org.testng.annotations.*;
import vehicles.Motorcycle;

@Test(groups = "motorcycle")
public class MotorcycleTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("MotorcycleTest::beforeTest @" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("MotorcycleTest::beforeMethod @" + Thread.currentThread().getName());
    }

    public void hasSideCar() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isSideCar(), false);
    }

    public void checkHasTrunk() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isHasTrunk(), false);
    }

    public void hasFootrests() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isFootrests(), true);
    }

    public void hasVerticalFit() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isVerticalFit(), false);
    }

    public void hasHelmet() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isHelmet(), false);
    }

    @AfterTest
    public void afterTest() {
        System.out.println("MotorcycleTest::afterTest @" + Thread.currentThread().getName());
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("MotorcycleTest::afterMethod @" + Thread.currentThread().getName());
    }
}
