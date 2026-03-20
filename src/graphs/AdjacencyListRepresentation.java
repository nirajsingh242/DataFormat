package graphs;

import java.util.ArrayList;

public class AdjacencyListRepresentation {

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
		
		printAdjList(adjList);
		

	}
	
	static void addAdjacecnyList(ArrayList<ArrayList<Integer>> adjList,int u, int v)
	{
		adjList.get(u).add(v);
		adjList.get(v).add(u);

	}

	static void printAdjList(ArrayList<ArrayList<Integer>> adjList)
	{
		for(int i=0; i < adjList.size();i++)
		{
			for(int j=0;j<adjList.get(i).size();j++)
			{
				System.out.print(adjList.get(i).get(j)+ " ");
				
			}
			System.out.println();
		}
	}
}
