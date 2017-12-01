package com.company;

public class Rest extends BinaryExpression implements Expression{

    public Rest(Expression firstValue, Expression secondValue){
        super(firstValue, secondValue);
    }

    @Override
    public double calculate() {
        return 0 == secondValue.calculate() ? Double.NaN : firstValue.calculate() % secondValue.calculate();
    }
}
