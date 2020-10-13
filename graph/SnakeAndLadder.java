import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    public static void main(String[] args) {
        int[] board= new int[37];

        board[2] = 13;
        board[5] = 2;
        board[9] = 18;
        board[18] = 11;
        board[17] = -13;
        board[20] = -14;
        board[24] = -8;
        board[25] = 10;
        board[32] = -2;
        board[34] = -22;

        System.out.println(SnakeAndLadder.minDice(board));
    }

    private static int minDice(int[] board) {
       Queue<Integer> queue = new LinkedList<>();
       boolean[] visited = new boolean[37];
       int[] distance = new int[37];
       queue.add(0);
       distance[0] = 0;
       visited[1] = true;

       while (!queue.isEmpty()) {
           int position = queue.remove();
           if( position == 36) {
               break;
           }

           for( int i = 1; i <= 6; i++ ) {
               if( position + i <= 36 && position + i + board[position + i] <= 36 ) {
                   int newPosition = position + i + board[position + i];
                   if( !visited[newPosition]   ) {
                       queue.add(newPosition);
                       distance[newPosition] = distance[position] + 1;
                       visited[newPosition] = true;
                   }
               }

           }
       }
        return distance[36];
    }
}
