package com.company;

public class Addition extends BinaryExpression implements Expression{

    public Addition(Object firstValue, Object... additionalValues){
        super(new Value(firstValue), new Value(0));

        Expression sum = getSecondValue();
        if (additionalValues.length == 1){
            sum = new Addition(additionalValues[0]);
        } else {
            for (Object element : additionalValues) {
                sum = new Addition(element, sum);
            }
        }
        setSecondValue(sum);
    }

    @Override
    public double calculate() {
        return getFirstValue().calculate() + getSecondValue().calculate();
    }
}
