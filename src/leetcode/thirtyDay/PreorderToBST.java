package leetcode.thirtyDay;

import java.util.Stack;

public class PreorderToBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode ans = findBST(new int[] {8,5,1,7,10,12});
        System.out.println();
    }

    public static TreeNode findBST(int []preOrder) {

        if (preOrder.length==0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = new TreeNode(preOrder[0]);
        TreeNode root = prev;
        stack.push(prev);
        for (int i=1;i<preOrder.length;i++) {
            TreeNode node = new TreeNode(preOrder[i]);
            if (node.val<stack.peek().val) {
                TreeNode node1 = stack.pop();
                node1.left=node;
                stack.push(node1);
            } else {
                while (!stack.isEmpty() && stack.peek().val<node.val) {
                    if (stack.peek().right==null) {
                        prev = stack.pop();
                    } else {
                        prev.right=node;
                        prev=node;
                        stack.push(node);
                        continue;
                    }
                }
                prev.right=node;

            }
            prev=node;
            stack.push(node);
        }
        return root;
    }
}
