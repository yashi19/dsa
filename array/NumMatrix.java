public class NumMatrix {
    int[][] matrix, rowSum, colSum;
    public NumMatrix(final int[][] matrix) {
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
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2,1,4,3));
    }
}
