import java.util.Arrays;

public class Coins {
    
    public static int minCoinsBU(int amount, int[] coins) {
        if( amount == 0 ) {
            return 0;
        }
        
        int[] minCoins = new int[amount + 1];
        minCoins[0] = 0;
        
        for( int i = 1; i <= amount; i++ ) {
             minCoins[i] = Integer.MAX_VALUE;
            for( int j = 0; j < coins.length; j++ ) {
                if( i - coins[j] >= 0 ) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }
        
        return minCoins[amount];
    }
    
    public static int minCoinsTD(int amount, int[] coins, int[] memo) {
        if( amount == 0 ) {
            return 0;
        }
        if( memo[amount] != -1 ) {
            return memo[amount];
        }
        
        int minCoins = Integer.MAX_VALUE;
        for( int i = 0; i < coins.length; i++ ) {
            if( amount - coins[i] >= 0 ) {
                minCoins = Math.min(minCoins, 1 + minCoinsTD(amount - coins[i], coins, memo));
            }
        }
        
        return memo[amount] = minCoins;
    }
    
    public static int minCoins(int amount, int[] coins) {
        if( amount == 0 ) {
            return 0;
        }
        
        int minCoins = Integer.MAX_VALUE;
        for( int i = 0; i < coins.length; i++ ) {
            if( amount - coins[i] >= 0 ) {
                minCoins = Math.min(minCoins, 1 + minCoins(amount - coins[i], coins));
            }
        }
        
        return minCoins;
    }
    
    public static void main(String[] args) {
        int[] coins = new int[] {1,7,10};
        int amount = 15;
        System.out.println(Coins.minCoins(amount, coins));
        
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        System.out.println(Coins.minCoinsTD(amount, coins, memo));
        
        System.out.println(Coins.minCoinsBU(amount, coins));
    }
}