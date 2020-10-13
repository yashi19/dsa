public class InversionCounts {

    public static void main(String[] args) {
        int[] nums = new int[]{8, 4, 2, 1};
        int counts = InversionCounts.inversionCounts(nums, 0, nums.length - 1);

        System.out.print(counts + " ");
    }

    private static int inversionCounts(int[] nums, int start, int end) {

        if( start >=  end) {
            return 0;
        }
        int mid = (end+start)/2;
        int x = inversionCounts(nums, start, mid);
        int y = inversionCounts(nums, mid+1, end);
        int crossInversions = merge(nums, start,end);
        return x+y+crossInversions;
    }
   // {3, 5,6 ,| 1, 2, 5}
    private static int merge(int[] nums, int start, int end) {
        int mid = (end+start)/2;
        int i = start, j = mid+1, k = 0;
        int[] temp = new int[end - start +1];
        int count = 0;

        while( i <= mid && j <= end ) {
            if( nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                count += (mid - i + 1);
                temp[k++] = nums[j++];
            }
        }

        while( i <= mid ) {
            temp[k++] = nums[i++];
        }

        while( j <= end ) {
            temp[k++] = nums[j++];
        }

        i = 0;
        while( i < temp.length){
            nums[start++] = temp[i++];
        }
        return count;
    }
}
