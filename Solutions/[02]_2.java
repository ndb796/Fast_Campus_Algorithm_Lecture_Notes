import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Node {
	public int priority;
	public int index;

	public Node(int priority, int index) {
		this.priority = priority;
		this.index = index;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc, n, m, cnt;
		tc = sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			Queue<Node> q = new LinkedList<Node>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); // 높은 중요도부터 처리
			cnt = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			
			for (int j = 0; j < n; j++) {
				int x = sc.nextInt();
				q.add(new Node(x, j)); // {중요도, 인덱스} 삽입 
				pq.add(-x); // 중요도 삽입  (내림차순)
			}
			
			while (true) {
				Node node = q.poll();
				
	            // 가장 중요도가 높은 경우 출력 
				if (node.priority == -pq.peek()) {
					cnt++;
					pq.poll();
					if (node.index == m) {
						System.out.println(cnt);
						break;
					}
				}
				else {
					q.add(new Node(node.priority, node.index));
				}
			}
		}
	}

}
