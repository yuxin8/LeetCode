//way 1.0
/*
Complexity analysis

Time complexity : O(n). Each of the n elements is visited at most once, thus the time complexity is O(n).

Space complexity : O(1). Only use two indexes, the space complexity is O(1).
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int small = 0, large = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
     // while (small < right) {
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



//way 2.0
/*
Apply to binary search.

nums[left] < nums[mid] < nums[right], so that： nums[left] + nums[mid] < nums[left] + nums[right] < nums[mid] + nums[right].

If nums[left] + nums[mid] > target, the 2 number we are looking for must be within nums[left:mid-1]. 
Similarly, if nums[right] + nums[mid] < target, the 2 number we are looking for must be within nums[mid+1:right].
*/
class Solution {
public:
   vector<int> twoSum(vector<int>& numbers, int target) {
       int left = 0, right = numbers.size()-1; 
    //   vector<int> ret; 
       
       while (left < right) {
    //       int mid = (left + right)/2; 
           int sum = numbers[left] + numbers[right]; 
           
           if (sum == target){
               return {left+1, right+1};
      //         ret.push_back(left+1); 
      //         ret.push_back(right+1); 
      //         break; 
           }
           else if (sum < target){
             left = (numbers[mid] + numbers[right] < target)?mid:left+1; //binary search
      //        left = left + 1;
           }else{
             right = (numbers[mid] + numbers[left] > target)?mid:right-1; //binary search
      //         right = right - 1;
           }          
       }
       return { -1, -1};
    //   return ret; 
   }
};

