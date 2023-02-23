import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
            int[][] dp = new int[n][maxWeight+1];
            for(int i=0; i<n; i++){
                Arrays.fill(dp[i], -1);
            }
            return recKnapsack(n-1, maxWeight, weight, value, dp);
            //return dp[n-1][weight.length-1];

    }

    static int recKnapsack(int n, int maxWeight, int[] weight, int[] value, int[][] dp){
        if(n==0){
            if(weight[0] <= maxWeight){
                return value[0];
            }
            else{
                return 0;
            }
        }

        if(dp[n][maxWeight] != -1){
            return dp[n][maxWeight];
        }

        int notTake = 0 + recKnapsack(n-1, maxWeight, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if(weight[n] <= maxWeight){
            take = value[n] + recKnapsack(n-1, maxWeight-weight[n], weight, value, dp);
        }
        //return Math.max(take, notTake);
        dp[n][maxWeight] = Math.max(take, notTake);
        return dp[n][maxWeight];
    }
}
