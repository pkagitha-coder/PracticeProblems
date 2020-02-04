package org.abc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DistinctTriplets {

    private static final Scanner scanner = new Scanner(DistinctTriplets.class.getResourceAsStream("/triplets_case_04.txt"));

    public static void main(String[] args) throws Exception {

        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static long triplets(int[] a, int[] b, int[] c) {
        a = sortAndRemoveDups(a);
        b = sortAndRemoveDups(b);
        c = sortAndRemoveDups(c);

        int aCurrIndex = 0;
        int cCurrIndex = 0;

        long distinctTriplets = 0;
        for (int i = 0; i < b.length; i++) {
            aCurrIndex = findIndex(a, aCurrIndex, b[i]);
            cCurrIndex = findIndex(c, cCurrIndex, b[i]);

            if (aCurrIndex == 0 || cCurrIndex == 0) {
                continue;
            }
            //System.out.println(distinctTriplets);
            distinctTriplets += ((long)aCurrIndex) * ((long)cCurrIndex);
        }

        return distinctTriplets;

    }

    static int findIndex(int[] a, int aCurrIndex, int b) {
        while (aCurrIndex < a.length && a[aCurrIndex] <= b) {
            aCurrIndex++;
        }
        return (aCurrIndex);
    }

    static int[] sortAndRemoveDups(int a[]) {
        Set<Integer> sortedSet = new TreeSet<>();
        for (int n : a) {
            sortedSet.add(n);
        }

        return sortedSet.stream().mapToInt(i -> i).toArray();
    }
}
