import java.util.*;

/**
 * Created by baris on 03.03.2017.
 */
public class BFS {
    public static void bfs(ArrayList<ArrayList<Integer>> adj, int start){
        int N = adj.size();
        boolean visited[] = new boolean[N];
        LinkedList<Integer> q = new LinkedList<Integer>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()){
            int v = q.pop();
            System.out.println(v);
            for (int i = 0; i < adj.get(v).size(); i++) {
                int neigh = adj.get(v).get(i);
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        bfs(adj, 0);
    }
}
