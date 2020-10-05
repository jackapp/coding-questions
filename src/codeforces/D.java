package codeforces;

import java.util.*;

public class D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t =in.nextInt();

        while (t-->0) {
            int n=in.nextInt();
            int k=in.nextInt();
            int arr[] = new int[n];
            for (int i=0;i<n;i++) {
                arr[i]=in.nextInt();
            }
            int replacements=0;
            Map<Integer,Integer> map = new HashMap<>();
            for (int i=0;i<n/2;i++) {
                if (arr[i]<0 || arr[n-i-1]<0) {
                    if (arr[i]<0) {
                        replacements++;
                    }
                    if (arr[n-i-1]<0) {
                        replacements++;
                    }
                } else {
                    int val = arr[i]+arr[n-i-1];
                    //Add the value to a map
                    if (map.containsKey(val)) {
                        map.put(val,map.get(val)+1);
                    } else {
                        map.put(val,1);
                    }
                }
            }

            //Iterate through the hashmap having maximum value
            Iterator iterator = map.entrySet().iterator();
            int max=0;
            int totalSum=0;
            int tp=0;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                int curr = (Integer) entry.getValue();
                totalSum+=curr;
                if (max<curr) {
                    max= curr;
                }
                if ((Integer)entry.getKey()<k) {
                    tp++;
                }
            }
            int ans = replacements+(totalSum-max);
            System.out.println(ans+tp);
        }


    }

    /*

    private static void printGraph(Node root) {
        if (root==null) return;
        Queue<Node> queue = new LinkedList<>();
        for (Node node : root.getChildNodes()) {
            queue.add(node);
        }
        System.out.println(root.val);
        int depth=1;
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek().getDepth()==depth) {
                Node curr = queue.poll();
                System.out.print(curr.val + " ");
                if (curr.getChildNodes()!=null) {
                    for (Node node1 : curr.getChildNodes()) {
                        queue.add(node1);
                    }
                }
            }
            System.out.println();
            depth++;
        }
    }

    //Traverse

    static int traverse(Node root,int k,int n) {

        Queue<Node> queue = new LinkedList<>();
        int remaining=n-1;
        Node temp = root;
        int depth=1,nextDepthChildren=0;
        for (Node node : temp.getChildNodes()) {
            queue.add(node);
            nextDepthChildren+=node.children==null?0:node.children;
        }
        while (!queue.isEmpty() && nextDepthChildren>k) {
            nextDepthChildren=0;
            while (!queue.isEmpty() && queue.peek().getDepth()==depth) {

                Node currNode =  queue.poll();
                System.out.println("Node is "+ currNode.getVal() + "Current depth = "+depth + " and nextDepthChildren =" + nextDepthChildren);
                for (Node node : currNode.getChildNodes()) {
                    queue.add(node);
                }
                nextDepthChildren+=currNode.children;

            }
            depth++;
        }
        return findMaximumHappiness(depth,queue,k);
        //Queue contains the result


    }

    private static int findMaximumHappiness(int depth, Queue<Node> queue,int k) {
        //Poll the queue, traverse their sum
        List<Node> list = (List) queue;
        int val=0;
        Map<Node,Integer> nodeMap = new HashMap<>();
        int childrenCount=0;
        int happy=0;
        int res=0;
        for (Node node1: list) {
            res = findResult(node1,depth+1);
            nodeMap.put(node1,res);
            childrenCount+=node1.children!=null?node1.children:0;
        }
        int temp=childrenCount;
        while (temp<k) {
            res+=depth;
            temp++;
        }

        //Sort here
        //remaining take it from the map
        return res;
    }

    public static int findResult(Node node,int depth) {
        if (node==null || node.getChildNodes()==null) {
            return depth;
        } else {
            List<Node> nodes = node.getChildNodes();
            int res=0;
            for (Node node1: nodes) {
                res+=findResult(node1,depth+1);
            }
            return res;
        }
    }

    private static int createGraph(Map<Integer, List<Node>> edgeMap,Node root,int depth) {
        List<Node> children = (List<Node>) edgeMap.get(root.getVal());
        root.setChildNodes(children==null?new ArrayList<>():children);
        int val=0;
        if (children!=null) {
            for (Node node: children) {
                val+=1+createGraph(edgeMap,node,depth+1);
            }
        }
        root.setChildren(val);
        root.setDepth(depth);
        return val;
    }

    static class Node {
        Integer children;
        int val;
        int depth;

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        List<Node> childNodes;

        public Node(int val) {
            this.val = val;
        }

        public int getChildren() {
            return children;
        }

        public void setChildren(int children) {
            this.children = children;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public List<Node> getChildNodes() {
            return childNodes;
        }

        public void setChildNodes(List<Node> childNodes) {
            this.childNodes = childNodes;
        }
    }
    */
}
