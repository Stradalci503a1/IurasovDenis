package com.company;

public class Multiplication extends BinaryExpression implements Expression{

    public Multiplication(Expression firstValue, Expression secondValue){
        super(firstValue, secondValue);
    }

    @Override
    public double calculate() {
        return firstValue.calculate() * secondValue.calculate();
    }
}
