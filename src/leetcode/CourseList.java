package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CourseList {

    public static void main(String[] args) {
        int prereq[][] = new int[][]{{1,0},{1,2},{0,1}};
        System.out.println(canFinish(3,prereq));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        GraphNode []nodes = new GraphNode[numCourses];
        for (int i=0;i<numCourses;i++) {
            nodes[i]=new GraphNode(i);
        }
        boolean visited[] = new boolean[numCourses];
        for (int i=0;i<prerequisites.length;i++) {

                nodes[prerequisites[i][1]].childNodes.add(nodes[prerequisites[i][0]]);
                nodes[prerequisites[i][0]].parentNodes.add(nodes[prerequisites[i][1]]);

                if (!visited[prerequisites[i][0]]) {
                    visited[prerequisites[i][0]]=true;
                }

        }
        List<GraphNode> parentNodes = new ArrayList<>();
        for (int i=0;i<numCourses;i++) {
            if (!visited[i]) {
                parentNodes.add(nodes[i]);
            }
        }

        if (!checkCycle(parentNodes,new boolean[numCourses])) {
            return false;
        } else {
            return true;
        }
        //Find the topological sort

    }

    public static boolean checkCycle(List<GraphNode> start,boolean visited[]) {

        for (GraphNode graphNode : start) {
            if (!traverse(graphNode,visited,null)) {
                return false;
            }
        }
        return true;
    }

    private static boolean traverse(GraphNode node,boolean visited[],GraphNode parent) {

        return true;
    }

    static class GraphNode {
        int value;
        List<GraphNode> childNodes;
        List<GraphNode> parentNodes;

        public GraphNode(int value) {
            this.value = value;
            childNodes = new ArrayList<>();
            parentNodes = new ArrayList<>();
        }

        public List<GraphNode> getParentNodes() {
            return parentNodes;
        }

        public void setParentNodes(List<GraphNode> parentNodes) {
            this.parentNodes = parentNodes;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public List<GraphNode> getChildNodes() {
            return childNodes;
        }

        public void setChildNodes(List<GraphNode> childNodes) {
            this.childNodes = childNodes;
        }
    }

}
