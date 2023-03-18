class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];

        for(int ind=0; ind<=n; ind++){
            dp[ind][0] = 0;
        }

        for(int ind=0; ind<=m; ind++){
            dp[0][ind] = 0;
        }

        // Finding LCS and filling DP table
        for(int ind1=1; ind1<=n; ind1++){
            for(int ind2=1; ind2<=m; ind2++){
                if(str1.charAt(ind1-1) == str2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }
                else{
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2], dp[ind1][ind2-1]);
                }
            }
        }

        int i = n;
        int j = m;
        String ss = "";

        while(i>0 && j>0){
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ss += str1.charAt(i-1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                ss += str1.charAt(i-1);
                i--;
            } else {
                ss += str2.charAt(j-1);
                j--;
            }
        }

        while(i>0){
            ss += str1.charAt(i-1);
            i--;
        }
        while(j>0){
            ss += str2.charAt(j-1);
            j--;
        }

        String ans =new StringBuilder(ss).reverse().toString();

        return ans;
    }

    
}
