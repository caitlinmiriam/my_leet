// 1732. Find the Highest Altitude

// There is a biker going on a road trip. The road trip consists of n + 1 points at various altitudes. 
// The biker starts his trip on point 0 with altitude equal 0.
// You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). 
// Return the highest altitude of a point.


// Example 1:
// Input: gain = [-5,1,5,0,-7]
// Output: 1
// Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

// Example 2:
// Input: gain = [-4,-3,-2,-1,4,3,2]
// Output: 0
// Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.

class Solution {
    public int largestAltitude(int[] gain) {
        int resultArr[]=new int[gain.length+1];
        resultArr[0]=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<gain.length;i++){
            resultArr[i+1]=resultArr[i]+gain[i];
        }
        for(int i=0;i<resultArr.length;i++){
            if(resultArr[i]>ans){
                ans=resultArr[i];
            }
        }
        return ans;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int largestAltitude(int[] gain) {
        int ans=Math.max(0,gain[0]);
        for(int i=1;i<gain.length;i++){
            gain[i]=gain[i-1]+gain[i];
            ans=Math.max(ans,gain[i]);
        }
        return ans;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int largestAltitude(int[] gain) {
        int ans=0;
        int prefix=0;
        for(int num:gain){
            prefix+=num;
            ans=Math.max(ans,prefix);
        }
        return ans;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
// A prefix sum (also called cumulative sum or running total) is a technique where we precompute the sum of all elements from the beginning of an array up to each index.
