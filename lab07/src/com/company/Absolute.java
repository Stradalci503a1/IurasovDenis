package com.company;

public class Absolute extends UnaryExpression implements Expression{

    public Absolute(Object value){
        super(Value.valueOf(value));
    }

    @Override
    public double calculate() {
        return Math.abs(value);
    }
}
