import java.util.Arrays;

public class Partition {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 1, 5, 9, 12};
        System.out.println(Partition.twoEqualSumSubset(nums));
    }

    private static int twoEqualSumSubset(int[] nums) {
        int sum = 0;
        for( int num : nums ) {
            sum+=num;
        }

        if( sum % 2 != 0 ) {
            return 0;
        }
        int[][] memo = new int[sum+1][nums.length];
        for( int[] A : memo ) {
            Arrays.fill(A,-1);
        }
        return isSubsetPartitionPossible(nums, sum/2, nums.length - 1, memo);
    }

    private static int isSubsetPartitionPossible(int[] nums, int sum, int index, int[][] memo) {
        if( index < 0 ) {
            return 0;
        }
        if( sum == 0 ) {
            return 1;
        }
        if( memo[sum][index] != -1  ){
            return memo[sum][index];
        }
        int possible = 0;
        if( nums[index] <=  sum ) {
            possible = isSubsetPartitionPossible(nums, sum - nums[index] , index - 1,memo);
        }

        return memo[sum][index] = possible | isSubsetPartitionPossible(nums, sum , index - 1,memo);

    }
}
