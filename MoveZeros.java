// 283. Move Zeroes

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Example 1:
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Example 2:
// Input: nums = [0]
// Output: [0]

class Solution {
    public void moveZeroes(int[] nums) {
        int len=nums.length;
        int j=0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        for(int k=j;k<len;k++){
            nums[k]=0;
        }
    }
}
// Time Complexity (TC): O(n)
// Space Complexity (SC): O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int len=nums.length;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
// Avoids unnecessary rewrites
