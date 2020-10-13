import java.util.*;
class Pair {
    int totalMarks;
    int totalTests;

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public void setTotalTests(int totalTests) {
        this.totalTests = totalTests;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public int getTotalTests() {
        return totalTests;
    }
}
public class MyCode {

    private static int maxAverageScore(String[][] students) {
        Map<String, Pair> map = new HashMap<>();
        for( String[] student : students) {
            if( student.length > 0 ) {
                Pair marks = map.getOrDefault(student[0], new Pair());
                marks.setTotalMarks(marks.getTotalMarks() + Integer.parseInt(student[1]));
                marks.setTotalTests(marks.getTotalTests() + 1);
                map.put(student[0], marks);
            }

        }
        int maxAverageScore = 0;
        for( Pair pair : map.values() ) {
            maxAverageScore = Math.max( maxAverageScore, pair.getTotalMarks()/pair.getTotalTests());
        }
        // System.out.println("Max average: " + maxAverageScore);
        return maxAverageScore;
    }

    public static void main (String[] args) {
        String[][] students = new String[][] {
                // {"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}
                // {}
        };
        System.out.println(MyCode.maxAverageScore(students));
    }
}
