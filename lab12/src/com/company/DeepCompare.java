package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class DeepCompare implements IDeepCompare {

    ArrayList metObjects = new ArrayList();

    @Override
    public <TObject> boolean isEqual(TObject left, TObject right) {

        if (left == right) {
            return true;
        }

        if (-1 < metObjects.indexOf(left) || -1 < metObjects.indexOf(right)) {
            System.out.println("Cyclical");
            return false;
        }

        Object leftObject = left;
        Object rightObject = right;
        if (left instanceof Byte) {
            return (Byte) leftObject == (Byte) rightObject;
        } else if (left instanceof Short) {
            return (Short) leftObject == (Short) rightObject;
        } else if (left instanceof Integer) {
            return (int) leftObject == (int) rightObject;
        } else if (left instanceof Long) {
            return (long) leftObject == (long) rightObject;
        } else if (left instanceof Float) {
            return (float) leftObject == (float) rightObject;
        } else if (left instanceof Double) {
            return (double) leftObject == (double) rightObject;
        } else if (left instanceof Boolean) {
            return (boolean) leftObject == (boolean) rightObject;
        } else if (left instanceof Character) {
            return (char) leftObject == (char) rightObject;
        }

        if (null == left || null == right) {
            return false;
        }

        metObjects.add(left);
        metObjects.add(right);

        if (left.getClass().isArray()) {

            //arrayEquals(left);
        } else {
            for (Field field : left.getClass().getDeclaredFields()) {

                try {
                    field.setAccessible(true);
                    if (!isEqual(field.get(left), field.get(right))) {
                        metObjects.remove(left);
                        metObjects.remove(right);

                        return false;
                    }

                } catch (Exception e) {
                }
            }
        }
        metObjects.remove(left);
        metObjects.remove(right);

        return true;
    }

    private boolean arrayEquals(Object[] a) {
        return true;
    }
}
