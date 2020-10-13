/**
 * @author yashikatanwar
 * This class is responsible to get the second maximum integer value from array of integers given as string.
 * Assumption: For Invalid input example "abc123", "123ab", null in between  -1 will be return.
 */
public class Solution {

    public static long secondMaximum(String[] numbers) {
        if( isEmpty(numbers) ) {
            return -1;
        }
        long maximum = Long.MIN_VALUE, secondMaximum = Long.MIN_VALUE;
        for (String number : numbers) {
            long num;
            try {
                 num = Long.parseLong(number);
            } catch (NumberFormatException exception) {
                System.out.println("hey");
                return -1;
            }

            if (maximum < num) {
                secondMaximum = maximum;
                maximum = num;
            } else if (secondMaximum < num && maximum != num ) {
                secondMaximum = num;
            }
        }
        return secondMaximum == Long.MIN_VALUE ? -1 : secondMaximum;
    }

    private static boolean isEmpty(String[] numbers) {
        return numbers == null || numbers.length == 0;
    }

    public static void main(String[] arg) {
        String[] numbers = new String[]{"1", "2"};
        System.out.println("Second maximum number: " + Solution.secondMaximum(numbers));
    }
}
