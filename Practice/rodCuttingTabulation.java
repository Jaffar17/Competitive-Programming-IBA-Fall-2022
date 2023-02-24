import java.util.*;
public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		// n = rod's total length
		// rodlength = index + 1 piece length
		// index is the changing variable to try out all combinations
		int[][] dp = new int[n][n+1];
		for(int i=0; i<n; i++){
			Arrays.fill(dp[i], 0);
		}
		for(int N=0; N<=n; N++){
			dp[0][N] = N*price[0];
		}

		for(int i=1; i<n; i++){
			for(int N=0; N<=n; N++){
				int notTake = 0 + dp[i-1][N];
				int take = Integer.MIN_VALUE;
				if(i+1<=N){
					take = price[i] + dp[i][N-(i+1)];
				}
				dp[i][N] = Math.max(take, notTake);
			}
		}
		return dp[n-1][n];
	}
	
}
