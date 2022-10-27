import java.util.*;
public class DijkstrasAlgo {
    public static void main(String args[]) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
    static class Edge {
        int src, dest, wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; //dist[i] --> src to i
        for (int i=0; i<graph.length; i++) {
            if (i!=src) {
                dist[i] = Integer.MAX_VALUE; //Initialise with infinity
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0)); //Initially src with path value == 0;
        boolean vis[] = new boolean[graph.length];
        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(!vis[curr.n]) {
                vis[curr.n] = true;
                //Now call for all the neighbours of teh curr.n(currNode)
                for(int i=0; i<graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;
                    //initially dist[v] is infinity :-
                    //Hence every path will be added to pq as a pair(node, path);
                    if (dist[u]+w < dist[v]) {
                        dist[v] = dist[u]+w;
                        pq.add(new Pair(v, dist[v]));
                        //adding v as new node; 
                        //adding dist[v] as new path;
                    }
                }
            }
        }
        for (int i=0; i<dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    static class Pair implements Comparable<Pair> {
        int n, path;
        // n --> Node
        // path --> Path from src -> dest;
        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; //Path based sorting for pairs
        }
    } 
}