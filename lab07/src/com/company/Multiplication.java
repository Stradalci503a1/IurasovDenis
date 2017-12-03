package com.company;

public class Multiplication extends BinaryExpression implements Expression{

    private Double value;

    public Multiplication(Object firstValue, Object... additionalValues){
        super(new Value(firstValue), new Value(1));

        Expression product = secondValue();
        if (additionalValues.length == 1) {
            product = new Multiplication(additionalValues[0]);
        } else {
            for (Object element : additionalValues) {
                product = new Multiplication(element, product);
            }
        }
        secondValue(product);
    }

    @Override
    public double calculate() {
        if (value == null) {
            value = firstValue().calculate() * secondValue().calculate();
        }

        return value;
    }
}
