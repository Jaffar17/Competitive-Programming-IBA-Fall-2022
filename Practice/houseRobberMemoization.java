class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recRob(nums.length-1, nums, dp);
    }

    int recRob(int index, int[] nums, int[] dp){
        // if(index == 0){
        //     return nums[0];
        // }
        
        if(index < 0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick = nums[index] + recRob(index-2, nums, dp);
        int notPick = 0 + recRob(index-1, nums, dp);
        dp[index] = Math.max(pick, notPick);

        return dp[index];
    }
}
