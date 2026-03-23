package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//DFS output depends on adjacency order.
//If order changes:
//
//0 → [2, 1]
//
//Output could be:
//
//0 2 1 3

//🔥 Sample Graph (Where Output Differs)
//0 → [1, 2]
//1 → [3, 4]
//2 → [5]
//3 → []
//4 → []
//5 → []
//🌳 Visual Representation
//      0
//    /   \
//   1     2
//  / \     \
// 3   4     5

//Output
//0 1 3 4 2 5
public class DfsAdjacencyList {

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
		addAdjacecnyList(adjList,0,2);
		addAdjacecnyList(adjList,0,1);
		addAdjacecnyList(adjList,2,1);
		addAdjacecnyList(adjList,3,1);
		dfs(adjList,4,0);
		
		//scenario 2
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
        dfsDis(adj,9);
		
	}
	
	//scenario 1 : simple connect adjacencyList -> it uses recursion 
	
	public static void dfs(ArrayList<ArrayList<Integer>> adjList, int v, int s)
	{
		boolean[] visited=new boolean[v];
		dfsRec(adjList,s,visited);
	}
	
		public static void dfsRec(ArrayList<ArrayList<Integer>> adjList, int s,boolean[] visited) {
			visited[s]=true;
			 System.out.println(s+" ");
			 
			 for(int u:adjList.get(s))
			 {
				 if(visited[u]==false)
					 dfsRec(adjList,u,visited);
			 }

		}
	
		
		//scenario 2 : dis connect adjacencyList -> parent call trave for all verticess
		public static void dfsDis(ArrayList<ArrayList<Integer>> adjList, int v)
		{
			 int count =0;
			boolean[] visited=new boolean[v];
			for(int i=0;i<v;i++)
			{
				if(visited[i]==false)
				{
					dfsRecDis(adjList,i,visited);
					count++;
				}
				
			}
			 System.out.println("No of disconnected component "+count);
		}
		
			public static void dfsRecDis(ArrayList<ArrayList<Integer>> adjList, int s,boolean[] visited) {
				visited[s]=true;
				 System.out.println(s+" ");
				 
				 for(int u:adjList.get(s))
				 {
					 if(visited[u]==false)
						 dfsRecDis(adjList,u,visited);
				 }

			}
		
		
	
	static void addAdjacecnyList(ArrayList<ArrayList<Integer>> adjList,int u, int v)
	{
		adjList.get(u).add(v);
		adjList.get(v).add(u);

	}

}
