class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum>maxSum){
                maxSum = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        return maxSum;
    }
}


// Optimal Approach:
import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		// write your code here
		long local_max = 0;
		long global_max = Long.MIN_VALUE;

		for(int i=0; i<n; i++){
			local_max = Math.max(arr[i], arr[i]+local_max);
			if(local_max<0){
				local_max = 0;
			}
			if(local_max>global_max){
				global_max = local_max;
			}
		}
		return global_max;
	}

}
