package com.company;

public class Value implements Expression{

    double value;
    public Value(byte value){
        this.value = value;
    }
    public Value(short value){
        this.value = value;
    }
    public Value(int value){
        this.value = value;
    }
    public Value(long value){
        this.value = value;
    }
    public Value(float value){
        this.value =  Math.round(value * 1000000) / 1000000.0;
    }
    public Value(double value){
        this.value = value;
    }
    public Value(String value) {
        try {
            this.value = Double.valueOf(value);
        }
        catch (NumberFormatException exception){
            this.value = Double.NaN;
        }
    }

    @Override
    public double calculate() {
        return value;
    }
}
