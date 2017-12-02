package com.company;

public abstract class UnaryExpression {

    private Expression value;

    public UnaryExpression(Expression value){
        this.value = value;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression value) {
        this.value = value;
    }
}
