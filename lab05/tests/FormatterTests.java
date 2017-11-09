import org.junit.Assert;
import org.junit.Test;

public class FormatterTests {

    @Test
    public void nullString(){
        check(null, null);
    }

    @Test
    public void notEnoughArguments(){
        check("{0}  gsdg {1}",null, 34);
    }

    @Test
    public void incorrectFiller() {
        check("342 {a} rwq {}", "342 {a} rwq {}");
    }

    @Test
    public void moreArgumentsThanNeeded() {
        check("fsefs {0} gsg", "fsefs 15 gsg", 15, 463, "rrew");
    }

    @Test
    public void skippedArgument() {
        check("ge{0} {2}", "ge54 g", 54, 21, "g");
    }

    @Test
    public void correct(){
        check("Hello {0}, I am {1} years old","Hello hell, I am 15 years old", "hell", 15);
    }

    private void check(String input, String output, Object... arguments){
        Assert.assertEquals(Formatter.build(input, arguments), output);
    }
}
