package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    public static void main(String[] args) {

        int edges[][] =new int[][]{{1,0}};

        System.out.println(topologicalSort(2,edges));
    }

    static class GraphNode {
        int value;
        int inVal;
        List<GraphNode> outwards;

        public GraphNode(int value) {
            this.value = value;
            outwards = new ArrayList<>();
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getInVal() {
            return inVal;
        }

        public void setInVal(int inVal) {
            this.inVal = inVal;
        }

        public List<GraphNode> getOutwards() {
            return outwards;
        }

        public void setOutwards(List<GraphNode> outwards) {
            this.outwards = outwards;
        }
    }


    public static int[] topologicalSort(int size,int[][] edges) {
        List<GraphNode> list = new ArrayList<>();
        for (int i=0;i<size;i++) {
            list.add(new GraphNode(i));
        }

        for (int  i=0;i<edges.length;i++) {
            list.get(edges[i][1]).outwards.add(list.get(edges[i][0]));
            list.get(edges[i][0]).inVal++;
        }
        List<GraphNode> freeNodes = new ArrayList<>();
        for (int i=0;i<list.size();i++) {
            if (list.get(i).inVal==0) {
                freeNodes.add(list.get(i));
            }
        }

        if (freeNodes.size()==0) {
            return new int[0];
        } else {
            int visited[] = new int[size];
            Map<Integer,Integer> sorted = new LinkedHashMap<>();
            for (GraphNode node : freeNodes) {
                boolean val = topologicalSort(node,visited,sorted);
                if (!val) {
                    return new int[0];
                }
            }

           if (sorted.size()!=size) {
               return new int[0];
           } else {
               int counter=0;
               int ans[] = new int[sorted.size()];
               for (int i : sorted.keySet()) {
                   ans[counter++]=i;
               }
               return ans;
           }
        }
    }

    private static boolean topologicalSort(GraphNode freeNode, int visited[], Map<Integer,Integer> sorted) {
            if (visited[freeNode.value]!=0) {
                if (sorted.containsKey(freeNode.value)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                visited[freeNode.value]=1;
            }

            for (GraphNode node : freeNode.getOutwards()) {
                boolean val =topologicalSort(node,visited,sorted);
                if (!val) {
                    return false;
                }
            }
            sorted.put(freeNode.value,sorted.size()+1);
        return true;
    }
}
