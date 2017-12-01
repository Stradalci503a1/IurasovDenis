package com.company;

public class Absolute extends UnaryExpression implements Expression{

    public Absolute(Expression value){
        super(value);
    }

    @Override
    public double calculate() {
        return Math.abs(value.calculate());
    }
}
