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
		        System.out.println("Scenario 1: Normal DFS");
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
				System.out.println("");
				System.out.println("........................................................................");
				 System.out.println("Scenario 2: Disconnected DFS with count");
				int n = 9; // nodes 0 to 8

		        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		        // initialize list
		        for (int i = 0; i < n; i++) {
		            adj.add(new ArrayList<>());
		        }

		        // adding edges (undirected)

		        // component 1
		        adj.get(0).add(1);
		        adj.get(0).add(2);

		        adj.get(1).add(0);
		        adj.get(1).add(2);

		        adj.get(2).add(0);
		        adj.get(2).add(1);

		        // component 2
		        adj.get(3).add(4);
		        adj.get(4).add(3);

		        // component 3
		        adj.get(5).add(6);
		        adj.get(5).add(7);

		        adj.get(6).add(5);

		        adj.get(7).add(5);
		        adj.get(7).add(8);

		        adj.get(8).add(7);
		        bfsDiscParentCall(adj,n);

		     

	}
	//Scenario 1
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
	
	//Scenario 2 -> disconnected graph
	public static void bfsDiscParentCall(ArrayList<ArrayList<Integer>> adjList, int v) {
		 boolean[] visited = new boolean[v];
		 int count =0;
		 for(int i=0;i<adjList.size();i++)
		 {
			 if(visited[i]==false)
			 {
				 bfsDisImpl(adjList,v,i,visited);
				 count++;
			 }
			
		 }
			
		 System.out.println("No of disconnected component "+count);
		}
	
	public static void bfsDisImpl(ArrayList<ArrayList<Integer>> adjList, int v, int s,boolean[] visited) {

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
