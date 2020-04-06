import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		ArrayList<Integer> distances = new ArrayList<Integer>();
		
		// 집중국의 개수가 n 이상일 때
		if (k >= n) {
			System.out.println(0); // 각 센서의 위치에 설치하면 되므로 정답은 0 
			return;
		}
		
		// 모든 센서의 위치를 입력 받아 오름차순 정렬
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			data.add(x);
		}
		Collections.sort(data);
		
		int result = 0;
		
		// 각 센서 간의 거리를 계산하며 기록 
		for (int i = 1; i < n; i++) {
			distances.add(data.get(i) - data.get(i - 1));
			result += data.get(i) - data.get(i - 1);
		}
		
		// 내림차순 정렬 
		Collections.sort(distances);
		Collections.reverse(distances);
		
		// 가장 긴 거리부터 하나씩 제거
		for (int i = 0; i < k - 1; i++) {
			result -= distances.get(i);
		}
		
		System.out.println(result);
	}

}
