/**
 * https://leetcode.com/problems/validate-binary-search-tree
 * 
 * BST <-> inorder
 * 
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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) return false;
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}

// Traversal Inorder
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root != null) {
            stack.add(root);
            root = root.left;
        }
        while(!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            TreeNode curRight = curNode.right;
            if (prev != null && curNode.val <= prev.val) return false;
            prev = curNode;
            while(curRight != null) {
                stack.add(curRight);
                curRight = curRight.left;
            }
        }
        return true;
    }
}