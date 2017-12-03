package com.company.Base;

class Expression {
    private Double result;

    protected double result(double result) {
        if (this.result == null) {
            this.result = result;
        }

        return this.result;
    }
}
