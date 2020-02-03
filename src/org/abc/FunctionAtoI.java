package org.abc;

public class FunctionAtoI {

    public static void main(String[] args) {
        FunctionAtoI obj = new FunctionAtoI();
        System.out.println(obj.myAtoi("42") == 42);
        System.out.println(obj.myAtoi("   -42") == -42);
        System.out.println(obj.myAtoi("4193 with words") == 4193);
        System.out.println(obj.myAtoi("words and 987") == 0);
        System.out.println(obj.myAtoi(" ") == 0);
        System.out.println(obj.myAtoi("") == 0);
        System.out.println(obj.myAtoi("-91283472332") == Integer.MIN_VALUE);
    }

    public int myAtoi(String str) {
        char[] numChars = str.toCharArray();

        //remove white spaces
        int i = 0;
        while(i< numChars.length && numChars[i] == ' ')
            i++;

        if(i>= numChars.length || (numChars[i] != '+' && numChars[i] != '-' && !(numChars[i] >= '0' && numChars[i] <= '9'))) {
            return 0;
        }

        boolean isNegative = false;
        int result = 0;
        if(numChars[i] == '-') {
            isNegative = true;
        }else if(numChars[i] >= '0' && numChars[i] <= '9') {
            result = numChars[i] - '0';
        }

        i++;
        while(i < numChars.length && numChars[i] >= '0' && numChars[i] <= '9') {
            try {
                result = Math.multiplyExact(result, 10);
                result = Math.addExact(result, (numChars[i] - '0'));
            }catch(ArithmeticException e) {
                if(isNegative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            i++;
        }


        return (isNegative ? -1 : 1) * result;
    }
}
