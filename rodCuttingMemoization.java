import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		// n = rod's total length
		// rodlength = index + 1 piece length
		// index is the changing variable to try out all combinations
		int index = n-1;
		int[][] dp = new int[n][n+1];
		for(int i=0; i<n; i++){
			Arrays.fill(dp[i], -1);
		}
		return recCutRod(price, index, n, dp);
	}
	static int recCutRod(int[] price, int index, int n, int[][] dp){
		if(index == 0){
			return n * price[0];
		}
		if(dp[index][n] != -1){
			return dp[index][n];
		}

		int notTake = 0 + recCutRod(price, index-1, n, dp);
		int take = Integer.MIN_VALUE;
		//rodlength = index + 1
		if(index+1 <= n){
			take = price[index] + recCutRod(price, index, n-(index+1), dp);
		}
		dp[index][n] = Math.max(take, notTake);
		return dp[index][n];
	}
}
