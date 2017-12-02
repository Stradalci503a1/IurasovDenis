package com.company;

public class Multiplication extends BinaryExpression implements Expression{

    public Multiplication(Object firstValue, Object secondValue, Object... additionalValues){
        super(Value.valueOf(firstValue), Value.valueOf(secondValue));

        double previousSum = this.secondValue;
        for (Object element : additionalValues){
            previousSum *= Value.valueOf(element);
        }
        this.secondValue = previousSum;
    }

    @Override
    public double calculate() {
        return firstValue * secondValue;
    }
}
