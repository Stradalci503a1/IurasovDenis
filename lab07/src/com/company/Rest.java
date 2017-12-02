package com.company;

public class Rest extends BinaryExpression implements Expression{

    public Rest(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return 0 == getSecondValue().calculate() ? Double.NaN : getFirstValue().calculate() % getSecondValue().calculate();
    }
}
