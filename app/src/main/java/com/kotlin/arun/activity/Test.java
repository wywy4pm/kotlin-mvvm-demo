package com.kotlin.arun.activity;

import android.text.TextUtils;

/**
 * Created by wy on 2017/6/29.
 */

public class Test {

    public static boolean getXO(String str) {
        // Good Luck!!
        int countX = 0;
        int countO = 0;
        boolean isHaveXO = false;
        if (!TextUtils.isEmpty(str)) {
            char[] chars = str.toCharArray();
            if (chars.length >= 2) {
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == 'x' || chars[i] == 'X') {
                        countX += 1;
                    }
                    if (chars[i] == 'o' || chars[i] == 'O') {
                        countO += 1;
                    }
                }
            }
        }
        if (countX == countO) {
            isHaveXO = true;
        }
        return isHaveXO;
    }

    public static int sortDesc(final int num) {
        //Your code
        //String.valueOf(num).chars().mapToObj(i ->String.valueOf(Character.getNumericValue(i))).sorted(Comparator.reverseOrder()).collect(Collectors.joining());

        String nums = String.valueOf(num);
        int[] ints = new int[nums.length()];
        for (int i = 0; i < nums.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(nums.charAt(i)));
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                int temp = 0;
                if (ints[i] < ints[j]) {
                    temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
            }
        }

        String string = "";
        for (int i = 0; i < ints.length; i++) {
            string += ints[i];
        }

        return Integer.parseInt(string);
    }

    public static int squareDigits(int num) {
        String nums = String.valueOf(num);
        int[] ints = new int[nums.length()];
        for (int i = 0; i < ints.length; i++) {
            int i1 = Integer.parseInt(String.valueOf(nums.charAt(i)));
            ints[i] = i1 * i1;
        }
        String string = "";
        for (int i = 0; i < ints.length; i++) {
            string += ints[i];
        }
        return Integer.parseInt(string);
    }

}
