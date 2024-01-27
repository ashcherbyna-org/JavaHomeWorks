import org.testng.Assert;
import org.testng.annotations.*;
import vehicles.Motorcycle;


public class MotorcycleTest {
    @BeforeTest
    public void beforeTest() {
        System.out.println("MotorcycleTest::beforeTest @" + Thread.currentThread().getName());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("MotorcycleTest::beforeMethod @" + Thread.currentThread().getName());
    }

    @Test(groups = {"motorcycle"})
    public void hasSideCar() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isSideCar(), false);
        System.out.println("MotorcycleTest::hasSideCar @" + Thread.currentThread().getName());
    }
    @Test(groups = {"motorcycle"})
    public void checkHasTrunk() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isHasTrunk(), false);
        System.out.println("MotorcycleTest::checkHasTrunk @" + Thread.currentThread().getName());
    }
    @Test(groups = {"motorcycle"})
    public void hasFootrests() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isFootrests(), true);
        System.out.println("MotorcycleTest::hasFootrests @" + Thread.currentThread().getName());
    }
    @Test(groups = {"motorcycle"})
    public void hasVerticalFit() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isVerticalFit(), false);
        System.out.println("MotorcycleTest::hasVerticalFit @" + Thread.currentThread().getName());
    }
    @Test(groups = {"motorcycle"})
    public void hasHelmet() {
        var newmotorcycle = new Motorcycle(2, "Sport", "DF57733843748", "Harley", true, true, false, false, true, false, false);
        Assert.assertEquals(newmotorcycle.isHelmet(), false);
        System.out.println("MotorcycleTest::hasHelmet @" + Thread.currentThread().getName());
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
