import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int n, m, max_value;
	public static ArrayList<Integer>[] adj = new ArrayList[10001];
	public static boolean[] visited = new boolean[10001];
	public static int[] saved = new int[10001];
	public static StringBuffer result = new StringBuffer();

	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visited = new boolean[10001];
		visited[x] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < adj[now].size(); i++) {
				int y = adj[now].get(i);
				if (!visited[y]) {
					q.add(y);
					visited[y] = true;
					// 현재 노드(now)에 도달할 수 있는 노드들의 값을 증가
					saved[y]++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y); // (도착 노드, 출발 노드) 순으로 삽입
		}

		for (int i = 1; i <= n; i++) {
			bfs(i);
		}
		
		for (int i = 1; i <= n; i++) {
			max_value = Math.max(max_value, saved[i]);
		}
		
		for (int i = 1; i <= n; i++) {
			if (saved[i] == max_value) {
				result.append(i + " ");
			}
		}
		
		System.out.println(result);
	}
}
