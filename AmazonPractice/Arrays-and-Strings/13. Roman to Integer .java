/* https://leetcode.com/problems/roman-to-integer/

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. 
The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, 
the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to 
the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:
Input: s = "III"
Output: 3

Example 2:
Input: s = "IV"
Output: 4

Example 3:
Input: s = "IX"
Output: 9

Example 4:
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:
1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

*/


/* Approach 1: Left-to-Right Pass

Explaination:
What is DXCI as an integer?
Recall that D = 500.
Now, notice that this time the symbols are not ordered from most significant to least—the X and C are out of numeric order. 
Because of this, we subtract the value of X (10) from the value of C (100) to get 90.
So, going from left to right, we have D + (C - X) + I = 500 + 90 + 1 = 591.


What is CMXCIV as an integer?
Recall that M = 1000.
The symbols barely look sorted at all here—from left-to-right we have 100, 1000, 10, 100, 1, 5. 
Do not panic though, we just need to look for each occurrence of a smaller symbols preceding a bigger symbol. 
The first, third, and fifth symbols are all smaller than their next symbol. Therefore they are all going to be subtracted from their next.

The first two symbols are CM. This is M - C = 1000 - 100 = 900
The second two symbols are XC. This is C - X = 100 - 10 = 90.
The final two symbols are IV. This is V - I = 5 - 1 = 4.
Like we did above, we add these together. (M - C) + (C - X) + (V - I) = 900 + 90 + 4 = 994.


Time complexity : O(1).
As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman numerals is MMMCMXCIX. As such the time complexity is O(1).
This is assuming that looking up the value of each symbol is O(1).

Space complexity : O(1).
constant number of single-value variables are used, the space complexity is O(1).
*/
class Solution {
    
    static Map<String, Integer> values = new HashMap<>();
    
    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public int romanToInt(String s) {
        
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            
            int nextValue = 0;
            if (i + 1 < s.length()) { //if i+1 is still in range, i is not the last char
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol);
            }
            
            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            }
            else {
                sum += currentValue;
                i += 1;
            }
            
        }
        return sum;
    }
}

/* Way 2: Left-to-Right Pass Improved
Every time check if two chars exist in values map. If not, then take it as single char to deal with.
Time complexity : O(1)
Space complexity : O(1).
*/
class Solution {
    
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {
        
        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length()) {
                String doubleSymbol = s.substring(i, i + 2);
                // Check if this is the length-2 symbol case.
                if (values.containsKey(doubleSymbol)) {
                    sum += values.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }
            // Otherwise, it must be the length-1 symbol case.
            String singleSymbol = s.substring(i, i + 1);
            sum += values.get(singleSymbol);
            i += 1;
        }
        return sum;
    }
}
















