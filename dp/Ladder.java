import java.util.Arrays;

public class Ladder {

    public static int waysToReachTopBU(int n, int steps) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        //O(n * steps)

        for( int i = 1; i < dp.length; i++ ) {
            for( int k = 1; k <= steps; k++) {
                if( i - k >= 0) {
                    dp[i] = dp[i] + dp[i - k];
                }
            }
        }
        return dp[n];
    }

    public static int waysToReachTop(int n, int steps) {
        if( n == 0 ){
            return 1;
        }
         
        int ways = 0;
        for( int step = 1; step <= steps ; step++ ) {
            if( n - step >= 0 ){
               ways += waysToReachTop(n - step, steps); 
            }
        }
        
        return ways;
    }

    public static int waysToReachTopTD(int n, int steps, int[] memo) {
        if( n == 0 ){
            return 1;
        }

        if(memo[n] != -1){
            return  memo[n];
        }
         
        int ways = 0;
        for( int step = 1; step <= steps ; step++ ) {
            if( n - step >= 0 ){
               ways += waysToReachTop(n - step, steps); 
            }
        }
        
        return  memo[n] = ways;
    }
    
    public static void main(String[] args) {
        int n = 5, k = 3;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        
         System.out.println(Ladder.waysToReachTop(n,k));
         System.out.println(Ladder.waysToReachTopTD(n,k, memo));
        System.out.println(Ladder.waysToReachTopBU(n,k));
        
    }
    
}