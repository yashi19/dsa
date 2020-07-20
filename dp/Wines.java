
// Max Profit by selling wines 
// Prices of wine = year * price[wine]
public class Wines {
    
    
    public static int  maxProfitTD(int[] prices, int start, int end, int[][] memo) {
        if( start == end ) {
            return prices[start] * prices.length;
        }
        
        if( memo[start][end] != -1 ) {
            return memo[start][end];
        }
       
        int year = prices.length - (end - start);
        int ans1 = year * prices[start] + maxProfitTD(prices, start + 1, end, memo);
        int ans2 = year * prices[end] + maxProfitTD(prices, start, end - 1, memo);
        
        return memo[start][end] = Math.max(ans1, ans2);
    }
    
    public static int maxProfit(int[] prices, int start, int end) {
        if( start == end ) {
            return prices[start] * prices.length;
        }
        
        int year = prices.length - (end - start);
        int ans1 = year * prices[start] + maxProfit(prices, start + 1, end);
        int ans2 = year * prices[end] + maxProfit(prices, start, end - 1);
        
        return Math.max(ans1, ans2);
    }
    
    public static void main(String[] args) {
        int[] prices = new int[] {2,3,5,1,4};
        System.out.println(Wines.maxProfit(prices, 0, prices.length - 1));
        
        int[][] memo = new int[prices.length][prices.length];
        for(int i = 0; i < prices.length; i++){
             for(int j = 0; j < prices.length; j++){
                memo[i][j] = -1;
            }
        }
        
        System.out.println(Wines.maxProfitTD(prices, 0, prices.length - 1, memo));
        
    }
}