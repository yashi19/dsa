public class StringQues {
    //Number of flips to make binary string alternate
    public static int flip(String s) {
        int n = s.length();
        if( n <= 1 ) {
            return 0;
        }
        int flips = flip(s,0,n);
        return Math.min(flips, n - flips);
    }

    private static int flip(String s, int expected, int n) {
        int flips = 0;
        for( int i = 0; i < n; i++ ) {
            char currentDigit = s.charAt(i);
            if( Integer.parseInt(String.valueOf(currentDigit)) != expected ) {
                flips++;
            }
            expected = 1 - expected;
        }

        return flips;
    }

    //Minimum swaps required to make a binary string alternating
    public static int minSwaps(String s) {
        int oddZero = 0, evenZero = 0, evenOne = 0, oddOne = 0;
        int n = s.length();
        for( int i = 0; i < n; i++ ) {
            char digit = s.charAt(i);
            if( i % 2 == 0 ) {
               if(  digit == '0') {
                   evenZero++;
               } else {
                   evenOne++;
               }
            } else {
                if(  digit == '0') {
                    oddZero++;
                } else {
                    oddOne++;
                }
            }
        }
        // If string starts with zero then (evenZero+oddOne) positions are correct. So Len - (evenZero+oddOne) are not correct positions
        // So Len - (evenZero+oddOne) / 2 wil give us minimum no of swaps
        int minSwapsWith0 = (n - (evenZero+oddOne) ) / 2;
        int minSwapsWith1 = (n - (evenOne+oddZero) ) / 2;
        return Math.min(minSwapsWith0,minSwapsWith1);
//        return Math.min(Math.min(evenZero,oddOne),Math.min(evenOne,oddZero));
    }

    //Minimum Count of Bit flips required to make a Binary String Palindromic
    public static int minFlipPalindrome(int n) {
        String binary = decimalToBinary(n);
        int len = binary.length();
        int start = 0, end = len - 1;
        int flips = 0;
        while( start < end ) {
            if( binary.charAt(start++) != binary.charAt(end--) ) {
                flips++;
            }
        }
        return flips;
    }

    private static String decimalToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while ( n > 0 ) {
            sb.append(n & 1);
            n = n >> 1;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "0001010111";

        System.out.println(StringQues.flip(s));
        System.out.println(StringQues.minSwaps("00001111010101"));
        System.out.println(StringQues.minFlipPalindrome(10));
        System.out.println(StringQues.compress("EABABCABABCD"));

    }

    public static String compress(String str){

        int i = 0;
        int n = str.length();
        String ans = "";
        while(n>0){
            if(n%2==0&&str.substring(i,n/2).equals(str.substring(n/2,n))){
                ans = compress(str.substring(i,n/2))+"*"+ans;
                break;
            }
            else{
                ans = str.substring(n-1,n)+ans;
                n--;
            }
        }

        return ans;
    }
}
