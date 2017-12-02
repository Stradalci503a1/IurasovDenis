package com.company;

public class Value implements Expression{

    double value;

    public Value(Object value) throws NumberFormatException {
        switch (value.getClass().getName()){
            case "java.lang.Byte":
            case "java.lang.Short":
            case "java.lang.Integer":
            case "java.lang.Long":
            case "java.lang.Float":
                this.value = Double.valueOf(value.toString());
                break;
            case "java.lang.Double":
                this.value = (double)value;
                break;
            case "java.lang.String":
                try
                {
                    this.value = Double.valueOf((String) value);
                }
                catch (NumberFormatException exception){
                    this.value = Double.NaN;
                }
                break;
            default:
                for (Class interfaces : value.getClass().getInterfaces()) {
                    if (interfaces.getName() == "com.company.Expression"){
                        this.value = ((Expression)value).calculate();
                        return;
                    }
                }
                this.value = Double.NaN;
        }
    }

    @Override
    public double calculate() {
        return value;
    }
}
