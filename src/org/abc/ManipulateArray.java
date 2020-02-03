package org.abc;

public class ManipulateArray {
    public static void main(String[] args) {
        int[][] queries = {
                {19,28,419},
               {4,23,680},
               {5, 6,907},
                {19, 33, 582},
                {5, 9, 880},
                {10, 13, 438},
                {21, 39, 294},
                {13, 18, 678},
                {12, 26, 528},
                {15, 30, 261},
                {8, 9, 48},
                {21, 23, 131},
                {20, 21, 7},
                {13, 40, 65},
                {13, 23, 901},
                {15, 15, 914},
                        {14, 35, 704},
                {20, 39, 522},
                {10, 18, 379},
                {16, 27, 8},
                {25, 40, 536},
                {5, 9, 190},
                {17, 20, 809},
                {8, 20, 453},
                {22, 37, 298},
                {19, 37, 112},
                {2, 5, 186},
                {21, 29, 184},
                {23, 30, 625},
                {2, 8, 960},
                };

        System.out.println(arrayManipulation(40, queries));
    }

    static long arrayManipulation(int n, int[][] queries) {
        int[] outputArray = new int[n+2];

        for(int i=0;i<queries.length;i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            int k = queries[i][2];

            outputArray[startIndex] += k;
            outputArray[endIndex+1] = outputArray[endIndex+1] - k;
        }

        long max = Long.MIN_VALUE;
        for(int i=1;i<outputArray.length;i++) {
            outputArray[i] += outputArray[i-1];
            max = Math.max(max,outputArray[i]);
        }

        return max;

    }

}
