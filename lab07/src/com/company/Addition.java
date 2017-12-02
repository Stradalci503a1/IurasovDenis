package com.company;

public class Addition extends BinaryExpression implements Expression{

    public Addition(Object firstValue, Object secondValue, Object... additionalValues){
        super(Value.valueOf(firstValue), Value.valueOf(secondValue));

        double previousSum = this.secondValue;
        for (Object element : additionalValues){
            previousSum += Value.valueOf(element);
        }
        this.secondValue = previousSum;
    }

    @Override
    public double calculate() {
        return firstValue + secondValue;
    }
}
