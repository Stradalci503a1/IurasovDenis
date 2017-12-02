package com.company;

public class Square extends UnaryExpression implements Expression{

    public Square(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        double value = this.value.calculate();
        return value * value;
    }
}
