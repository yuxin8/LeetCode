/* https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1
 
Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
*/

/*
Time complexity : O(n). Each of the n elements is visited at most once.
Space complexity : O(1). We only use two indexes, the space complexity is O(1).
*/
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (count.containsKey(c)) {
                //put or replace
                count.put(c, count.get(c) + 1);
            } else {
                count.put(c, 1);
            }           
        }
        
        for (int i = 0; i < s.length(); i++) {
            //get (that string)
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
