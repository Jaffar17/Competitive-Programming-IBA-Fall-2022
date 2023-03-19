class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        int prev_ind = -1;
        int ind = 0;
        return recLIS(ind, prev_ind, nums, dp);
    }

    public int recLIS(int ind, int prev_ind, int[] nums, int[][] dp){
        if(ind == nums.length){
            return 0;
        }

        if(dp[ind][prev_ind+1] !=-1){
            return dp[ind][prev_ind+1];
        }

        int notTake = 0 + recLIS(ind+1, prev_ind, nums, dp);
        int take = 0;
        if(prev_ind == -1 || nums[ind]>nums[prev_ind]){
            take = 1 + recLIS(ind+1, ind, nums, dp);
        }

        dp[ind][prev_ind+1] = Math.max(take, notTake);
        return dp[ind][prev_ind+1];
    }
}

// Tabulation Approach
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int ind=nums.length-1; ind>=0; ind--){
            for(int prev_ind = ind-1; prev_ind>=-1; prev_ind--){
                int notTake = 0 + dp[ind+1][prev_ind+1];
                int take = 0;
                if(prev_ind == -1 || nums[ind]>nums[prev_ind]){
                    take = 1 + dp[ind+1][ind+1];
                    }
                dp[ind][prev_ind+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}
