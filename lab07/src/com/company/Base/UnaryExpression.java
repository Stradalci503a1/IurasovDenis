package com.company.Base;

public abstract class UnaryExpression extends Expression{

    private IExpression value;

    public UnaryExpression(IExpression value){
        this.value = value;
    }

    public IExpression value() {
        return value;
    }

    public void value(IExpression value) {
        this.value = value;
    }
}
