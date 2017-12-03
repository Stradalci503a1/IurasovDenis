package com.company;

public class Rest extends BinaryExpression implements Expression{

    private Double value;

    public Rest(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        if (value == null) {
            value = 0 == secondValue().calculate() ? Double.NaN : firstValue().calculate() % secondValue().calculate();
        }

        return value;
    }
}
