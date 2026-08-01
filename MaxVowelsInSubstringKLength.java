// 1456. Maximum Number of Vowels in a Substring of Given Length

// Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
// Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

// Example 1:
// Input: s = "abciiidef", k = 3
// Output: 3
// Explanation: The substring "iii" contains 3 vowel letters.

// Example 2:
// Input: s = "aeiou", k = 2
// Output: 2
// Explanation: Any substring of length 2 contains 2 vowels.

// Example 3:
// Input: s = "leetcode", k = 3
// Output: 2
// Explanation: "lee", "eet" and "ode" contain 2 vowels.

class Solution {
    public int maxVowels(String s, int k) {
        int count=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                count++;
            }
        }
        int maxCount=count;
        for(int i=k;i<s.length();i++){
            char ch1=s.charAt(i-k);
            char ch2=s.charAt(i);
            if(ch1=='a'||ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u'){
                count--;
            }
            if(ch2=='a'||ch2=='e'||ch2=='i'||ch2=='o'||ch2=='u'){
                count++;
            }
            maxCount=Math.max(maxCount,count);
            if (maxCount == k) return k;
        }
        return maxCount;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
