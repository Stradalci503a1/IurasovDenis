package com.company.Base;

import com.company.Binary.Addition;
import com.company.Binary.Division;
import com.company.Binary.Multiplication;
import com.company.Unary.Negative;

public class Main {

    public static void main(String[] args) {
        IExpression e1 = new Addition(532, new Division(25, new Negative(-5)));
        IExpression e2 = new Multiplication(532, 1);
        IExpression e3 = new Addition(532, new Division(25, new Negative(-5)));
        IExpression e4 = e1;

        System.out.println(Utils.equals(e1, e2));
        System.out.println(Utils.equals(e1, e3));
        System.out.println(Utils.equals(e1, e4));
    }
}
