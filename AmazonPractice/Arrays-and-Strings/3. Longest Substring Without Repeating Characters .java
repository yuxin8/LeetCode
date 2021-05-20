/* https://leetcode.com/problems/longest-substring-without-repeating-characters/
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0
 
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

/* Way 1: Approach 2: Sliding Window
A sliding window is an abstract concept commonly used in array/string problems. 
A window is a range of elements in the array/string which usually defined by the start and end indices, 
i.e. [i, j)[i,j) (left-closed, right-open). 
A sliding window is a window "slides" its two boundaries to the certain direction. 
For example, if we slide [i, j)[i,j) to the right by 11 element, then it becomes [i+1, j+1)[i+1,j+1) (left-closed, right-open).

Time Complexity: not O(n^2), it is O(2n)=O(n). In the worst case, each character will be visited twice by left and right.
Space Complexity: O(1). O(min(m,n)). O(k) space for the sliding window. The size of the sliding window: the size of the string n ~ the size of the charset/alphabet m.
*/
class solution {
  public int lengthOfLongestSubstring (String s) {
    int[] chars = new int[128];
    int left = 0, right = 0, result = 0;
    
    while (right < s.length()) {
      char r = s.charAt(right);
      chars[r]++;
      
      while (chars[r] > 1) { //move left, until there is no repeat chars[r] in a window.
        char l = s.charAt(left);
        chars[l]--;
        left++; //index left and index right, both move from left -> right direction for one time.
      }
      result = Math.max(result, right - left + 1); //now no repeat char in a window
      right++;
    }
    return result;
  }
}

