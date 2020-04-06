import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		// 자바(Java)에서는 기본적으로 우선순위 큐가 최소 힙(Min Heap)
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x == 0) {
				if (!pq.isEmpty()) {
					result.add(pq.poll());
				}
				else {
					result.add(0);
				}
			}
			else {
				pq.add(x);
			}
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
