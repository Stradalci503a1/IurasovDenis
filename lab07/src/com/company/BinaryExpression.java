package com.company;

public abstract class BinaryExpression {

    double firstValue;
    double secondValue;

    public BinaryExpression(double firstValue, double secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
}
