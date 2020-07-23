import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* 
Count of prime factors of n to be added at each step to convert n to m.
Example for 216 we have two prime factors 2 and 3
    So, Either we can add 12 or 3 in 216.
    216 + 2 = 218    |   216 + 3 = 219
    218 + 2 = 220    |   
*/
public class PrimeBFS {

    public static int[] primeFactorTill(int n) {
        boolean[] primes = new boolean[n+1];
        int[] primeFactors = new int[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for( int number = 2; number <= n; number++ ) {
            if( primes[number] ) {
                primeFactors[number] = number;
                for( int multiples =  number * 2; multiples <= n; multiples+=number) {
                    primeFactors[multiples] = number;
                    primes[multiples] = false;
                }
            }
        }

        return primeFactors;
    }

    public static Set<Integer> primeFactorsFor(int n, int[] primeFactors) {
        Set<Integer> set = new HashSet<>();
        while( n != 1) {
            int primeFactor = primeFactors[n];
            set.add(primeFactor);
            n = n / primeFactor;
        }        
        return set;
    }

    public static int minCount(int src, int dest) {
        int[] primeFactors = PrimeBFS.primeFactorTill(100000);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int count = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while(size > 0) {
                int n = queue.remove();
                Set<Integer> primes = primeFactorsFor(n, primeFactors);
                
                for( int prime : primes ) {
                    int number = n + prime;
                    if( number == dest ) {
                       return count;
                    }
                    if( number < dest ) {
                        queue.add(number);
                    }
                    
                }
                size--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(PrimeBFS.minCount(216, 221));
    }
}