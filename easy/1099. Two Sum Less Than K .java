/* https://leetcode.com/problems/two-sum-less-than-k/solution/

  Given an array nums of integers and integer k, return the maximum sum such that 
  there exists i < j with nums[i] + nums[j] = sum and sum < k. 
  If no i, j exist satisfying this equation, return -1.
  
Example 1:
Input: nums = [34,23,1,24,75,33,54,8], k = 60
Output: 58
Explanation: We can use 34 and 24 to sum 58 which is less than 60.

Example 2:
Input: nums = [10,20,30], k = 15
Output: -1
Explanation: In this case it is not possible to get a pair sum less that 15.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 1000
1 <= k <= 2000
*/

/* way 1: brute force
The size of our array is limited to 100. So, a brute force solution could be a reasonable option. It's simple and does not require any additional memory.

Time Complexity: O(n^2). 2 nested loops.
Space Complexity: O(1). 
*/
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int sum = 0;
        int value = -1;
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                sum = nums[i] + nums[j];
                if(sum < k){
                    value = Math.max(value, sum);
                }
            }
        }
        return value;
    }
}



/* way 2: two pointers. Array.sort()
Time Complexity: O(nlogn) to sort the array. The two pointers approach itself is O(n), so the time complexity would be linear if the input is sorted. Overall for this one is O(nlogn).
Space Complexity: O(logn) to O(n), depending on the implementation of the sorting algorithm. The two pointers approach itself is O(1).
*/
class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int value = -1;
        int i = 0;
        int j = nums.length-1;
        int sum = 0;
        while (i < j){
            sum = nums[i] + nums[j];
            if (sum < k) {
                value = Math.max(value, sum);
                i++;
            }else{
                j--;
            }
        }
        return value;
    }
}

