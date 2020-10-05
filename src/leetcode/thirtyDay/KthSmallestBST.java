package leetcode.thirtyDay;

import leetcode.thirtyDay.PreorderToBST.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestBST {

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(k,0);
        Map.Entry<Integer,Integer> entry = map.entrySet().iterator().next();
        TreeNode rootTemp = traverse(root,entry);
        return rootTemp.val;
    }

    public static TreeNode traverse(TreeNode node, Map.Entry<Integer, Integer> stepsRemaining) {
        if (isLeaf(node)) {
            stepsRemaining.setValue(stepsRemaining.getValue()+1);
            if (stepsRemaining.getValue()==stepsRemaining.getKey()) {
                return node;
            } else {
                return null;
            }
        }
        TreeNode node1 = traverse(node.left, stepsRemaining);
        if (node1!=null) {
            return node1;
        } else {
            stepsRemaining.setValue(stepsRemaining.getValue()+1);
            if (stepsRemaining.getValue()==stepsRemaining.getKey()) {
                return node;
            } else {
                return traverse(node.right, stepsRemaining);
            }
        }
    }

    private static boolean isLeaf(TreeNode root) {
        if (root==null) return false;
        return root.left==null&&root.right==null;
    }

}
