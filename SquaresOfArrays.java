// 977. Squares of a Sorted Array

// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

// Example 1:
// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
  
// Example 2:
// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]

// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         for(int i=0;i<nums.length;i++){
//             nums[i]=nums[i]*nums[i];
//         }
//         Arrays.sort(nums);
//         return nums;
//     }
// }
// Lazy approach
// 10ms

class Solution {
    public int[] sortedSquares(int[] nums) {
        int ans[]=new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int index=nums.length-1;
        while(i<=j){
            if(Math.abs(nums[i])<Math.abs(nums[j])){
                ans[index]=nums[j]*nums[j];
                j--;
            }
            else{
                ans[index]=nums[i]*nums[i];
                i++;
            }
            index--;
        }
        return ans;
    }
}
// Two pointer
// Moving larger number to the end is easier since the array is already sorted
