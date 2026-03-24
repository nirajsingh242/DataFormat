package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortesPathInUnWeightedGraphBFS {

	public static void main(String[] args) {
		int n = 4; // nodes 0 to 3

        List<List<Integer>> adj = new ArrayList<>();

        // initialize list
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // function to add undirected edge
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        int[] dist = shortestPath(adj, n, 0);
        
     // print result
        for (int i = 0; i < n; i++) {
            System.out.println("Distance from " + 0 + " to " + i + " = " + dist[i]);
        }
     

	}
	
	public static int[] shortestPath( List<List<Integer>> adjList, int n, int s)
	{
		int[] dis = new int[n];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
	    boolean[] visited = new boolean[n];
	    Queue<Integer> q = new LinkedList<>();

	    dis[s] = 0;
	    visited[s] = true;
	    q.add(s);

	    while (!q.isEmpty()) {
	        int current = q.poll();
	        //System.out.print(current + " ");

	        for (int neighbor : adjList.get(current)) {
	            if (!visited[neighbor]) {
	            	dis[neighbor]=dis[current]+1;
	                visited[neighbor] = true;
	                q.add(neighbor);
	            }
	        }
	    }
		
		
		
		
		
		
		
		return dis;
	}
	static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // important for undirected graph
    }

}
