package org.abc;

public class MinBribes {

    public static void main(String[] args) {

       int[] q = {2, 1, 5, 3, 4};

        minimumBribes(q);
        q = new int[] {2, 5, 1, 3, 4};

       minimumBribes(q);
         q = new int[]{1, 2, 5, 3, 4, 7, 8, 6};

       minimumBribes(q);
    }

    static void minimumBribes(int[] q) {
        int swap = 0;

        for(int i=q.length-1;i>=0;i--) {
            if(q[i] != i+1) {
                if(((i-1)>=0) && q[i-1] == (i+1)) {
                    swap++;
                    swap(q,i-1,i);
                }else if((i-2)>0 && q[i-2] == (i+1)) {
                    swap+=2;
                    swap(q,i-1,i-2);
                    swap(q,i-1,i);
                }else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swap);

    }

    private static void swap(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
    }

}
