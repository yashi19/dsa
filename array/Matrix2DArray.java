public class Matrix2DArray {

    int[][] matrix, rowSum, colSum;
    public Matrix2DArray(final int[][] matrix) {
        this.matrix = matrix;
        if(matrix.length > 0){
            this.rowSum = rowSum(matrix, matrix.length + 1, matrix[0].length + 1);
            this.colSum = colSum(rowSum, rowSum.length, rowSum[0].length);
        }
    }

    public int sumRegion(final int a, final int b, final int c, final int d) {
      
        return colSum[c+1][d+1] - colSum[c+1][b] - colSum[a][d+1] + colSum[a][b];
    }
    
      private int[][] rowSum(final int[][] matrix, final int rows, final int cols){
       final int[][] rowSum = new int[rows][ cols];
       for( int i = 1; i < rows; i++ ) {
           for( int j = 1; j < cols; j++ ) {
               rowSum[i][j] = matrix[i-1][j-1] + rowSum[i][j-1];
           }
       }
       return rowSum;
    }

    private int[][] colSum(final int[][] matrix, final int rows, final int cols){
        final int[][] colSum = new int[rows][ cols];
        for( int i = 1; i < cols; i++ ) {
            for( int j = 1; j < rows; j++ ) {
                colSum[j][i] = matrix[j][i] + colSum[j-1][i];
            }
        }
        return colSum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        Matrix2DArray matrix2DArray = new Matrix2DArray(matrix);
//        System.out.println(matrix2DArray.sumRegion(2,1,4,3));

        int[][] matrix1 = new int[][] {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        Matrix2DArray.spiralPrint(matrix1);
    }

    private static void spiralPrint(int[][] matrix) {
        int startRow = 0, lastRow = matrix.length - 1, startCol = 0, lastCol = matrix[0].length - 1;

        while(startCol <= lastCol && startRow <= lastRow) {
            for (int col = startCol; col <= lastCol; col++) {
                System.out.print(matrix[startRow][col] + " ");
            }
            startRow++;
            System.out.println();
            for (int row = startRow; row <= lastRow; row++) {
                System.out.print(matrix[row][lastCol] + " ");
            }
            lastCol--;
            System.out.println();

            if( startCol < lastCol ) {
                for (int col = lastCol; col >= startCol; col--) {
                    System.out.print(matrix[lastRow][col] + " ");
                }
                lastRow--;
                System.out.println();
            }

            if( lastRow > startRow ) {
                for (int row = lastRow; row >= startRow; row--) {
                    System.out.print(matrix[row][startCol] + " ");
                }
                startCol++;
                System.out.println();
            }


        }


    }
}
