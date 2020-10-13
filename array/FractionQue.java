
public class FractionQue {
    //https://www.geeksforgeeks.org/program-to-add-two-fractions/
    public static void addFraction(int num1, int deno1, int num2, int deno2) {
        int gcd = gcd(deno1,deno2);
        int deno = deno1 * deno2 / gcd;

        int num = (num1 * deno/deno1) + ( num2 * deno/deno2);

        simplest(num,deno);
    }

    private static void simplest(int num, int deno ) {
        int gcd = gcd(num, deno);
        System.out.println(num/gcd + "/" + deno/gcd);
    }

    private static int gcd(int a, int b) {
        if( a == 0 ) {
            return b;
        }
        if( b== 0 ) {
            return a;
        }
        if ( a == b ) {
            return a;
        }
        if( a > b ) {
            return gcd( a - b , b);
        }

        return gcd(a, b - a);

    }

    //Find the smallest positive number missing from an unsorted array
    //Input:  {2, 3, 7, 6, 8, -1, -10, 15}
    // Output: 1

    public static int smallestPositive(int[] nums) {
        int end = nums.length - 1;
        int start = 0;

        // Seggregating positive and negative numbers
        while( start < end ) {
            while( nums[end] < 0 ) {
                end--;
            }

            while( nums[start] >= 0 ) {
                start++;
            }

            if( start < end ) {
                int temp = nums[end];
                nums[end] =  nums[start];
                nums[start] = temp;
            }

        }

        for( int i = 0; i < nums.length; i++ ) {
            if( nums[i] > 0 &&  nums[i] < nums.length) {
                nums[nums[i]] =  -nums[nums[i]];
            }
        }

        for( int i = 1 ; i < nums.length; i++ ) {
            if( nums[i] >= 0 ) {
                return i;
            }
        }

        return  nums.length ;

    }

    public static void main(String[] args) {
        FractionQue.addFraction(1,5,3,15);
        int[] nums = new int[] {2, 3, -7, 6, 8, 1, -10, 15 };
        System.out.println(FractionQue.smallestPositive(nums));

    }
}
