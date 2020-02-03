package org.abc;

public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));

    }
    public static boolean isPalindrome(String s) {
        if(s== null || s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int startIndex = 0;
        int endIndex = s.length() -1;
        while(startIndex < endIndex) {
            char srcChar = s.charAt(startIndex);
            if(!isValidSrcChar(srcChar)) {
            startIndex++;
                continue;
            }
            char endChar = s.charAt(endIndex);
            if(!isValidSrcChar(endChar)) {
            endIndex--;
                continue;
            }

            if(srcChar != endChar) {
                return false;
            }
            startIndex++;
            endIndex--;
        }


        return true;
    }

    private static boolean isValidSrcChar(char srcChar) {
        int code = srcChar - 'a';
        int num = srcChar - '0';
        return (!(code < 0 || code > 25)) || (!(num < 0 || num > 9));
    }
}
