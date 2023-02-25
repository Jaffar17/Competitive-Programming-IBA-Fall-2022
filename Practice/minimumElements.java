import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int index = num.length - 1;
        int[][] dp = new int[index+1][x+1];
        for(int i=0; i<index+1; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int ans = recMin(index, x, num, dp);
        if(ans>=(int)Math.pow(10, 9)){
            return -1;
        }
        else{
            return ans;
        }
    }

    static int recMin(int index, int x, int[] num, int[][] dp){
        if(index == 0){
            if(x%num[0] == 0){
                return x/num[0];
            }
            else{
                return (int)Math.pow(10, 9);
            }
        }
        if(dp[index][x]!=-1){
            return dp[index][x];
        }

        int notTake = 0+recMin(index-1, x, num, dp);
        int take = Integer.MAX_VALUE;
        if(num[index]<=x){
            take = 1+recMin(index, x-num[index], num, dp);
        }
        dp[index][x] = Math.min(take, notTake);
        return dp[index][x];
    }

}
