package com.company;

public class Addition extends BinaryExpression implements Expression{

    private Double value;

    public Addition(Object firstValue, Object... additionalValues){
        super(new Value(firstValue), new Value(0));
        Expression sum = secondValue();
        if (additionalValues.length == 1){
            sum = new Addition(additionalValues[0]);
        } else {
            for (Object element : additionalValues) {
                sum = new Addition(element, sum);
            }
        }
        secondValue(sum);
    }

    @Override
    public double calculate() {
        if (value == null) {
            value = firstValue().calculate() + secondValue().calculate();
        }

        return value;
    }
}
