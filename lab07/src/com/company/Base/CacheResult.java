package com.company.Base;

import java.util.ArrayList;

class CacheResult implements IExpression{

    private static ArrayList<Container> cache = new ArrayList<>();

    private Container container;

    public CacheResult(IExpression expression){

        for (Container element : cache) {
            if (Utils.equals(element.expression, expression)) {
                container = element;
            }
        }

        if (container == null) {
            container = new Container(expression);
            cache.add(container);
        }
    }

    @Override
    public double calculate() {
        return container.calculate();
    }

    private class Container{

        private Double result;
        private IExpression expression;

        public Container(IExpression expression) {
            this.expression = expression;
        }

        private double calculate() {
            if (null == result) {
                result = expression.calculate();
            }
            return result;
        }
    }
}
