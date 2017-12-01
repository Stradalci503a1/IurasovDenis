package com.company;

public abstract class BinaryExpression {

    Expression firstValue;
    Expression secondValue;

    public BinaryExpression(Expression firstValue, Expression secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
}
