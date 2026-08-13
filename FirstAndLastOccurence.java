// 34. Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:

// Input: nums = [], target = 0
// Output: [-1,-1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb=lowerBound(nums,target);
        if(lb==-1){
            return new int[]{-1,-1};
        }
        int ub=upperBound(nums,target);
      // Not checking if ub is -1 because if lb exists at least once then ub also exists once
        return new int[]{lb,ub};
    }
    public int lowerBound(int []nums,int target){
        int low=0;
        int high=nums.length-1;
        int lb=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
              // Not greater than or equal to because we have to find the exact target
                lb=mid;
                high=mid-1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return lb;
    }
    public int upperBound(int [] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ub=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ub=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ub;
    }
}

// TC: O(log n)
// SC: O(1)
