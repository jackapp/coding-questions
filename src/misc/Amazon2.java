package misc;

import java.util.*;

public class Amazon2 {

    public static void main(String[] args) {

    }
    List<Integer> criticalRouters(int numRouters, int numLinks,
                                  ArrayList<ArrayList<Integer>> links) {

        Graph graph = new Graph(numRouters+1);
        for (List<Integer> list : links) {
            graph.addEdge(list.get(0),list.get(1));

        }
        return graph.disconnectionPoint();
    }

    static class Graph {
        private int V;
        private LinkedList<Integer> adj[];
        int time = 0;
        static final int NIL = -1;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        void disconnectionUtil(int u, boolean visited[], int disc[],
                               int low[], int parent[], boolean ap[]) {

            int children = 0;
            visited[u] = true;
            disc[u] = low[u] = ++time;

            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext()) {
                int v = i.next();
                if (!visited[v]) {
                    children++;
                    parent[v] = u;
                    disconnectionUtil(v, visited, disc, low, parent, ap);
                    low[u] = Math.min(low[u], low[v]);
                    if (parent[u] == NIL && children > 1) {
                        ap[u] = true;
                    }
                    if (parent[u] != NIL && low[v] >= disc[u]) {
                        ap[u] = true;
                    }
                }
                else if (v != parent[u])
                    low[u] = Math.min(low[u], disc[v]);
            }
        }
        List<Integer> disconnectionPoint() {
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];
            boolean routers[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                parent[i] = NIL;
                visited[i] = false;
                routers[i] = false;
            }

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    disconnectionUtil(i, visited, disc, low, parent, routers);

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                if (routers[i] == true)
                    list.add(i);
            }
            return list;
        }
    }

}
