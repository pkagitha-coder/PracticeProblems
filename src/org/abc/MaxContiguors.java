package org.abc;

public class MaxContiguors {

    public static void main(String[] args) {
        MaxContiguors obj = new MaxContiguors();
        System.out.println(obj.maxSubArray(new int[]{-1}));
    }

    public int maxSubArray(int[] nums) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for(int num : nums) {
            maxEndingHere +=num;
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;

    }


}
