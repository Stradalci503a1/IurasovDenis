package com.company;

public class Substraction extends BinaryExpression implements Expression{

    public Substraction(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return firstValue.calculate() - secondValue.calculate();
    }
}
