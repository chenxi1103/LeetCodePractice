### Binary Tree Preorder Traversal
- Recursion Solution
    ``` java
    public class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            helper(root);
            return list;
        }
        private void helper(TreeNode root) {
            if (root == null) return;
            list.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
    ```
- Traversal Solution
    ```java
        public class Solution {
        /**
        * 重点：因为要达到根左右，所以用stack，先加入当前值到list，后push右再push左就可以达到先左后右的效果（先进后出）
        */
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);
            while (stack.size() != 0) {
                TreeNode node = stack.pop();
                if (node != null) {
                    list.add(node.val);
                    if (node.right != null) stack.add(node.right);
                    if (node.left != null) stack.add(node.left);
                }
            }
            return list;
        }
    }

### Binary Tree Inorder Traversal
- Recursion Solution
    ```java
    public class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            helper(root);
            return list;
        }
        private void helper(TreeNode root) {
            if (root == null) return;
            helper(root.left);
            list.add(root.val);
            helper(root.right);
        }
    }
    ```
- Traversal Solution
    ```java
    public class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (!stack.isEmpty() || cur != null) {
                //尽量的把左孩子压入栈
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) cur = node.right;
            }
            return list;
        }
    }
    ```
### Binary Tree Postorder Traversal
- Recursion Solution
    ```java
    public class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            helper(root);
            return list;
        }
        private void helper(TreeNode root) {
            if (root == null) return;
            helper(root.left);
            helper(root.right);
            list.add(root.val);
        }
    }
    ```
- Traversal Solution
    ```java
    public class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            //维护一个lastVisited来看node的右子树有没有被遍历过。
            TreeNode lastVisited = root;
            while (cur != null || !stack.isEmpty()) {
                //把左子树都push进stack
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode node = stack.peek();
                //如果该node的右子树为空或已经被遍历，则遍历该node。
                if (node.right == null || node.right == lastVisited) {
                    lastVisited = node;
                    list.add(stack.pop().val);
                    cur = null;
                } 
                //否则遍历右子树先。
                else {
                    cur = node.right;
                }
            }
            return list;
            }
    }
    ```
    ```java
    public class Solution {
        //第二种猥琐解法，按照中右左的方法遍历，最后reverse变成左右中。。。
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                if (curNode != null) {
                    list.add(curNode.val);
                    stack.push(curNode.left);
                    stack.push(curNode.right);
                }
            }
            Collections.reverse(list);
            return list;
            }
    }
    ```

