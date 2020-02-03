package org.abc;

public class CountAndSay {
    public static void main(String[] args) {
        for(int i=1;i<10;i++) {
            System.out.println(countAndSay(i));
        }
    }

    public static String countAndSay(int n) {
        if(n==1) {
            return "1";
        }
        if(n==2) {
            return "11";
        }

        String prev = "11";
        for(int i=3;i<=n;i++) {
            prev = nextCountAndSay(prev);
        }
        return prev;
    }

    private static String nextCountAndSay(String prev) {
        StringBuilder s = new StringBuilder();
        int count = 1;
        for(int i=1;i<prev.length();i++) {
            if(prev.charAt(i) != prev.charAt(i-1)) {
                s.append(count).append(prev.charAt(i-1));
                count = 1;
            }else {
                count++;
            }
        }
        s.append(count).append(prev.charAt(prev.length()-1));
        return s.toString();
    }
}
