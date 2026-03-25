package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//0 -> [1]
//1 -> [0, 2, 3]
//2 -> [1, 4, 3]
//3 -> [1, 2]
//4 -> [2, 5]
//5 -> [4]

//solution considering adjacecnyList contains 

public class CycleDetectionBFSNDFS {

	public static void main(String[] args) {
		int n = 6; // nodes 0 to 5

        List<List<Integer>> adj = new ArrayList<>();

        // initialize
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);

        // print adjacency list
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + adj.get(i));
        }
        
        System.out.println("cycle detected : by BFS "+bfsCycleDetection(adj,6,0));
        System.out.println("cycle detected : by DFS "+dfsCycleDetection(adj,6,0));
        System.out.println("");
        System.out.println("");

        // renamed variable
        List<List<Integer>> adjNoCycle = new ArrayList<>();

        // initialize
        for (int i = 0; i < n; i++) {
            adjNoCycle.add(new ArrayList<>());
        }

        // edges (cycle removed: 2-3)
        addEdge(adjNoCycle, 0, 1);
        addEdge(adjNoCycle, 1, 2);
        addEdge(adjNoCycle, 2, 4);
        addEdge(adjNoCycle, 4, 5);
        addEdge(adjNoCycle, 1, 3);

        // print
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + adjNoCycle.get(i));
        }
        
        System.out.println("cycle detected : by BFS "+bfsCycleDetection(adjNoCycle,6,0));
        System.out.println("cycle detected : by DFS "+dfsCycleDetection(adjNoCycle,6,0));
        
    }

	public static boolean bfsCycleDetection(List<List<Integer>> adjList, int v, int s) {

	    boolean[] visited = new boolean[v];
	    Queue<Integer> q = new LinkedList<>();
	    int[] parent = new int[v];
	    visited[s] = true;
	    q.add(s);

	    while (!q.isEmpty()) {
	        int current = q.poll();
	        System.out.print(current + " ");

	        for (int neighbor : adjList.get(current)) {
	            if (!visited[neighbor]) {
	                visited[neighbor] = true;
	                parent[neighbor] = current;
	                q.add(neighbor);
	            }else
	            {
	            	if(neighbor!=parent[current])
	            	{
	            		return true;
	            	}
	            }
	        }
	    }
	    return false;
	}

	
	public static boolean dfsCycleDetection(List<List<Integer>> adjList, int v, int s)
	{
		boolean[] visited=new boolean[v];
		return dfsRec(adjList,s,visited, -1);
	}
	
	 static boolean dfsRec(List<List<Integer>> adjList, int s,boolean[] visited,int parent) {
			visited[s]=true;
			// System.out.println(s+" ");
			 
			 for(int u:adjList.get(s))
			 {
				 if(visited[u]==false)
				 {
					 if(dfsRec(adjList,u,visited,s))
						 return true; 
				 }
				 else {
					 if(u!=parent)
						 return true;
				 }
					 
			 }
			 
			 return false;

		}
	
		
	
    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // undirected graph
    }

}
