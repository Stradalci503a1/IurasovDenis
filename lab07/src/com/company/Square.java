package com.company;

public class Square extends UnaryExpression implements Expression{

    public Square(Expression value){
        super(value);
    }

    @Override
    public double calculate() {
        double value = this.value.calculate();
        return value * value;
    }
}
