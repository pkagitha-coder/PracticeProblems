package org.abc;

public class RotateArray {

    public static void main(String[] args) {
        Util.printArray(rotLeft(new int[]{1,2,3,4,5},2));
    }

    static int[] rotLeft(int[] a, int d) {
        reverse(a,0,d-1);
        reverse(a,d,a.length-1);
        reverse(a,0,a.length-1);

        return a;
    }

    static void reverse(int[] a,int startIndex, int endIndex) {
        int len = (endIndex - startIndex +1)/2;
        for(int i=0;i<len;i++) {
            int tmp = a[startIndex];
            a[startIndex] = a[endIndex];
            a[endIndex] = tmp;
            startIndex++;
            endIndex--;
        }
    }

}
