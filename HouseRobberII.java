// 213. House Robber II

// You are a professional robber planning to rob houses along a street. 
// Each house has a certain amount of money stashed. 
// All houses at this place are arranged in a circle. 
// That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the
// same night.
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

// Example 1:
// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
  
// Example 2:
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
  
// Example 3:
// Input: nums = [1,2,3]
// Output: 3

// Bottom-Up Tabulation
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[nums.length-1];
        }
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
      // Case 1: Including the first one and excluding the last
      // Case 2: Excluding the first and including the last
    }
    public int rob(int nums[],int i,int j){
        int len=j-i+1;
        if(len==1){
            return nums[i];
        }
        int dp[]=new int[len];
        dp[0]=nums[i];
        dp[1]=Math.max(nums[i],nums[i+1]);
        for(int k=2;k<len;k++){
            dp[k]=Math.max(nums[i+k]+dp[k-2],dp[k-1]);
          // nums[i+k] to access the element from the start
        }
        return dp[len-1];
    }
}
