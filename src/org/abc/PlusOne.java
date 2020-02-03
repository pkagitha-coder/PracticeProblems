package org.abc;

public class PlusOne {
    public static void main(String[] args) {
     int[] result = plusOne(new int[]{9,9,9});
     for(int i: result) {
         System.out.print(i);
     }

    }

    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length -1;
        digits[lastIndex]++;
        while(lastIndex > 0 && digits[lastIndex] == 10) {
            digits[lastIndex] = 0;
            digits[--lastIndex]++;
        }

        int[] result = digits;
        if(digits[lastIndex] == 10) {
            result = new int[digits.length+1];
            digits[lastIndex] = 0;
            System.arraycopy(digits,0,result,1,digits.length);
            result[0] = 1;
        }
        return result;
    }
}
