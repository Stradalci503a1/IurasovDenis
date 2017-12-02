package com.company;

public class Substraction extends BinaryExpression implements Expression{

    public Substraction(Object firstValue, Object secondValue){
        super(Value.valueOf(firstValue),Value.valueOf(secondValue));
    }

    @Override
    public double calculate() {
        return firstValue - secondValue;
    }
}
