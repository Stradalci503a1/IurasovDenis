import org.junit.Assert;
import org.junit.Test;

public class calculatorTests {
    @Test
    public void nullExpression(){
        String expression = null;
        Assert.assertEquals(Double.NaN, calculator.calculate(expression), 0);
    }

    @Test
    public void correctExpression(){
        String expression = "(1 + 2) * 4 + 3";
        Assert.assertEquals(15.0, calculator.calculate(expression), 0);
    }

    @Test
    public void incorrectExpression(){
        String expression = "- 1 1 + 3 - - 4";
        Assert.assertEquals(Double.NaN, calculator.calculate(expression), 0);
    }

    @Test
    public void incorrectBrackets(){
        String expression = "1 + 2( 3 - 5 + 1) )";
        Assert.assertEquals(Double.NaN, calculator.calculate(expression), 0);
    }

    @Test
    public void zeroLengthExpression(){
        String expression = "";
        Assert.assertEquals(Double.NaN, calculator.calculate(expression), 0);
    }

    @Test
    public void wrongSymbols(){
        String expression = "1d +df 2";
        Assert.assertEquals(Double.NaN, calculator.calculate(expression), 0);
    }

    @Test
    public void twoDigitsNumber(){
        String expression = "(23 + 7) / 10";
        Assert.assertEquals(3.0, calculator.calculate(expression), 0);
    }
}
