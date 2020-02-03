package org.abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
    public static void main(String[] args) {
        final int[] intersect = intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        for (int i : intersect) {
            System.out.print(i + "\t");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {


        Arrays.sort(nums2);

        int[] bigArray = null;
        int[] smallArray = null;

        if (nums1.length > nums2.length) {
            bigArray = nums1;
            smallArray = nums2;
        } else {
            bigArray = nums2;
            smallArray = nums1;
        }
        /*List<Integer> result = new ArrayList<>();
        int i=0,j=0;
        while(i < bigArray.length && j< smallArray.length) {
            while(bigArray[i] < smallArray[j]) {
                i++;
            }
            if(bigArray[i] == smallArray[j]) {
                result.add(smallArray[j++]);
            }
        }*/

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<smallArray.length;i++) {
            final int findIndex = Arrays.binarySearch(bigArray, 0, bigArray.length, smallArray[i]);
            if(findIndex >= 0) {
                result.add(smallArray[i]);
                bigArray[findIndex] = Integer.MIN_VALUE;
            }
        }

        int[] resultArr = new int[result.size()];

        int k = 0;
        for (int num : result) {
            resultArr[k++] = num;
        }

        return resultArr;
    }
}

