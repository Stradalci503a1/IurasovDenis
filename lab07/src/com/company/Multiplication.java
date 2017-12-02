package com.company;

public class Multiplication extends BinaryExpression implements Expression{

    public Multiplication(Object firstValue, Object... additionalValues){
        super(new Value(firstValue), new Value(1));

        Expression product = getSecondValue();
        if (additionalValues.length == 1) {
            product = new Multiplication(additionalValues[0]);
        } else {
            for (Object element : additionalValues) {
                product = new Multiplication(element, product);
            }
        }
        setSecondValue(product);
    }

    @Override
    public double calculate() {
        return getFirstValue().calculate() * getSecondValue().calculate();
    }
}
