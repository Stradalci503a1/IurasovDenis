package com.company.tests;

import com.company.*;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionsTests {

    @Test
    public void value(){
        Expression value = new Value(5);
        assertEquals(5, value.calculate());

        value = new Value(5235L);
        assertEquals(5235, value.calculate());

        value = new Value(53.4);
        assertEquals(53.4, value.calculate());

        value = new Value(56.2F);
        assertEquals(56.2, value.calculate());

        value = new Value((byte)21);
        assertEquals(21.0, value.calculate());

        value = new Value((short)21657);
        assertEquals(21657, value.calculate());

        value = new Value("654");
        assertEquals(654, value.calculate());

        value = new Value("436dgs4");
        assertEquals(Double.NaN, value.calculate());
    }

    @Test
    public void absolute(){
        Expression absolute = new Absolute(new Value(-7));
        assertEquals(7, absolute.calculate());
    }

    @Test
    public void negative(){
        Expression negative = new Negative(new Value(-4));
        assertEquals(4, negative.calculate());
    }

    @Test
    public void square(){
        Expression square = new Square(new Value(3));
        assertEquals(9, square.calculate());
    }

    @Test
    public void addition(){
        Expression addition = new Addition(new Value(3), new Value(8));
        assertEquals(11, addition.calculate());
    }

    @Test
    public void multiplication(){
        Expression multiplication = new Multiplication(new Value(-5), new Value(2));
        assertEquals(-10, multiplication.calculate());
    }

    @Test
    public void substraction() {
        Expression substraction = new Substraction(new Value(-2), new Value(7));
        assertEquals(-9, substraction.calculate());
    }

    @Test
    public void division() {
        Expression division = new Division(new Value(6), new Value(3));
        assertEquals(2, division.calculate());

        division = new Division(new Value(3), new Value(0));
        assertEquals(Double.NaN, division.calculate());
    }

    @Test
    public void power() {
        Expression power = new Power(new Value(3), new Value(4));
        assertEquals(81, power.calculate());

        power = new Power(new Value(-5), new Value(1.0/2.0));
        assertEquals(Double.NaN, power.calculate());

        power = new Power(new Value(-8), new Value(1.0/3.0));
        assertEquals(-2, power.calculate());
    }

    @Test
    public void rest() {
        Expression rest = new Rest(new Value(5), new Value(2));
        assertEquals(1, rest.calculate());

        rest = new Rest(new Value(6), new Value(0));
        assertEquals(Double.NaN, rest.calculate());
    }

    @Test
    public void mathExpression(){
        //Mathematical expression: 5^3 + 2 * (-4) - 3 / (2^2 % |-3|)
        Expression expression = new Addition(
                                    new Power(
                                            new Value(5),
                                            new Value(3)),
                                    new Substraction(
                                            new Multiplication(
                                                    new Value(2),
                                                    new Negative(
                                                            new Value(4))),
                                            new Division(
                                                    new Value(3),
                                                    new Rest(
                                                            new Square(
                                                                    new Value(2)),
                                                            new Absolute(
                                                                    new Value(-3))))));
        assertEquals(114, expression.calculate());
    }
}
