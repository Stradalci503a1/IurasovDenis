package com.company.tests;

import com.company.*;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionsTests {

    @Test
    public void value(){
        assertEquals(5, Value.valueOf(5), 0.001);

        assertEquals(5235, Value.valueOf(5235L), 0.001);

        assertEquals(53.4, Value.valueOf(53.4), 0.0001);

        assertEquals(56.2, Value.valueOf(56.2F), 0.0001);

        assertEquals(21, Value.valueOf((byte)21), 0.001);

        assertEquals(21657,  Value.valueOf((short)21657), 0.001);

        assertEquals(654, Value.valueOf("654"), 0.001);

        assertEquals(Double.NaN, Value.valueOf("436dgs4"));
    }

    @Test
    public void absolute(){
        Expression absolute = new Absolute(-7);
        assertEquals(7, absolute.calculate(), 0.001);
    }

    @Test
    public void negative(){
        Expression negative = new Negative(-4);
        assertEquals(4, negative.calculate(), 0.001);
    }

    @Test
    public void square(){
        Expression square = new Square(3);
        assertEquals(9, square.calculate(), 0.001);
    }

    @Test
    public void addition(){
        Expression addition = new Addition(3, 8);
        assertEquals(11, addition.calculate(), 0.001);

        addition = new Addition(5, "2", 0.1F, 3.4);
        assertEquals(10.5, addition.calculate(), 0.0001);
    }

    @Test
    public void multiplication(){
        Expression multiplication = new Multiplication(-5, 2);
        assertEquals(-10, multiplication.calculate(), 0.001);

        multiplication = new Multiplication(5, "2", 0.1F, 3.4);
        assertEquals(3.4, multiplication.calculate(), 0.0001);
    }

    @Test
    public void substraction() {
        Expression substraction = new Substraction(-2 , 7);
        assertEquals(-9, substraction.calculate(), 0.001);
    }

    @Test
    public void division() {
        Expression division = new Division(6, 3);
        assertEquals(2, division.calculate(), 0.001);

        division = new Division(3, 0);
        assertEquals(Double.NaN, division.calculate());
    }

    @Test
    public void power() {
        Expression power = new Power(3, 4);
        assertEquals(81, power.calculate(), 0.001);

        power = new Power(-5, 1.0/2.0);
        assertEquals(Double.NaN, power.calculate());

        power = new Power(-8, 1.0/3.0);
        assertEquals(-2, power.calculate(), 0.001);
    }

    @Test
    public void rest() {
        Expression rest = new Rest(5, 2);
        assertEquals(1, rest.calculate(), 0.001);

        rest = new Rest(6, 0);
        assertEquals(Double.NaN, rest.calculate());
    }

    @Test
    public void mathExpression(){
        //Mathematical expression: 5^3 + 2 * (-4) - 3 / (2^2 % |-3|)
        Expression expression = new Addition(
                                    new Power(5, 3),
                                    new Substraction(
                                            new Multiplication(2,
                                                    new Negative(4)),
                                            new Division(3,
                                                    new Rest(
                                                            new Square(2),
                                                            new Absolute(-3)))));
        assertEquals(114, expression.calculate(), 0.001);
    }
}
