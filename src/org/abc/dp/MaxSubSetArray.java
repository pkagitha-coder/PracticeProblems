package org.abc.dp;

public class MaxSubSetArray {

    public static void main(String[] args) {
        System.out.println(findMaxSubSetSumRecur(new int[]{3,7,4,6,5},0));
        System.out.println(findMaxSubSetSumRecur(new int[]{-3,7,-4,-6,-5},0));
        System.out.println(findMaxSubSetSum(new int[]{3,7,4,6,5}));
        System.out.println(findMaxSubSetSum(new int[]{-3,7,-4,-6,-5}));
    }

    private static int findMaxSubSetSumRecur(int[] array, int startIndex) {
        if(startIndex >=array.length-1) {
            return 0;
        }
        int max = Math.max(array[startIndex],array[startIndex+1]);
        max = Math.max(max,array[startIndex]+ findMaxSubSetSumRecur(array,startIndex+2));
        max = Math.max(max,array[startIndex+1]+ findMaxSubSetSumRecur(array,startIndex+3));

        return max;
    }

    private static int findMaxSubSetSum(int[] arr) {
        int[] maxArray = new int[arr.length];
        maxArray[0] = arr[0];
        maxArray[1] = Math.max(maxArray[0],arr[1]);

        for(int i=2;i<arr.length;i++) {
            maxArray[i] = arr[i];
            maxArray[i] = Math.max(maxArray[i],maxArray[i-2]+arr[i]);
            maxArray[i] = Math.max(maxArray[i],maxArray[i-1]);
        }

        return maxArray[arr.length -1];
    }


}
