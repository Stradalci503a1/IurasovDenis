package com.company;

public class Addition extends BinaryExpression implements Expression{

    public Addition(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return firstValue.calculate() + secondValue.calculate();
    }
}
