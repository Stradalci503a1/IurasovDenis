package com.company;

public class Rest extends BinaryExpression implements Expression{

    public Rest(Object firstValue, Object secondValue){
        super(Value.valueOf(firstValue), Value.valueOf(secondValue));
    }

    @Override
    public double calculate() {
        return 0 == secondValue ? Double.NaN : firstValue % secondValue;
    }
}
