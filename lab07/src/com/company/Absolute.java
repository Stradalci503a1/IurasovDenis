package com.company;

public class Absolute extends UnaryExpression implements Expression{

    private Double value;

    public Absolute(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        if (value == null){
            value = Math.abs(value().calculate());
        }

        return value;
    }
}
