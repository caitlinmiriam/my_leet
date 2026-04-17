// 3761. Minimum Absolute Distance Between Mirror Pairs

// You are given an integer array nums.
// A mirror pair is a pair of indices (i, j) such that:
// 0 <= i < j < nums.length, and
// reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading zeros are omitted after reversing, for example reverse(120) = 21.
// Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices i and j is abs(i - j).
// If no mirror pair exists, return -1.

// Example 1:
// Input: nums = [12,21,45,33,54]
// Output: 1
// Explanation:
// The mirror pairs are:
// (0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1], giving an absolute distance abs(0 - 1) = 1.
// (2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4], giving an absolute distance abs(2 - 4) = 2.
// The minimum absolute distance among all pairs is 1.

// Example 2:
// Input: nums = [120,21]
// Output: 1
// Explanation:
// There is only one mirror pair (0, 1) since reverse(nums[0]) = reverse(120) = 21 = nums[1].
// The minimum absolute distance is 1.

// Example 3:
// Input: nums = [21,120]
// Output: -1
// Explanation:
// There are no mirror pairs in the array.

class Solution {
    public int reverse(int n){
        int res=0;
        while(n!=0){
            int digit=n%10;
            res=res*10+digit;
            n/=10;
        }
        return res;
    }
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        int minDisAbs=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                minDisAbs=Math.min(minDisAbs,i-map.get(nums[i]));
            }
            int rev=reverse(nums[i]);
            map.put(rev,i);
        }
        if(minDisAbs==Integer.MAX_VALUE){
            return -1;
        }
        return minDisAbs;
    }
}
 
