package com.company;

public class Substraction extends BinaryExpression implements Expression{

    public Substraction(Expression firstValue, Expression secondValue){
        super(firstValue, secondValue);
    }

    @Override
    public double calculate() {
        return firstValue.calculate() - secondValue.calculate();
    }
}
