import java.util.ArrayList;
import java.util.List;

public class NetworkFlow{
    public static int edmondsKarp(List<Edge>[] graph, int s, int t){
        int flow = 0;
        int[] q = new int[graph.length];
        while (true) {
            int qt = 0;
            q[qt++] = s;
            Edge[] pred = new Edge[graph.length];
            for (int qh = 0; qh < qt && pred[t] == null; qh++) {
                int cur = q[qh];
                for (Edge e : graph[cur]) {
                    if (pred[e.sink] == null && e.capacity > e.flow) {
                        pred[e.sink] = e;
                        q[qt++] = e.sink;
                    }
                }
            }
            if (pred[t] == null)
                break;
            int df = Integer.MAX_VALUE;
            for (int u = t; u != s; u = pred[u].source)
                df = Math.min(df, pred[u].capacity - pred[u].flow);
            for (int u = t; u != s; u = pred[u].source) {
                pred[u].flow += df;
                graph[pred[u].sink].get(pred[u].reverse).flow -= df;
            }
            flow += df;
        }
        return flow;
    }
    public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
        graph[s].add(new Edge(s, t, graph[t].size(), cap));
        graph[t].add(new Edge(t, s, graph[s].size() - 1, 0));
    }
    public static void main(String[] args){
        int N = 5;
        List<Edge>[] graph = new List[N];
        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        addEdge(graph, 0, 1, 3);
        addEdge(graph, 0, 2, 2);
        addEdge(graph, 1, 2, 2);
        System.out.print(edmondsKarp(graph, 0, 2));
    }
}
class Edge{
    int capacity;
    int flow;
    int source;
    int sink;
    int reverse;
    public Edge(int source, int sink, int reverse, int capacity){
        this.source = source;
        this.sink = sink;
        this.reverse = reverse;
        this.capacity = capacity;
    }
}