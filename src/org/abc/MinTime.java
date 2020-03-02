package org.abc;

import java.math.BigDecimal;
import java.util.Arrays;

public class MinTime {

    public static void main(String[] args) {
        /*System.out.println(minTime(new long[]{2, 3}, 5));
        System.out.println(minTime(new long[]{2, 3}, 4));
        System.out.println(minTime(new long[]{2, 3}, 9));*/

        long[] machines = new long[]{2,3};
        for(int i=1;i<30;i++) {
            System.out.println(i+ " ===> "+ minTime(machines,i));
        }
        //System.out.println(minTime(new long[]{2,3},24));

        /*System.out.println(minTime(new long[]{4,5,6}, 12));
        System.out.println(minTime(new long[]{1,3,4}, 10));*/
    }

    static long minTime(long[] machines, long goal) {
       long min = Long.MAX_VALUE;
       long max = Long.MIN_VALUE;
       for(long machine: machines) {
          min = Math.min(min,machine);
          max = Math.max(max,machine);
       }
       long low = (goal*min)/machines.length;
       long high = (goal*max)/machines.length;

        long[] result = new long[2];
       while(low <= high) {
           long mid = (low+high)>>>1;

           getNumItemsProduceForGivenDay(mid, machines,result);

           if(goal > result[0]) {
               low = mid+1;
           }else if(goal < result[0]) {
               high = mid-1;
           }else {
               return result[1];
           }
       }

       if(result[0]> goal) {
           return result[1];
       }else {
           getNumItemsProduceForGivenDay(low,machines,result);
           return result[1];
       }

    }

    private static void getNumItemsProduceForGivenDay(long day, long[] machines,long[] result) {
        long minDaysBack = Long.MAX_VALUE;
        result[0] = 0;
        for(long machine: machines) {
            result[0] = result[0] + (day/machine);
            minDaysBack = Math.min(minDaysBack, day%machine);
        }
        result[1] = day - minDaysBack;
    }
}
