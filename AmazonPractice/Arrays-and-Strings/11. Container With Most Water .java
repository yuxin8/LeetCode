/* https://leetcode.com/problems/container-with-most-water/
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). 
Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1

Example 3:
Input: height = [4,3,2,1,4]
Output: 16

Example 4:
Input: height = [1,2,1]
Output: 2
 
Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/

//Way 1: Brute Force (DO NOT USE because Time Limit Exceeded)
//Time complexity : O(n^2).
//Space complexity : O(1). 
class Solution {
    public int maxArea(int[] height) {
        int h = -1;
        int result = -1;        
        for (int r = 1; r < height.length; r++) {           
            for (int l = r - 1; l >= 0; l-- ) {
                h = Math.min(height[r], height[l]);
                result = Math.max(result, (r - l) * h);
            }
        }
        return result;
    }
}

//Way 2: Two Pointer Approach
//Time complexity : O(n).
//Space complexity : O(1). 
class Solution {
    public int maxArea(int[] height) {
        int result = -1; 
        int l = 0, r = height.length - 1;
        
        while (l < r) {            
            result = Math.max(result, (r - l) * Math.min(height[l], height[r]));
            
          if (height[l] <= height[r]) {
                l++;                
            } else {
                r--;
            }           
        }       
        return result;
    }
}

