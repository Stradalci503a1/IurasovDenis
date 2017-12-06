package com.company.Binary;

import com.company.Base.BinaryExpression;
import com.company.Base.IExpression;
import com.company.Base.Value;

public class Power extends BinaryExpression implements IExpression {

    public Power(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return cache(() -> firstValue().calculate() >= 0 || secondValue().calculate() < 0 || secondValue().calculate() > 1 ?
                    Math.pow(firstValue().calculate(), secondValue().calculate()) :
                    Math.pow (secondValue().calculate(), -1) % 2 == 0 ?
                        Double.NaN :
                        -Math.pow(Math.abs(firstValue().calculate()), secondValue().calculate()));
    }
}
