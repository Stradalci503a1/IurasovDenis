package com.company;

public class Substraction extends BinaryExpression implements Expression{

    private Double value;

    public Substraction(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        if (value == null){
            value = firstValue().calculate() - secondValue().calculate();
        }
        return value;
    }
}
