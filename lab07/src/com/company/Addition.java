package com.company;

public class Addition extends BinaryExpression implements Expression{

    public Addition(Expression firstValue, Expression secondValue){
        super(firstValue, secondValue);
    }

    @Override
    public double calculate() {
        return firstValue.calculate() + secondValue.calculate();
    }
}
