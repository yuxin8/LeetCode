/*
Complexity analysis

Time complexity : O(n). Each of the n elements is visited at most once, thus the time complexity is O(n).

Space complexity : O(1). Only use two indexes, the space complexity is O(1).
*/

//way 1.0
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int small = 0, large = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[small] + numbers [large] == target) {
                return new int[] {small + 1, large + 1};
            }
            if (numbers[small] + numbers [large] < target) {
                small++;
            }
            if (numbers[small] + numbers [large] > target) {
                large--;
            }            
        }
        return new int[] {-1, -1}; 
    } 
}

//way 1.1

