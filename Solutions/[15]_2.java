import java.util.Scanner;

public class Main {

	public static int t, m, n, k;
	public static int[][] data = new int[50][50];
	public static boolean[][] visited = new boolean[50][50];
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	// 깊이 우선 탐색(DFS)
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				continue;
			}
			if (data[nx][ny] > 0 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		t = sc.nextInt();
		while (t-- > 0) {
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();
			data = new int[50][50];
			visited = new boolean[50][50];
			
			for (int i = 0; i < k; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				data[x][y] = 1;
			}
			
			int result = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (data[i][j] > 0 && !visited[i][j]) {
						dfs(i, j);
						result++;
					}
				}
			}
			
			System.out.println(result);
		}
	}

}
