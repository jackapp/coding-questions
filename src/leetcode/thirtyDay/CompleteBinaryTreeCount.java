package leetcode.thirtyDay;

public class CompleteBinaryTreeCount {

    public static void main(String[] args) {

    }

    public static int countNodes(TreeNode root) {
        int height = findHeight(root,true);
       traverse(root,height);
       return 1;
    }

    private static int findHeight(TreeNode root,boolean left) {
        if (root==null) {
            return 0;
        } else {
            return left?1+findHeight(root.left,true):1+findHeight(root.right,false);
        }
    }

    private static int traverse(TreeNode root,int height) {
        if (height==0) {
            return 0;
        }
        //Check left and right height
        if (root==null) {
            return 1;
        }
        int left = findHeight(root.left,false);
        int right = findHeight(root.right,true);
        if (left==height-1) {
            if (left==right) {
                return traverse(root.right,height-1);
            } else {

            }
        } else {
            return traverse(root.left,height-1);
        }

        return 1;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
