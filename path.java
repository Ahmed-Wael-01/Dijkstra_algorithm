import java.util.Arrays;
import java.util.Scanner;

public class path
{
	public static void print_result(int[] arr1, String[] arr2)
	{
		int len = arr1.length;
		for (int i = 0; i < len; i++)
			System.out.println("The distance to the " + i + " node is " +
					arr1[i] + "\nAnd it's path is " + arr2[i]);

	}
	public static int[][] create_graph()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of nodes: ");
		int nodes = input.nextInt();
		int graph[][] = new int[nodes][nodes];

		for (int i = 0; i < nodes; i++)
		{
			for (int j = 0; j < nodes; j++)
			{
				System.out.println("Enter the dist[" + i + "][" + j + "]:");
				graph[i][j] = input.nextInt();
			}
		}
		return graph;
	}
	public static void dijkstra(int src, int[][] graph)
	{
		int len = graph.length;
		int dist[] = new int[len];
		boolean is_solved[] = new boolean[len];
		String paths[] = new String[len];
		for (int i = 0; i < len; i++)
			dist[i] = -1;
		dist[src] = 0;
		is_solved[src] = true;
		paths[src] = String.valueOf(src);
		int shortest[] = {-1, -1};

                for(int i = 0; i < len - 1; i++)
                {
                        for(int n = 0; n <= len - 1; n++)
                        {
                                if (is_solved[n] == false)
                                        continue;
                                for(int adj = 0; adj <= len - 1; adj++)
                                {
                                        if (graph[n][adj] == 0 || is_solved[adj] == true)
                                                continue;
                                        if (dist[adj] == -1 || (graph[n][adj] + dist[n]) < dist[adj])
					{
						dist[adj] = graph[n][adj] + dist[n];
                                                paths[adj] = paths[n] + "->" + String.valueOf(adj);
					}
					if (shortest[0] == -1 || dist[adj] < shortest[0])
                                        {
                                                shortest[0] = dist[adj];
                                                shortest[1] = adj;
                                        }
                                }
                        }
                        is_solved[shortest[1]] = true;
                        shortest[0] = -1;
                        shortest[1] = -1;
                }
		print_result(dist, paths);
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int [][]graph = create_graph();
		System.out.println("input src point:");	
		int src = input.nextInt();
		dijkstra(src, graph);
	}
}
