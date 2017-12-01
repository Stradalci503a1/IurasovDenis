package com.company;

public class Power extends BinaryExpression implements Expression{

    public Power(Expression firstValue, Expression secondValue){
        super(firstValue, secondValue);
    }

    @Override
    public double calculate() {

        double value = firstValue.calculate();
        double power = secondValue.calculate();

        if (value >= 0 || power < 0 || power > 1) {
            return Math.pow(value, power);

        } else if (Math.pow(power, -1.0) % 2 == 0) {
            return Double.NaN;

        } else {
            return -Math.pow(Math.abs(value), power);
        }
    }
}
