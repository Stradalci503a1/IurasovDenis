package com.company.tests;

import com.company.DeepCompare;
import com.company.IDeepCompare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeepCompareTests {


    @Test
    public void nullPointer() {

        IDeepCompare compare = new DeepCompare();

        PublicFields<Integer> firstObject = null;
        PublicFields<Integer> secondObject = null;
        PublicFields<Integer> thirdObject = new PublicFields<>(6);

        Assertions.assertTrue(compare.isEqual(firstObject, secondObject));
        Assertions.assertFalse(compare.isEqual(firstObject, thirdObject));
    }

    @Test
    public void privateFields() {

        IDeepCompare compare = new DeepCompare();

        PrivateFields firstObject = new PrivateFields(34, 'a');
        PrivateFields secondObject = new PrivateFields(34, 'a');
        PrivateFields thirdObject = new PrivateFields(15, 'a');

        Assertions.assertTrue(compare.isEqual(firstObject, secondObject));
        Assertions.assertFalse(compare.isEqual(firstObject, thirdObject));
    }

    @Test
    public void cyclicLinks() {

        IDeepCompare compare = new DeepCompare();

        ToCyclic firstObject = new ToCyclic();
        ToCyclic secondObject = new ToCyclic(firstObject);
        ToCyclic thirdObject = new ToCyclic(secondObject);
        firstObject = secondObject;

        Assertions.assertFalse(compare.isEqual(firstObject, thirdObject));
    }

    @Test
    public void publicFields() {

        IDeepCompare compare = new DeepCompare();

        int i = 1;
        PublicFields<String> firstObject = new PublicFields<>("Test" + i);
        PublicFields<String> secondObject = new PublicFields<>("Test" + i);
        PublicFields<String> thirdObject = new PublicFields<>("4");

        Assertions.assertTrue(compare.isEqual(firstObject, secondObject));
        Assertions.assertFalse(compare.isEqual(firstObject, thirdObject));
    }
}
