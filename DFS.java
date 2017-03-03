import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by baris on 03.03.2017.
 */
public class DFS {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int start){
        int N = adj.size();
        boolean visited[] = new boolean[N];
        Stack<Integer> st = new Stack<>();

        st.push(start);

        while (!st.empty()){
            int v = st.pop();
            if(!visited[v]){
                visited[v] = true;
                System.out.println(v);
                for (int i = 0; i < adj.get(v).size(); i++) {
                    st.push(adj.get(v).get(i));
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
        dfs(adj, 0);
    }
}
