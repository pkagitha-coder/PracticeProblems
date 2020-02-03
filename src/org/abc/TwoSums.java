package org.abc;

import java.util.Arrays;

public class TwoSums {

    public static void main(String[] args) {
        TwoSums obj = new TwoSums();
        Util.printArray(obj.twoSum(new int[]{2,7,11,15},9));
        Util.printArray(obj.twoSum(new int[]{2,7,11,15},18));
        Util.printArray(obj.twoSum(new int[]{2,7,11,15},17));
        Util.printArray(obj.twoSum(new int[]{2,7,11,15},19));
    }

    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++) {
            int i1 = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
            if(i1 > 0) {
                return new int[] {i+1,i1+1};
            }
        }

        return new int[]{-1,-1};
    }

}
