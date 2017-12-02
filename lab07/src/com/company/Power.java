package com.company;

public class Power extends BinaryExpression implements Expression{

    public Power(Object firstValue, Object secondValue){
        super(Value.valueOf(firstValue), Value.valueOf(secondValue));
    }

    @Override
    public double calculate() {

        if (firstValue >= 0 || secondValue < 0 || secondValue > 1) {
            return Math.pow(firstValue, secondValue);

        } else if (Math.pow(secondValue, -1.0) % 2 == 0) {
            return Double.NaN;

        } else {
            return -Math.pow(Math.abs(firstValue), secondValue);
        }
    }
}
