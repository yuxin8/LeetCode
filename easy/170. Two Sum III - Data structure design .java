/*
Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

Implement the TwoSum class:
  TwoSum() Initializes the TwoSum object, with an empty array initially.
  void add(int number) Adds number to the data structure.
  boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.

Input:
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output:
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false
*/

/*
Time Complexity:
  For the add(number) function: O(1), since it takes a constant time to update an entry in hashtable.
  For the find(value) function: O(N), where N is the total number of unique numbers. In the worst case, we would iterate through the entire table.

Space Complexity: O(N), where N is the total number of unique numbers that we will see during the usage of the data structure.
*/

import java.util.HashMap;

class TwoSum {
//  private HashMap<Integer, Integer> num_counts;
    HashMap <Integer, Integer> num_counts ;
    
    // Initialize your data structure here. 
    //constructor: this keyword
    public TwoSum() {
        this.num_counts = new HashMap <Integer, Integer>();
    }
    
    // Add the number to an internal data structure.
    public void add(int number) {
        if (this.num_counts.containsKey(number)){
            //put or replace
            this.num_counts.put(number, this.num_counts.get(number) + 1);
        } else {
            this.num_counts.put(number, 1);
        }
    }
    
    // Find if there exists any pair of numbers which sum is equal to the value. 
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry:this.num_counts.entrySet() ) {
            int complement = value - entry.getKey();
            
            //check if 2 numbers are the same
            if (complement != entry.getKey()) {
                if (this.num_counts.containsKey(complement)) {
                    return true;
                }
            } else {
                if (entry.getValue() > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
