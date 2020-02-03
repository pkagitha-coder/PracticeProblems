package org.abc;

public class CoinChange {


    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        System.out.println(obj.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(obj.coinChange(new int[]{1, 2, 5}, 11));

    }

    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];

        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    //if j value less than coin value, copy the previous row value.
                    dp[i][j] = Math.min(dp[i - 1][j], Integer.MAX_VALUE);
                } else {
                    if (dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Integer.MAX_VALUE);
                    }
                }
            }
            //   Util.printMatrix(dp);
        }

        //Util.printMatrix(dp);
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }
}
