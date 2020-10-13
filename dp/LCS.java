public class LCS {
    public static void main(String[] args) {
        String word1 = "nematode";
        String word2 = "empty";

        System.out.println(lcs(word1,word2,word1.length() - 1, word2.length() - 1));
    }

    private static int lcs(String word1, String word2, int i1, int i2) {
        if( i1 < 0 || i2 < 0 ) {
            return 0;
        }

        if( word1.charAt(i1) == word2.charAt(i2) ) {
            return 1 + lcs(word1,word2,i1-1,i2-1);
        }

        return Math.max(lcs(word1,word2,i1-1,i2),lcs(word1,word2,i1,i2-1));
    }
}

