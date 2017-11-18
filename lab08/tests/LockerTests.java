import org.junit.Assert;
import org.junit.Test;

public class LockerTests {

    @Test
    public void changeLocked(){
        Locker locker = new Locker(5, true);
        try {
            locker.set(3);
            Assert.assertEquals(3, locker.get());
            Assert.fail("Locker locked but value changed");
        } catch (LockerLockedException e) {
        }
    }
}
