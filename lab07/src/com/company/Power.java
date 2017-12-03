package com.company;

public class Power extends BinaryExpression implements Expression{

    private Double value;

    public Power(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        if (value == null) {
            double value = firstValue().calculate();
            double power = secondValue().calculate();

            if (value >= 0 || power < 0 || power > 1) {
                this.value = Math.pow(value, power);

            } else if (Math.pow(power, -1.0) % 2 == 0) {
                this.value = Double.NaN;

            } else {
                this.value = -Math.pow(Math.abs(value), power);
            }
        }

        return value;
    }
}
