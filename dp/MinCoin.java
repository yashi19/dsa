import java.util.Arrays;

public class MinCoin {
    public static int minCoinsBU(int amount, int[] coins) {
        if( amount == 0 ) {
            return 0;
        }
       int[] dp = new int[amount+1];
       dp[0] = 0;
       
       for( int i = 1; i < dp.length; i++ ) {
            dp[i] = Integer.MAX_VALUE;
           for( int k = 0; i < coins.length; k++ ) {
                if( coins[k] <= i ) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[k]]);
                }
           }
       }

       return dp[amount];
    }
    
    public static int minCoinsTD(int amount, int[] coins, int[] memo) {
        if( amount == 0 ) {
            return 0;
        }
        if( memo[amount] != -1 ) {
            return amount;
        }
        int noOfCoins = Integer.MAX_VALUE;
        for( int i = 0 ; i < coins.length; i++ ) {
 
            if( coins[i] <= amount ) {
                noOfCoins = Math.min(noOfCoins, 1 + minCoinsTD(amount - coins[i],coins, memo));
            }
        }
        return memo[amount] = noOfCoins;
    }
    
    public static int minCoins(int amount, int[] coins) {
       if( amount == 0 ) {
           return 0;
       }
       int noOfCoins = Integer.MAX_VALUE;
       for( int i = 0 ; i < coins.length; i++ ) {
           if( coins[i] <= amount ) {
               noOfCoins = Math.min(noOfCoins, 1 + minCoins(amount - coins[i],coins));
           }
       }
       return noOfCoins;
    }
    
    public static void main(String[] args) {
        int[] coins = new int[] {1,7,10};
        int amount = 76;
        System.out.println(Coins.minCoins(amount, coins));
        
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        System.out.println(Coins.minCoinsTD(amount, coins, memo));
        
        System.out.println(Coins.minCoinsBU(amount, coins));
    }
}