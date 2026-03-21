package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//🔹 Why Queue?
//
//Because BFS follows FIFO (First In First Out):
//
//First discovered → first processed

//⏱️ Complexity
//
//Time: O(V + E)
//
//Space: O(V)

//🚀 When to use BFS
//
//Shortest path in unweighted graph
//
//Level order traversal (like trees)
//
//Finding connected components
//
//Cycle detection (undirected graph)
public class BfsAdjacencyList {

	public static void main(String[] args) {
				//0 → [1, 2]
				//1 → [0, 2, 3]
				//2 → [0, 1]
				//3 → [1]
				int v=4;
				ArrayList<ArrayList<Integer>> adjList=new ArrayList<>(v);
				for(int i=0;i<v;i++)
				{
					adjList.add(new ArrayList<>());
				
				}
				addAdjacecnyList(adjList,0,1);
				addAdjacecnyList(adjList,0,2);
				addAdjacecnyList(adjList,2,1);
				addAdjacecnyList(adjList,3,1);
				
				bfs(adjList,4,0);

	}
	
	public static void bfs(ArrayList<ArrayList<Integer>> adjList, int v, int s) {

	    boolean[] visited = new boolean[v];
	    Queue<Integer> q = new LinkedList<>();

	    visited[s] = true;
	    q.add(s);

	    while (!q.isEmpty()) {
	        int current = q.poll();
	        System.out.print(current + " ");

	        for (int neighbor : adjList.get(current)) {
	            if (!visited[neighbor]) {
	                visited[neighbor] = true;
	                q.add(neighbor);
	            }
	        }
	    }
	}
	
	static void addAdjacecnyList(ArrayList<ArrayList<Integer>> adjList,int u, int v)
	{
		adjList.get(u).add(v);
		adjList.get(v).add(u);

	}

}
