public class Sorting {

    // Selection Sort 6,5,3,2,1,5 -> 1,5,3,2,6,5 -> 1,2,3,5,5,6
    public static void selectionSort(int[] nums) {
        for( int i = 0; i < nums.length - 1; i++ ) {
            int minIndex = i;

            // Find the min index
            for( int j = i; j < nums.length; j++ ) {
                if(nums[minIndex] >  nums[j]) {
                    minIndex = j;
                }
            }

            swap(nums, minIndex, i);

        }
    }

    private static void swap(int[] nums, int minIndex, int i) {
        int temp = nums[minIndex];
        nums[minIndex] =  nums[i];
        nums[i] =  temp;
    }

    // Insertion sort
    private static void insertionSort(int[] nums) {
        for( int i = 1; i < nums.length; i++ ) {
            int j = i - 1;
            int element = nums[i];
            while(j >= 0 && nums[j] > element ) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = element;
        }
    }

    // Bubble sort
    private static void bubbleSort(int[] nums) {
        for( int iteration = 1; iteration < nums.length; iteration++) {
            for( int j = 0; j < nums.length - iteration; j++) {
                if( nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[] {6,5,3,2,1,5};
        Sorting.selectionSort(nums);

        for( int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println();
        int[] nums2 = new int[] {6,5,3,2,1,5};
        Sorting.insertionSort(nums2);

        for( int num : nums2) {
            System.out.print(num + " ");
        }

        System.out.println();
        int[] nums3 = new int[] {6,5,3,2,1,5};
        Sorting.bubbleSort(nums3);

        for( int num : nums3) {
            System.out.print(num + " ");
        }
    }



}
