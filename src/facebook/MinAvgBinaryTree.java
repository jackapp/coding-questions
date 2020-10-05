package facebook;


import leetcode.thirtyDay.PreorderToBST;

public class MinAvgBinaryTree {

    int global;
    public static void main(String[] args) {

    }

    private static int findMinEdit(TreeNode root) {
        if (root == null) {
            return -1;
        } else {

            //go left
            int left = findMinEdit(root.left);
            int right = findMinEdit(root.right);

            if (left==-1) {
                if (right==-1) {
                    return root.val;
                } else {
                    root.val=right;
                    return right;
                }
            } else {
                if (right==-1) {

                    return root.val;
                } else {
                    root.val=right;
                    return right;
                }
            }

        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
