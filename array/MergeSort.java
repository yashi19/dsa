public class MergeSort {

    private static void mergeSort(int[] nums, int start, int end) {
            // Base Condition one element left or zero element
        if( start >= end ) {
            return;
        }

        int mid = (end+start)/2;

        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums,start,end);

    }

    private static void merge(int[] nums, int start, int end) {
        int mid = (end+start)/2;
        int[] temp = new int[end - start + 1];
        int k = 0, i = start, j = mid+1;

        while( i <= mid && j <= end ) {

            if( nums[i] < nums[j] ) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = nums[i++];
        }

        while( j <= end ) {
            temp[k++] = nums[j++];
        }

        i = 0;
        while( i < temp.length){
            nums[start++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 3, 2, 1, 5};
        MergeSort.mergeSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


}
