import java.util.PriorityQueue;

public class HeapQues {

    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((rope1, rope2) -> rope1 - rope2);
        for( int rope : ropes ) {
            minHeap.add(rope);
        } 
        int cost = 0;
        while( !minHeap.isEmpty() ) {
            int firstMin = minHeap.remove();
            int secondMin = minHeap.remove();
            cost += firstMin + secondMin;
            if( !minHeap.isEmpty() )
                minHeap.add(firstMin + secondMin);
        }

        return cost;
    }

    public static int kSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((num1, num2) -> num2 - num1);
        // O(k)
        for( int i = 0; i < k; i++ ) {
            maxHeap.add(nums[i]);
        }
        // O( (n - k) (logk) )
        for( int i = k ; i < nums.length; i++ ) {
            if( nums[i] < maxHeap.peek() ) {
                maxHeap.remove();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.remove();
    }

    public static void main(String[] args) {
        int[] ropes = new int[] {8, 4, 6, 12};
        System.out.println("Minimum cost:");
        System.out.println(HeapQues.minCost(ropes));
        System.out.println("K Smallest:");
        System.out.println(HeapQues.kSmallest(ropes,3));
    }
}