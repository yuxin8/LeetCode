/*
Given the root of a Binary Search Tree and a target number k, 
return true if there exist two elements in the BST such that their sum is equal to the given target.

Input: root = [5,3,6,2,4,null,7], k = 28
Output: false 0

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true 1

Input: root = [2,1,3], k = 4
Output: true 1

Input: root = [2,1,3], k = 1
Output: false 0

Input: root = [2,1,3], k = 3
Output: true 1

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/* way 1: HashSet, recursive traversal, Depth First Traversals
   Time complexity : O(n). The entire tree is traversed only once in the worst case. Here, n refers to the number of nodes in the given tree.
   Space complexity : O(n). The size of the set can grow upto n in the worst case.
*/
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        return find (root, k, set);
    }
    public boolean find(TreeNode root, int k, Set <Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }
}


/* way 2: List, inorder Depth First Traversals
   Time complexity : O(n). We need to traverse over the whole tree once to do the inorder traversal. Here, n refers to the number of nodes in the given tree.
   Space complexity : O(n). The sorted list will contain n elements.
*/

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List <Integer> list = new ArrayList();
        inorder(root, list);
        
        int l = 0, r = list.size() - 1;
        
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            
            if(sum == k) {
                return true;
            } else if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            }
        }  
        return false;
    }
    
    public void inorder(TreeNode root, List<Integer> list1) {
        if (root == null)
            return;
        inorder(root.left, list1);
        list1.add(root.val);     //inorder 
        inorder(root.right, list1);        
    }
}
