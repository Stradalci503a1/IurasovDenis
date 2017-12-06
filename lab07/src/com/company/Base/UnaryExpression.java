package com.company.Base;

public abstract class UnaryExpression {

    private IExpression value;
    protected CacheResult cache;

    public UnaryExpression(IExpression value){
        this.value = value;
        cache = new CacheResult((IExpression) this);
    }

    public IExpression value() {
        return value;
    }

    public void value(IExpression value) {
        this.value = value;
    }

    public boolean equals(UnaryExpression expression) {
        return value.calculate() == expression.value.calculate();
    }
}
