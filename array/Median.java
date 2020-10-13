import java.util.HashMap;
import java.util.Map;

public class Median {

    private static double median(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        //A = x1, x2, x3 ,x4,| x5, x6, x7
        //B = y1, y2, y3, y4,| y5, y6, y7
        int start = 0, end = n-1;
        while( start <= end ) {
            int partitionA = (end+start)/2;
            int partitionB = (n+m+1)/2 -  partitionA;

            int maxLeftA = partitionA - 1 < 0 ? Integer.MIN_VALUE : a[partitionA - 1];
            int minRightA = partitionA  ==  n ? Integer.MAX_VALUE : a[partitionA];
            int maxLeftB = partitionB - 1 < 0 ? Integer.MIN_VALUE: b[ partitionB - 1];
            int minRightB = partitionB  ==  m ? Integer.MAX_VALUE :  b[partitionB];

            if(maxLeftA <= minRightB && maxLeftB <= minRightA ) {
                if( (n + m) % 2 == 0 ) {
                    return  ( (double) (Math.max(maxLeftA,maxLeftB) +  Math.min(minRightA,minRightB)) ) / (double)2;
                } else {
                    return (double) Math.max(maxLeftA,maxLeftB);
                }
            }

            else if ( maxLeftA > minRightB ) {
                end = partitionA - 1;

            } else {
                start = partitionA + 1;
            }
        }

        if( start == n ) {
            int partitionA = start;
            int partitionB = (n + m + 1 )/ 2 - partitionA;

            int leftMaxA = partitionA - 1 < 0 ? Integer.MIN_VALUE : a[partitionA - 1];//3
            int rightMinA = partitionA == n ? Integer.MAX_VALUE: a[partitionA]; // +infi
            int leftMaxB = partitionB - 1 < 0 ? Integer.MIN_VALUE : b[partitionB - 1];
            int rightMinB =  partitionB == m ? Integer.MAX_VALUE: b[partitionB];


            if( leftMaxA <= rightMinB && leftMaxB <= rightMinA ) {
                if( (n + m) % 2 == 0 ) {
                    return (double) (Math.max(leftMaxA,leftMaxB) + Math.min( rightMinA,rightMinB) ) / 2;
                } else {
                    return (double) Math.max(leftMaxA,leftMaxB);
                }
            }
        }

        return -1.0;
    }

    public static void main(String[] args) {
        int[] b = new int[] {1,2,3};
        int[] a = new int[] {5,6,7,8,9,10,12,14,16};

        if( a.length < b.length) {
            System.out.println(Median.median(a,b));
        } else {
            System.out.println(Median.median(b,a));
        }

        Map<String, String> map = new HashMap<>();

        map.put("yashika","yashika");
        StringBuilder sb = new StringBuilder("yashika");

        System.out.println(map.containsKey(sb.toString()));


    }
}

