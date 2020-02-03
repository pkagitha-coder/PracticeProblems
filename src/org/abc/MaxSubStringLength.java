package org.abc;

import java.util.HashSet;
import java.util.Set;

public class MaxSubStringLength {

    public static void main(String[] args) {
        MaxSubStringLength obj = new MaxSubStringLength();
        System.out.println(obj.lengthOfLongestSubstring("abcabcd"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int maxLength = 0;
        int count = 0;
        for(char ch: s.toCharArray()) {
            if(!set.add(ch)) {
                maxLength = Math.max(maxLength,set.size());
                set.clear();
                set.add(ch);
            }
        }
        maxLength = Math.max(maxLength,set.size());

        return maxLength;
    }
}
