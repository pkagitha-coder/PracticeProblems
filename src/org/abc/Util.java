package org.abc;

import java.util.Collection;

public class Util {
    public static void printMatrix(int[][] matrix) {
        for(int r=0;r<matrix.length;r++) {
            for(int c=0;c<matrix[r].length;c++) {
                System.out.print(matrix[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printList(Collection coll) {
        for(Object obj : coll) {
            System.out.print(obj.toString() + "\t");
        }
        System.out.println();
    }

    public static void printArray(int[] nums) {
        for(int num : nums) {
            System.out.print(num+"\t");
        }
        System.out.println();
    }

    public static void printLinkedList(ListNode list) {

        while(list != null) {
            System.out.print(list.val +" -> ");
            list = list.next;
        }
        System.out.println(" null ");

    }
}
