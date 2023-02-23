import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int[][] dp = new int[n][maxWeight+1];
            for(int i=weight[0]; i<=maxWeight; i++){
                dp[0][i] = value[0];
            }
            for(int i=1; i<n; i++){
                for(int j=0; j<=maxWeight; j++){
                    int notTake = 0 + dp[i-1][j];
                    int take = Integer.MIN_VALUE;
                    if(weight[i]<=j){
                        take = value[i] + dp[i-1][j-weight[i]];
                    }
                    dp[i][j] = Math.max(take, notTake);
                }
            }
            return dp[n-1][maxWeight];
    }
  
}
