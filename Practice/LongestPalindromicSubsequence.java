class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuffer(s).reverse().toString();
        int[][] dp = new int[s.length()][t.length()];
        int ind1 = s.length()-1;
        int ind2 = t.length()-1;
        for(int i=0; i<s.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        return lps(ind1, ind2, s, t, dp);
    }
    public int lps(int ind1, int ind2, String s, String t, int[][] dp){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1) == t.charAt(ind2)){
            dp[ind1][ind2] = 1 + lps(ind1-1, ind2-1, s, t, dp);
            return dp[ind1][ind2];
        }
        dp[ind1][ind2] = Math.max(lps(ind1-1, ind2, s, t, dp), lps(ind1, ind2-1, s, t, dp));
        return dp[ind1][ind2];
    }
}
