package com.company;

public class Square extends UnaryExpression implements Expression{

    private Double value;

    public Square(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        if (value == null) {
            value = value().calculate() * value().calculate();
        }

        return value;
    }
}
