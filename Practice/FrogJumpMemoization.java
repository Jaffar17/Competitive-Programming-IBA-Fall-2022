import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n-1, heights, dp);
    }
    static int f(int index, int[] heights, int[] dp){
        if(index == 0){
            return 0;
        }
        if(dp[index] !=-1){
            return dp[index];
        }
        int left = f(index-1, heights, dp) + Math.abs(heights[index]-heights[index-1]);
        int right = Integer.MAX_VALUE;
        if(index > 1){
            right = f(index-2, heights, dp) + Math.abs(heights[index]-heights[index-2]);
        }
        dp[index] = Math.min(left, right);
        return dp[index];
    }

}
