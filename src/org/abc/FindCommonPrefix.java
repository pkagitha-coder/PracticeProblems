package org.abc;

public class FindCommonPrefix {

    public static void main(String[] args) {
        System.out.println(findCommonPrefix(new String[]{"apple","april","ape"}));
        System.out.println(findCommonPrefix(new String[]{"apple","april","ape","bb"}));
        System.out.println(findCommonPrefix(new String[]{"apple","april","ape","abb"}));
        System.out.println(findCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    private static String findCommonPrefix(String[] strings) {
        if(strings == null || strings.length == 0) {
            return "";
        }
        char[] prefix = strings[0].toCharArray();
        int len = prefix.length;

        for(int i=1;i<strings.length;i++) {
            len = findCommonPrefix(prefix,len,strings[i]);
            if(len <= 0) {
                break;
            }
        }

        return new String(prefix,0,len);

    }

    private static int findCommonPrefix(char[] prefix, int len, String string) {
        int newLen = 0;
        len = Math.min(len,string.length());
        for(int i=0;i<len;i++) {
            if(prefix[i] != string.charAt(i)) {
                break;
            }
            newLen++;
        }

        return newLen++;
    }
}
