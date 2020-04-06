import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static int MAX = 100001;
	public static int n, k;
	public static int[] data = new int[MAX];

	// 너비 우선 탐색(BFS)
	public static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == k) return data[now];
			int next = now - 1;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[now] + 1;
				q.add(next);
			}
			next = now + 1;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[now] + 1;
				q.add(next);
			}
			next = now * 2;
			if (0 <= next && next < MAX && data[next] == 0) {
				data[next] = data[now] + 1;
				q.add(next);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		
		System.out.println(bfs());
	}

}
