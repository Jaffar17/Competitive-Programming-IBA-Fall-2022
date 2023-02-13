import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n+1];
        dp[0] = 0;
        //Arrays.fill(dp, -1);
        for(int i=1; i<n; i++){
            int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }
            dp[i] = Math.min(fs, ss);
        }
        return dp[n-1];
    }
}
