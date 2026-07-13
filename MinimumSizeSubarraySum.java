// 209. Minimum Size Subarray Sum
// Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. 
// If there is no such subarray, return 0 instead.

// Example 1:
// Input: target = 7, nums = [2,3,1,2,4,3]
  
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.
  
// Example 2:
// Input: target = 4, nums = [1,4,4]
// Output: 1
  
// Example 3:
// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0
  
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int right=0;
        int left=0;
        int minLen=Integer.MAX_VALUE;
        int len=0;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>=target){
                len=right-left+1;
                minLen=Math.min(len,minLen);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        if(minLen==Integer.MAX_VALUE){
            return 0;
        }
        return minLen;
    }
}
// Uses sliding window algorithm. Here right-left+1 because indexing starts from 0. Here first adding all values starting from the right. If sum exceeds target then update length and remove starting elements.
