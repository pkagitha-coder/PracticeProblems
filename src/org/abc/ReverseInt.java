package org.abc;

import java.sql.SQLOutput;

public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverseInt(-123));
        System.out.println(reverseInt(2147483647));
    }

    private static int reverseInt(int x) {
        int abs = Math.abs(x);
        int rev = 0;
        while (abs > 0) {
            try {
                rev = Math.multiplyExact(rev, 10);
                rev = Math.addExact(rev, abs % 10);
            } catch (ArithmeticException ae) {
                return 0;
            }
            abs = abs / 10;
        }
        rev *= x > 0 ? 1 : -1;
        return rev;


    }
}
