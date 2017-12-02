package com.company;

public class Square extends UnaryExpression implements Expression{

    public Square(Object value){
        super(Value.valueOf(value));
    }

    @Override
    public double calculate() {
        return value * value;
    }
}
