package com.company;

public class Negative extends UnaryExpression implements Expression{

    public Negative(Object value){
        super(Value.valueOf(value));
    }

    @Override
    public double calculate() {
        return -value;
    }
}
