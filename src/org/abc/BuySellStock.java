package org.abc;

public class BuySellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {2,7,3,5,9}));
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[] {1,2,3,4,5}));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
    }

    private static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int transactions = prices.length/2;
        int[][] profits = new int[transactions+1][prices.length];

        //fill rows for zero transactions
        for(int c=0;c<profits[0].length;c++) {
            profits[0][c] = 0;
        }

        //fill rows for day one, which will be zero, only buying stock
        for(int r=0;r<profits.length;r++) {
            profits[r][0] = 0;
        }
        //Util.printMatrix(profits);
        for(int t=1;t<profits.length;t++) {
            int maxPrevProfit = Integer.MIN_VALUE;
            for(int d=1;d<prices.length;d++) {
                maxPrevProfit = Math.max(maxPrevProfit,profits[t-1][d-1]-prices[d-1]);
                profits[t][d] = Math.max(profits[t][d-1],prices[d]+ maxPrevProfit);
                //Util.printMatrix(profits);
            }
        }

        return profits[transactions][prices.length-1];
    }
}
