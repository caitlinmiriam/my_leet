// 62. Unique Paths

// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
// The robot can only move either down or right at any point in time.
// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
// The test cases are generated so that the answer will be less than or equal to 2 * 109.

// Example 1: 
// Input: m = 3, n = 7
// Output: 28

// Example 2:
// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down

// Bottom-Up (Tabulation)
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

// Top-Down (Memoization) 
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return uniquePaths(m-1,n-1,dp);
    }
    public int uniquePaths(int i,int j,int dp[][]){
        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=uniquePaths(i-1,j,dp);
        int left=uniquePaths(i,j-1,dp);
        dp[i][j]=up+left;
        return dp[i][j];
    }
}

// Recursion
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m-1,n-1);
    }
    public int helper(int i,int j){
        if(i==0&&j==0){
            return 1;
        }
        if(i<0||j<0){
            return 0;
        }
        int up=helper(i-1,j);
        int left=helper(i,j-1);
        return up+left;
    }
}
// 38/64
// TLE
