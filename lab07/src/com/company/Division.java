package com.company;

public class Division extends BinaryExpression implements Expression{

    public Division(Object firstValue, Object secondValue){
        super(Value.valueOf(firstValue), Value.valueOf(secondValue));
    }

    @Override
    public double calculate() {
        return 0 == secondValue ? Double.NaN : firstValue / secondValue;
    }
}
