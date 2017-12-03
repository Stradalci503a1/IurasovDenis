package com.company;

public abstract class UnaryExpression {

    private Expression value;

    public UnaryExpression(Expression value){
        this.value = value;
    }

    public Expression value() {
        return value;
    }

    public void value(Expression value) {
        this.value = value;
    }
}
