import java.util.Arrays;

/**
 * Min Steps to mnake number 1. If number is divisible by 2 you can make it n/2
 * If number is divisible by 3 you can make it n/3 Otherwise you can reduce the
 * number by 1 i.e., n-1
 * 
 */

public class StepsToOne {

    int a;
    int b;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static int minSteps(int n) {
        if( n == 1 ){
            return 0;
        }
        int steps = Integer.MAX_VALUE;
        if( n % 2 == 0 ) {
            steps = minSteps(n/2); 
        } else if( n % 3 == 0 ) {
            steps =  minSteps(n/3);
        }
        
        return 1 + Math.min(steps, minSteps(n - 1));
    }
    
    public static int minStepsBU(int n) {
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 0;
        
        for( int i = 2; i <= n; i++ ) {
            int step = Integer.MAX_VALUE;
            if(i % 2 == 0 ) {
                step = steps[i / 2];
            } else if (i % 3 == 0 ) {
                step = steps[i / 3];
            } 
            
            steps[i] = 1 + Math.min(step, steps[i - 1]);
        }
        
        return steps[n];
        
    }
    
    public static int minStepsTD(int n, int[] memo) {
        if( n == 1 ){
            return 0;
        }
        
        if( memo[n] != -1 ) {
            return memo[n];
        } 
        int steps = Integer.MAX_VALUE;
        if( n % 2 == 0 ) {
            steps =  minStepsTD(n/2, memo); 
        } else if( n % 3 == 0 ) {
            steps =  minStepsTD(n/3, memo);
        }
        
        return memo[n] = 1 + Math.min(steps, minStepsTD(n - 1, memo));
        
    }
    
    public static void main(String[] args) {
        int n = 9;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(StepsToOne.minSteps(n));
        System.out.println(StepsToOne.minStepsTD(n, memo));
        System.out.println(StepsToOne.minStepsBU(n));
    }
}