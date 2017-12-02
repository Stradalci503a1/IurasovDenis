package com.company;

public class Value{

    public static double valueOf(Object value) throws NumberFormatException {
        switch (value.getClass().getName()){
            case "java.lang.Byte":
            case "java.lang.Short":
            case "java.lang.Integer":
            case "java.lang.Long":
            case "java.lang.Float":
                return Double.valueOf(value.toString());
            case "java.lang.Double":
                return (double)value;
            case "java.lang.String":
                try
                {
                    return Double.valueOf((String) value);
                }
                catch (NumberFormatException exception){
                    return Double.NaN;
                }
            default:
                for (Class interfaces : value.getClass().getInterfaces()) {
                    if (interfaces.getName() == "com.company.Expression"){
                        return ((Expression)value).calculate();
                    }
                }
                return Double.NaN;
        }
    }
}
