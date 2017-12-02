package com.company;

public class Negative extends UnaryExpression implements Expression{

    public Negative(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        return -getValue().calculate();
    }
}
