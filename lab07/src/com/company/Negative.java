package com.company;

public class Negative extends UnaryExpression implements Expression{

    private Double value;

    public Negative(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        if (value == null){
            value = -value().calculate();
        }

        return value;
    }
}
