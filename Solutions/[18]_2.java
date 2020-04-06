import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max_value = -10001;
		int min_value = 10001;

		ArrayList<Integer> data = new ArrayList<Integer>();
		// 자바(Java)에서는 기본적으로 우선순위 큐가 최소 힙(Min Heap)
		PriorityQueue<Integer> positive = new PriorityQueue<Integer>();
		PriorityQueue<Integer> negative = new PriorityQueue<Integer>();
		
		// 모든 센서의 위치를 입력 받아 오름차순 정렬
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			data.add(x);
			max_value = Math.max(max_value, x);
			min_value = Math.min(min_value, x);
		}

		// 가장 거리가 먼 책까지의 거리 
		int largest = Math.max(max_value, -min_value);
		
		// 최대 힙(Max Heap)을 이용
		for (int i = 0; i < n; i++) {
			// 책의 위치가 양수인 경우
			if (data.get(i) > 0) positive.offer(-data.get(i));
			// 책의 위치가 음수인 경우
			else negative.offer(data.get(i));
		}
		
		int result = 0;
		while (!positive.isEmpty()) {
			// 한 번에 m개씩 옮길 수 있으므로 m개씩 빼내기
			result += positive.poll();
			for (int i = 0; i < m - 1; i++) {
				if (!positive.isEmpty()) positive.poll();
			} 
		}
		while (!negative.isEmpty()) {
			// 한 번에 m개씩 옮길 수 있으므로 m개씩 빼내기
			result += negative.poll();
			for (int i = 0; i < m - 1; i++) {
				if (!negative.isEmpty()) negative.poll();
			} 
		}
		
		// 일반적으로 왕복 거리를 계산하지만, 가장 먼 곳은 편도 거리 계산
		System.out.println(-result * 2 - largest);
	}

}
