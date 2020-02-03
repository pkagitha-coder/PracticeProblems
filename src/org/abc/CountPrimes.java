package org.abc;

import java.util.Arrays;

public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes obj = new CountPrimes();
        System.out.println(obj.countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean primes[] = new boolean[n + 1];
        Arrays.fill(primes, true);

        int ub = (int) Math.sqrt(n);
        for (int i = 2; i <= ub; i++) {
            for (int j = i + i; j <= n; j += i) {
                primes[j] = false;
            }
        }
          int result = 0;
        for(int i=2;i<=n;i++) {
            if(primes[i])
                result++;
        }

        return result;
    }
}
