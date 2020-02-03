package org.abc;

public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","baa"));
        System.out.println(strStr("mississippi","issip"));
    }

   /* public static int strStr(String haystack, String needle) {
        int j =0;
        int result = 0;
        for(int i=0;i<haystack.length() && j < needle.length();i++) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }else {
                result =
                j=needle.length() - j;
            }
        }

        return (needle.length()) == j ? result : -1;
    }*/

    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }

        int hashNeedle = 0;
        int hashHayStackWindow = 0;
        int base = 26;
        int power = 1;

        hashNeedle = needle.charAt(0);
        hashHayStackWindow = haystack.charAt(0);

        for(int i=1;i<needle.length();i++) {
            hashNeedle = hashNeedle*base + needle.charAt(i);
            hashHayStackWindow = hashHayStackWindow * base + haystack.charAt(i);

            power = base*power;
        }

        for(int i=needle.length();i<haystack.length();i++) {
            if(hashNeedle == hashHayStackWindow) {
                if(needle.equals(haystack.substring(i - needle.length(),i))) {
                    return (i-needle.length());
                }
            }

            //rolling hash
            hashHayStackWindow = hashHayStackWindow - haystack.charAt(i-needle.length())*power;
            hashHayStackWindow = hashHayStackWindow*base + haystack.charAt(i);
        }

        if(hashNeedle == hashHayStackWindow) {
            if(needle.equals(haystack.substring(haystack.length() - needle.length()))) {
                return (haystack.length() - needle.length());
            }
        }

        return -1;
    }
}
