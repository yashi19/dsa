import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class SumMatrix extends  Thread{
//    public static void main(String[] args) throws InterruptedException {
//        int[][] matrix1 = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
//
//        System.out.println(SumMatrix.totalSubArraySum(matrix1));

//
        static HashMap<Integer,String> l=new HashMap<Integer,String>();

        public void run()
        {


            try
            {
                Thread.sleep(1000);
                // Child thread trying to add
                // new element in the object
                l.put(103,"D");
            }
            catch(InterruptedException e)
            {
                System.out.println("Child Thread going to add element");
            }
        }

        public static void main(String[] args) throws InterruptedException
        {
            l.put(100,"A");
            l.put(101,"B");
            l.put(102,"C");
            SumMatrix t=new SumMatrix();
            t.start();

            for (Object o : l.entrySet())
            {
                Object s=o;
                System.out.println(s);
                Thread.sleep(1000);
            }
            System.out.println(l);
        }
//    }


    private static int totalSubArraySum(int[][] matrix) {




        int sum = 0,n = matrix.length, m = matrix[0].length ;
        for(int i = 0; i < n; i++) {
            for( int j = 0; j < m; j++) {
                // for cell( i,j) we will out no of submatrix in which it will be part of
                // let suppose there are x cells that can be TL corner
                // let suppose there are y cells that can be BR corner
                // Total No of submatrix = xc1 * yc1 = x * y
                // x* y will be no of submatrix in which (i,j)) will be part of
                // So we will multiple its value = matirx[i][j] * x * y  where x = (i+1) * (j +1) and y = ( n-i) (n- j)
                int x = (i+1) * (j+1);
                int y = (n-i) * (m-j);
                sum += x * y * matrix[i][j];

            }
        }

        return sum;

    }
}
