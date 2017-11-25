import org.junit.Assert;
import org.junit.Test;

public class LockerTests {

    @Test
    public void check() throws LockerLockedException {

        Locker locker = new Locker();
        locker.unlock();

        //Set and get value
        locker.set(15);
        Assert.assertEquals(15, locker.get());

        //Lock and change
        locker.lock();
        try {
            locker.set(3);
            Assert.fail("Locker locked but value changed");
        } catch (LockerLockedException exception) {
            Assert.assertEquals(15, locker.get());
        }

        //Unlock and change
        locker.unlock();
        locker.set(23);
        Assert.assertEquals(23, locker.get());
}
}
