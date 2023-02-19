class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int ans1 = tabRob(nums, 1);
        int ans2 = tabRob(nums, 0);
        return Math.max(ans1, ans2);
    }

    int tabRob(int[] nums, int start){
        int end = 0;
        if(start==0){
            end = nums.length-2;
        }
        else{
            end = nums.length-1;
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        int neg = 0;

        for(int i=start+1; i<=end; i++){
            int pick = 0;
            if(i-2 < start){
                pick = nums[i] + neg; 
            }
            else{
                pick = nums[i] + dp[i-2];
            }
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }

        return dp[end];
    }
}
