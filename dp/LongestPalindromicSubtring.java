import java.io.*;
import java.lang.annotation.Annotation;

public class LongestPalindromicSubtring implements Serializable {

    int b = 10;
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";

        System.out.println(LongestPalindromicSubtring.lps(s));
        String first = "Baeldung";
        String second = "Baeldung";
        System.out.println(first == second);
        String third = second;
        System.out.println(first == third);
    }


    FunctionalInterface a = new FunctionalInterface() {
        int c  = 10;
       public static final int a =10;

        @Override
        public Class<? extends Annotation> annotationType() {
            b = 20;
            int c = 30;
            return null;
        }
    };

    private static int lps(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLenght = 1;
        // One character word is always palindrome
        for( int i = 0; i < n; i++) {
           dp[i][i] = true;
           start = i;
        }
        // Checking for two character word
        for( int i = 0 ; i < n - 1; i++ ){
            if( s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLenght = 2;
            }
        }
        for( int k = 3; k <= n ; k++) {
            for( int i = 0; i <= n - k; i++ ) {
                int j = i + k  - 1;

                if( dp[i+1][j-1] && s.charAt(i) == s.charAt(j) ) {
                   dp[i][j] = true;
                   if( maxLenght < k ) {
                       maxLenght = k;
                       start = i;
                   }
                }
            }
        }

        return maxLenght;
    }
}
