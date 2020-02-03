package org.abc;

public class MinSwaps {

    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{7,1,6,4,2,5,3}));
        System.out.println(minSwaps(new int[]{1,2,3,4,5,6,7}));
        System.out.println(minSwaps(new int[]{1,2,3,4,5,7,6}));
    }

    private static int minSwaps(int[] a) {
        boolean[] b = new boolean[a.length];

        int total = 0;
        for(int i=0;i<a.length;i++) {
            if(b[a[i]-1] || a[i] == (i+1)) {
                continue;
            }

            int j = i;
            int cycle = 0;
            while(!b[a[j]-1]) {
                b[a[j]-1] = true;
                j = a[j]-1;
                cycle++;
            }
            total+=(cycle-1);
        }

        return total;
    }
}
