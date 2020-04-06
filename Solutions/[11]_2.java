import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = 0;
		// 자바(Java)에서는 기본적으로 우선순위 큐가 최소 힙(Min Heap)
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			pq.add(x);
		}
		
		while (pq.size() != 1) {
			int one = pq.poll();
			int two = pq.poll();
			int sum_value = one + two;
			result += sum_value;
			pq.add(sum_value);
		}
		
		System.out.println(result);
	}

}
