import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by baris on 03.03.2017.
 */
public class TopSort {
    public static void topSort(ArrayList<ArrayList<Integer>> adj){
        int N = adj.size();
        boolean visited[] = new boolean[N];

        Stack<Integer> contents = new Stack<>();

        for (int i = 0; i < N; i++) {
            if(!visited[i]){
                recursiveTopSort(adj, i,visited, contents);
            }
        }

        while (!contents.empty()){
            System.out.println(contents.pop());
        }
    }

    public static void recursiveTopSort(ArrayList<ArrayList<Integer>> adj, int i, boolean visited[], Stack contents){
        visited[i] = true;
        for (int j = 0; j < adj.get(i).size(); j++) {
            if (!visited[adj.get(i).get(j)]){
                recursiveTopSort(adj, adj.get(i).get(j), visited, contents);
            }
        }
        contents.push(i);
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
        topSort(adj);
    }
}
