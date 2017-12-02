package com.company;

public abstract class BinaryExpression {

    private Expression firstValue;
    private Expression secondValue;

    public BinaryExpression(Expression firstValue, Expression secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public Expression getFirstValue() {
        return firstValue;
    }

    public Expression getSecondValue() {
        return secondValue;
    }

    public void setFirstValue(Expression firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(Expression secondValue) {
        this.secondValue = secondValue;
    }
}
