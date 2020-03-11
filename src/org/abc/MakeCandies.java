package org.abc;

public class MakeCandies {

    public static void main(String[] args) {
        //System.out.println(minimumPasses(1,1,6,45));
        //System.out.println(minimumPasses(3,1,2,12));
        //System.out.println(1000000000000l);
        //System.out.println(minimumPasses(3,13,13,1000000000000l)); //3 13 13 1000000000000
        //System.out.println(minimumPasses(1,1,499999999999l,1000000000000l)); //1 1 499999999999 1000000000000

        //System.out.println(minimumPasses(4294967296l, 4294967296l, 1000000000l, 10000000000l)); //4294967296 4294967296 1000000000 10000000000

        System.out.println(minimumPasses(5361, 3918, 8447708, 989936375520l)); //5361 3918 8447708 989936375520 => 3577

        //System.out.println(989936375520l - 989897931048l);
    }

    static long minimumPasses(long m, long w, long p, long n) {
        try {
            long[] config = new long[]{m, w, 0, 1};
            config[2] = Math.multiplyExact(config[1], config[0]);

            Util.printArray(config);
            while (config[2] < n) {
                if(config[3] ==3503) {
                    System.out.println("Debug zone");
                }
                reconfigureIfAndMake(config, n, p);
                Util.printArray(config);
                //config[3]++;
            }
            return config[3];
        }catch (ArithmeticException ae) {
            return 1;
        }
    }

    static void reconfigureIfAndMake(long[] config,long n,long p) {
        try {
            long noOfResCanBeAdded = config[2] / p;
            long perIter = Math.multiplyExact(config[0], config[1]);
            if (noOfResCanBeAdded > 0) {
                long noOfIterToRecoverP = p / Math.max(config[0], config[1]);
                long remainingIterWithCurrentCfg = (n - config[2]) / perIter;

                if (noOfIterToRecoverP < remainingIterWithCurrentCfg) {
                    reconfigure(config, noOfResCanBeAdded, p);
                   /* long iter = (p - config[2]) / Math.multiplyExact(config[0], config[1]);
                    forwardIter(config,iter);*/
                }else {
                    /*forwardIter(config,remainingIterWithCurrentCfg);*/
                }
                forwardIter(config,1);
            } else {
                /*long skipIters = Math.min(p - config[2], n - config[2]) / perIter;
                forwardIter(config,skipIters);*/
                forwardIter(config,1);
            }
        }catch(ArithmeticException ae) {
            //overflow
            ae.printStackTrace();
            config[3]++;
            config[2] = Long.MAX_VALUE;
        }
    }

    private static void forwardIter(long[] config, long iter) {
        if(iter <=0) {
            iter =1;
        }
        config[2] =Math.addExact(config[2],iter * (Math.multiplyExact(config[0] , config[1])));
        config[3]+=iter;
    }

    static void reconfigure(long[] config,long noOfRes, long p) {
        long delta = 0l;
        if(config[0]<config[1]) {
            config[0]+=noOfRes;
            delta = config[1] - config[0];
        }else {
            config[1]+=noOfRes;
            delta = config[0] - config[1];
        }

        if(delta < 0) {
            long sum = config[0] +config[1];
            config[0] = sum/2 + sum%2;
            config[1] = sum/2;
        }
        config[2] = config[2] - (noOfRes * p);
    }
}
