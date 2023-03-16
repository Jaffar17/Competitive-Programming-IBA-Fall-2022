class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        int i = word1.length()-1;
        int j = word2.length()-1;
        for(int n=0; n<=i; n++){
            Arrays.fill(dp[n], -1);
        }
        return editDistance(i, j, word1, word2, dp);
    }
    public int editDistance(int i, int j, String word1, String word2, int[][] dp){
        if(i<0){
            return j+1;
        }
        if (j<0){
            return i+1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = 0+editDistance(i-1, j-1, word1, word2, dp);
            return dp[i][j];
        }
        dp[i][j] = Math.min(1 + editDistance(i, j-1, word1, word2, dp), // insert
        Math.min(1 + editDistance(i-1, j, word1, word2, dp), // delete
        1+ editDistance(i-1, j-1, word1, word2, dp))); // replace

        return dp[i][j];
    }
}
