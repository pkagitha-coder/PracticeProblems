package org.abc;

import java.math.BigInteger;

public class Fibb {

    public static void main(String[] args) {
        Fibb obj = new Fibb();
        for(int i=0;i<=100;i++) {
            System.out.print(obj.fibonacci(i)+", ");
        }

        //0,1,1,2,3,5,8,12


    }

    BigInteger fibonacci(int n) {
        BigInteger f0 = new BigInteger("0");
        BigInteger f1 = new BigInteger("1");
        BigInteger nextFib = BigInteger.valueOf(0);

        if(n <= 1) {
            return BigInteger.valueOf(n);
        }

        for(int i=2;i<=n;i++) {
            nextFib = BigInteger.valueOf(0);
            nextFib = nextFib.add(f0) ;
            nextFib = nextFib.add(f1);
            f0 = f1;
            f1=nextFib;
        }

        return nextFib;
    }
}
