import org.junit.Assert;
import org.junit.Test;

public class LockerTests {

    @Test
    public void changeLocked(){
        Locker locker = new Locker(5, true);
        try {
            locker.set(3);
            Assert.fail("Locker locked but value changed");
        } catch (LockerLockedException exception) {
        }
    }

    @Test
    public void changeUnlocked(){
        Locker locker = new Locker(3, false);
        try{
            locker.set(7);
            Assert.assertEquals(7, locker.get());
        } catch (LockerLockedException exception){
            Assert.fail("Locker unlocked but value not changed");
        }
    }
}
