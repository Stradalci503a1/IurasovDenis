package com.company;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class DeepCompare implements IDeepCompare{

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

        Object left1 = left;
        Object right1 = right;
        if (left instanceof Byte) {
            return (Byte)left1 == (Byte)right1;
        } else if (left instanceof Short) {
            return (Short)left1 == (Short)right1;
        } else if (left instanceof Integer) {
            return (int)left1 == (int)right1;
        } else if (left instanceof Long) {
            return (long)left1 == (long)right1;
        } else if (left instanceof Float) {
            return (float)left1 == (float)right1;
        } else if (left instanceof Double) {
            return (double)left1 == (double)right1;
        } else if (left instanceof Boolean) {
            return (boolean)left1 == (boolean)right1;
        } else if (left instanceof Character) {
            return (char)left1 == (char)right1;
        }

        if (null == left || null == right){
            return false;
        }

        metObjects.add(left);
        metObjects.add(right);

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

        metObjects.remove(left);
        metObjects.remove(right);

        return true;
    }
}
