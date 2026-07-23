import java.util.Arrays;


class Solution {

    
    public int minDistance(String word1, String word2) {
        return bottomUp1D(word1, word2);
        // return bottomUp2D(word1, word2);
        // return topDown2D(word1, word2);
        // return BruteForce(word1, word2);
    }

        

        // Bottom-Up DP Linear Space (best one)
    private int bottomUp1D(String word1, String word2){

        // to achieve O(min(n,m))
        // similar to the GCD problem
        if (word1.length() > word2.length()) {
            return minDistance(word2, word1);
        }

        // Java Strings are heavy
        // primitive array char wins here
        char[] w1 = word1.toCharArray(); // Shorter string (length n)
        char[] w2 = word2.toCharArray(); // Longer string (length m)

        int n = w1.length;
        int m = w2.length;
        
        // here is the O(min(n,m)) Space
        int[] dp = new int[n + 1];

        // first row is the insertion cost
        for (int j = 0; j <= n; j++) {
            dp[j] = j; // we can add constents here to make certain operations cost more than others
        }

        // loop where (i, j) to (w2, w1)
        for (int i = 1; i <= m; i++) {
            // previous acts here as (i - 1, j - 1)
            int previous = dp[0];
            // start overwrite on the current row
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j]; // Store current before update

                //match
                if (w1[j - 1] == w2[i - 1]) {
                    dp[j] = previous; // load (i - 1, j - 1)
                } else {
                    // Mismatch: 1 + Min(Insert, Delete, Replace)
                    int insertOp  = dp[j - 1];
                    int deleteOp  = dp[j];
                    int replaceOp = previous;

                    dp[j] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
                }
                
                previous = temp; //update (i - 1, j - 1) to be (i, j) and move next
            }
        }
        
        return dp[n];

    }

    
    //3: Iterative Bottom-Up 2D Matrix Grid Tabulation (best if you want the actual solution)
    private int bottomUp2D(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // setup add the costs of first row and columns
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        
        // fill the matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    
    //2: Top-Down Recursion
    private int topDown2D(String word1, String word2) {
        int[][] memory = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < memory.length; i++) {
            Arrays.fill(memory[i], -1);
        }
        return DP_recursion(word1.toCharArray(), word2.toCharArray(), 0, 0, memory);
    }

    private int DP_recursion(char[] w1, char[] w2, int i, int j, int[][] memory) {
        if (w1.length == i) return w2.length - j;
        if (w2.length == j) return w1.length - i;
        if (memory[i][j] != -1) return memory[i][j];

        if (w1[i] == w2[j]) {
            memory[i][j] = DP_recursion(w1, w2, i + 1, j + 1, memory);
        } else {
            int insert  = DP_recursion(w1, w2, i, j + 1, memory);
            int delete  = DP_recursion(w1, w2, i + 1, j, memory);
            int replace = DP_recursion(w1, w2, i + 1, j + 1, memory);
            memory[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        return memory[i][j];
    }

    // 1:Brute Force 

    private int BruteForce(String word1, String word2) {
        return recursionBF(word1.toCharArray(), word2.toCharArray(), 0, 0);
    }

    public int recursionBF(char[] w1, char[] w2, int i, int j){

        if(w1.length == i){
            return w2.length - j;
        }

        if(w2.length == j){
            return w1.length - i;
        }

        //match --zero cost--
        if(w1[i] == w2[j]){
            return recursion(w1, w2, i + 1, j + 1);
        }

        int insertOp = recursion(w1, w2, i, j + 1);
        int deleteOp = recursion(w1, w2, i + 1, j);
        int repalceOp= recursion(w1, w2, i + 1, j + 1);

        return 1 + Math.min(insertOp, Math.min(deleteOp, repalceOp));

        
    }
}