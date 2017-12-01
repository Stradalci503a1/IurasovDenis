package com.company;

public class Negative extends UnaryExpression implements Expression{

    public Negative(Expression value){
        super(value);
    }

    @Override
    public double calculate() {
        return -value.calculate();
    }
}
