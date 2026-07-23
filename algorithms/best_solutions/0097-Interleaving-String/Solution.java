import java.util.Arrays;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // return bruteForce(s1, s2, s3);
        // return DPTopDown (s1, s2, s3);
        // return DPBottomUp(s1, s2, s3);
        return DPBottomUpLinearSpace(s1,s2,s3);
    }

    public boolean DPBottomUpLinearSpace(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        if(s1.length() < s2.length()){
            return DPBottomUpLinearSpace(s2, s1, s3);
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        boolean[] dp = new boolean[str2.length + 1];
        
        dp[0] = true;
        for(int i = 1 ; i < str2.length + 1 && str1[i-1] == str3[i-1]; i++){
            dp[i] = dp[i-1];
        }

        
        

        for(int i = 1; i < str1.length + 1; i++){
            boolean isContainTrue = dp[0];
            dp[0] = (str1[i] == str3[i]) && dp[0];

            for(int j = 1; j < str2.length + 1; j++){
                int k = i + j - 1;
                boolean b1 = (str1[i-1] == str3[k]) && dp[i-1];
                boolean b2 = (str2[j-1] == str3[k]) && dp[i];
                isContainTrue = b1 || b2;
                dp[i] = b1 || b2;

            }
            if(! isContainTrue){
                return false;
            }
        }
        return dp[str2.length];
    }

   


//--------------------------------------------------------

    public boolean DPBottomUp(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        boolean[][] dp = new boolean[str1.length + 1][str2.length + 1];
        
        dp[0][0] = true;
        for(int i = 1 ; i < str1.length + 1 && str1[i-1] == str3[i-1]; i++){
            dp[i][0] = dp[i-1][0];
        }

        for(int j = 1 ; j < str2.length + 1 && str2[j-1] == str3[j-1]; j++){
            dp[0][j] = dp[0][j-1] && str2[j - 1] == str3[j - 1];
        }
        

        for(int i = 1; i < str1.length + 1; i++){
            boolean isContainTrue = false;
            for(int j = 1; j < str2.length + 1; j++){
                int k = i + j - 1;
                boolean b1 = (str1[i-1] == str3[k] && dp[i-1][j]);
                boolean b2 = (str2[j-1] == str3[k] && dp[i][j-1]);
                isContainTrue = b1 || b2;
                dp[i][j] = b1 || b2;

            }
            if(! isContainTrue){
                return false;
            }
        }
        return dp[str1.length][str2.length];
    }

   


//--------------------------------------------------------


    public boolean DPTopDown(String s1, String s2, String s3){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();
        int[][] dp = new int[str1.length + 1][str2.length + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
            
        }
        if(RecursionDP(str1, 0, str2, 0, str3, 0, dp) == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public int RecursionDP(char[] s1, int i, char[] s2, int j, char[] s3, int k, int[][] dp){
        
        if(s1.length == i && s2.length == j && s3.length == k){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        
        int b1 = 0;
        int b2 = 0;

        if(i < s1.length &&  k < s3.length  &&  s1[i] == s3[k]){
            b1 = RecursionDP(s1, i + 1,  s2, j,  s3, k + 1, dp);
        }
        if(j < s2.length && k < s3.length &&  s2[j] == s3[k]){
            b2 = RecursionDP(s1, i,  s2, j + 1,  s3, k + 1, dp);
        }
        dp[i][j] = b1 | b2;
        return dp[i][j];

    }

//------------------------------------------------------------------
    public boolean bruteForce(String s1, String s2, String s3){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();

        return recursionBF(str1, 0, str2, 0, str3, 0);
    }

    public boolean recursionBF(char[] s1, int i, char[] s2, int j, char[] s3, int k){
        
        if(s1.length == i && s2.length == j && s3.length == k){
            return true;
        }

        
        boolean b1 = false;
        boolean b2 = false;

        if(i < s1.length &&  k < s3.length  &&  s1[i] == s3[k]){
            b1 = recursionBF(s1, i + 1,  s2, j,  s3, k + 1);
        }
        if(j < s2.length && k < s3.length &&  s2[j] == s3[k]){
            b2 = recursionBF(s1, i,  s2, j + 1,  s3, k + 1);
        }

        return b1 || b2;

    }
}