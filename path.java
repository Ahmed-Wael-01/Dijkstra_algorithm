import java.util.Arrays;

public class path
{
	public static void main(String[] args)
	{
		int dist[] = {-1,-1,-1,-1,-1,-1,-1};
		String paths[] = new String[7]; 
		boolean is_solved[] = {false,false,false,false,false,false,false};
		int[][] graph = { 
			{0,2,6,0,0,0,0},
			{2,0,0,5,0,0,0},
			{6,0,0,8,0,0,0},
			{0,5,8,0,10,15,0},
			{0,0,0,10,0,6,2},
			{0,0,0,15,6,0,6},
			{0,0,0,0,2,6,0}
		};
		int src = 0;
		dist[src] = 0;
		is_solved[src] = true;
		paths[src] = String.valueOf(src);
		int shortest[] = {-1, -1};

		for(int i = 0; i < 6; i++)
		{
			for(int n = 0; n <= 6; n++)
			{
				if (is_solved[n] == false)
					continue;
				for(int adj = 0; adj <= 6; adj++)
				{
					if (graph[n][adj] == 0 || is_solved[adj] == true)
						continue;
					if (dist[adj] == -1)
						dist[adj] = graph[n][adj] + dist[n];
					if (shortest[0] == -1 || dist[adj] < shortest[0])
					{
						paths[adj] = paths[n] + String.valueOf(adj);
						shortest[0] = dist[adj];
						shortest[1] = adj;
					}
				}
			}
			is_solved[shortest[1]] = true;
			shortest[0] = -1;
			shortest[1] = -1;
		}
		System.out.println(Arrays.toString(paths));
		System.out.println(Arrays.toString(dist));
	}
}
