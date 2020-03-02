package org.abc;

import java.math.BigInteger;

public class MakeCandiesBigInteger {

    private static final BigInteger BIG_2 = BigInteger.valueOf(2);

    public static void main(String[] args) {
        System.out.println(minimumPasses(3,13,13,1000000000000l));
        System.out.println(minimumPasses(1,1,6,45));

    }

    static long minimumPasses(long m, long w, long p, long n) {
        BigInteger[] config = new BigInteger[] {BigInteger.valueOf(m),BigInteger.valueOf(w),BigInteger.ZERO,BigInteger.ONE};
        config[2] = config[1].multiply(config[0]);


        Util.printArray(config);
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigP = BigInteger.valueOf(p);
        while(config[2].compareTo(bigN) < 0) {
            reconfigureIfAndMake(config,bigN,bigP);
            Util.printArray(config);
        }
        return config[3].longValue();
    }

    static void reconfigureIfAndMake(BigInteger[] config,BigInteger n,BigInteger p) {
        BigInteger noOfResCanBeAdded = config[2].divide(p);
        BigInteger remainingCandies = n.subtract(config[2]);
        if(noOfResCanBeAdded.compareTo(BigInteger.ZERO) > 0) {
            BigInteger noOfIterToRecoverP = p.divide(config[0].compareTo(config[1])>0?config[0]:config[1]);
            BigInteger remainingIterWithCurrentCfg = remainingCandies.divide((config[0].multiply(config[1])));

            if(noOfIterToRecoverP.compareTo(remainingIterWithCurrentCfg)<0) {
                reconfigure(config,noOfResCanBeAdded,p);
            }
        }
        BigInteger perIter = config[0].multiply(config[1]);
        BigInteger skipIter = ((p.subtract(config[2]).compareTo(n.subtract(config[2])) < 0 ? p.subtract(config[2]) : n.subtract(config[2])).divide(perIter));
        skipIter = skipIter.compareTo(BigInteger.ZERO) == 0 ? BigInteger.ONE : skipIter;
        config[2] = config[2].add(perIter.multiply(skipIter));
        config[3] = config[3].add(skipIter);
    }

    static void reconfigure(BigInteger[] config,BigInteger noOfRes, BigInteger p) {
        BigInteger delta = BigInteger.ZERO;
        if(config[0].compareTo(config[1])<0) {
            config[0]=config[0].add(noOfRes);
            delta = config[1].subtract(config[0]);
        }else {
            config[1]=config[1].add(noOfRes);
            delta = config[0].subtract(config[1]);
        }

        if(delta.compareTo(BigInteger.ZERO) < 0) {
            BigInteger sum = config[0].add(config[1]);
            config[0] = sum.divide(BIG_2).add(sum.mod(BIG_2));
            config[1] = sum.divide(BIG_2);
        }
        config[2] = config[2].subtract((noOfRes.multiply(p)));
    }
}
