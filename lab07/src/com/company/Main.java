package com.company;

public class Main {

    public static void main(String[] args) {



        Expression k = new Absolute(new Addition(5, 1));
        test(k);
        //System.out.println(k.calculate());
    }

    private static void test(Object object){
        for (Class interfaces : object.getClass().getInterfaces()) {
            if (interfaces.getName() == "com.company.Expression"){
                System.out.println(((Expression)object).calculate());
            }
        }
    }
}
