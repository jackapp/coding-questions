package codeforces;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TreeWithKDistance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int counter=n;
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i=0;i<n;i++) {

        }

        while (counter-- >0) {
            //Edges
            int start = in.nextInt();
            int end = in.nextInt();
            //Swap start and end
            int temp=start;
            start=start>end?end:start;
            end=start>end?start:end;

        }

    }

    public static class TreeNode {
        int vertex;
        List<TreeNode> children;

        public TreeNode(List<TreeNode> children) {
            this.children = children;
        }
        public TreeNode (int vertex) {
            this.vertex=vertex;
            this.children=new ArrayList<>();
        }
    }
}
