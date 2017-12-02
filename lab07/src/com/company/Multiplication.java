package com.company;

public class Multiplication extends BinaryExpression implements Expression{

    public Multiplication(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return firstValue.calculate() * secondValue.calculate();
    }
}
