public class QuickSort {


    private static void quickSort(int[] nums, int start, int end) {
        if( start >= end ) {
            return;
        }

        int partition = partition(nums,start,end);
        quickSort(nums, start, partition - 1);
        quickSort(nums, partition + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1, j = start;

        for(; j <= end - 1; j++ ) {
            if( nums[j] < pivot) {
               i = i + 1;
               swap(nums, i,j);
            } else {
                // Expand the larger aprtion
                j = j+1;
            }
        }

        swap(nums, i+1, end);

        return i+1;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 3, 2, 1, 5};
        QuickSort.quickSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] =  nums[i];
        nums[i] =  temp;
    }
}
