package com.company;

public class Division extends BinaryExpression implements Expression{

    public Division(Expression firstValue, Expression secondValue){
        super(firstValue, secondValue);
    }

    @Override
    public double calculate() {
        return 0 == secondValue.calculate() ? Double.NaN : firstValue.calculate() / secondValue.calculate();
    }
}
