package com.company.Base;

public abstract class BinaryExpression extends Expression {

    private IExpression firstValue;
    private IExpression secondValue;

    public BinaryExpression(IExpression firstValue, IExpression secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public IExpression firstValue() {
        return firstValue;
    }

    public void firstValue(IExpression value) {
        firstValue = value;
    }

    public IExpression secondValue() {
        return secondValue;
    }

    public void secondValue(IExpression value) {
        secondValue = value;
    }
//    public IExpression getFirstValue() {
//        return firstValue;
//    }
//
//    public IExpression getSecondValue() {
//        return secondValue;
//    }
//
//    public void setFirstValue(IExpression firstValue) {
//        this.firstValue = firstValue;
//    }
//
//    public void setSecondValue(IExpression secondValue) {
//        this.secondValue = secondValue;
//    }
}
