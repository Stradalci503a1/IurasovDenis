package com.company;

public class Square extends UnaryExpression implements Expression{

    public Square(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        double value = getValue().calculate();

        return value * value;
    }
}
