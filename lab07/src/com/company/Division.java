package com.company;

public class Division extends BinaryExpression implements Expression{

    public Division(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return 0 == getSecondValue().calculate() ? Double.NaN : getFirstValue().calculate() / getSecondValue().calculate();
    }
}
