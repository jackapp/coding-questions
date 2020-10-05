package leetcode;

import leetcode.thirtyDay.PreorderToBST.TreeNode;

import java.util.Stack;

public class MaximumBinaryTree {

    public static void main(String[] args) {
        int arr[] = new int[] {3,2,1,6,0,5};
        TreeNode ans = constructMaximumBinaryTree(arr);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev=null;
        int i=0;
        while (i<nums.length) {
            if (stack.isEmpty()) {
                if (prev==null) {
                    stack.push(new TreeNode(nums[i]));
                } else {
                    TreeNode node = new TreeNode(nums[i]);
                    node.setLeft(prev);
                    stack.push(node);
                    prev=null;
                }
                i++;
            } else {
                if (stack.peek().getVal()<nums[i]) {
                    prev = stack.pop();
                } else {
                    TreeNode temp =stack.pop();
                    TreeNode node = new TreeNode(nums[i]);
                    node.setLeft(prev);
                    temp.setRight(node);
                    stack.push(temp);
                    stack.push(node);
                    i++;
                }
            }
        }

        TreeNode ans= prev;
        while (!stack.isEmpty()) {
            ans = stack.pop();
        }
        return ans;
    }
}
