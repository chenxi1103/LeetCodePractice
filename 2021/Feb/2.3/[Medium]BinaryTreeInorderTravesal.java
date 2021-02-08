/**
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

 // Recursion
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        helper(root);
        return list;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null) helper(root.left);
        list.add(root.val);
        if(root.right != null) helper(root.right);
    }
}

//Traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null) {
            stack.add(root);
            root = root.left;
        }
        
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode curRight = cur.right;
            list.add(cur.val);
            while (curRight != null) {
                stack.add(curRight);
                curRight = curRight.left;
            }
        }
        return list;
    }
}