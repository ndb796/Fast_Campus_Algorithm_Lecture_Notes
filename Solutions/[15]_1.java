import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static int n, m, result;
	public static ArrayList<Integer>[] adj = new ArrayList[101];
	public static boolean[] visited = new boolean[101];

	// 깊이 우선 탐색(DFS)
	public static void dfs(int x) {
		result++;
		visited[x] = true;
		for (int i = 0; i < adj[x].size(); i++) {
			int y = adj[x].get(i);
			if (!visited[y]) {
				dfs(y);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		
		dfs(1);
		System.out.println(result - 1);
	}

}
