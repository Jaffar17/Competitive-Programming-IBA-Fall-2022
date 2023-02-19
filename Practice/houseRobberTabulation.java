class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int neg = 0;

        for(int i=1; i<nums.length; i++){
            if(i-2 < 0){
                int pick = nums[i] + 0;
                int notPick = 0 + dp[i-1];
                dp[i] = Math.max(pick, notPick);
            }
            else{
                int pick = nums[i] + dp[i-2];
                int notPick = 0 + dp[i-1];
                dp[i] = Math.max(pick, notPick);
            }
            
        }
        return dp[nums.length - 1];
    }
}
