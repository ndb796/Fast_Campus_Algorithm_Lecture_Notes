import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, m, result = 0, cnt = 0;
		ArrayList<Integer> cranes = new ArrayList<Integer>();
		ArrayList<Integer> boxes = new ArrayList<Integer>();
		
		int[] positions = new int[50]; // 각 크레인이 현재 옮겨야 하는 박스의 번호 (0부터 시작)
		boolean[] checked = new boolean[10000]; // 각 박스를 옮겼는지의 여부
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			cranes.add(sc.nextInt());
		}
		
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			boxes.add(sc.nextInt());
		}
		
		// 최적의 해를 구해야 하므로, 내림차순 정렬 
		Collections.sort(cranes);
		Collections.sort(boxes);
		Collections.reverse(cranes);
		Collections.reverse(boxes);
		
		
		// 모든 박스를 옮길 수 없는 경우
		if (cranes.get(0) < boxes.get(0)) {
			System.out.println(-1);
			return;
		} 
		
		while (true) {
			if (cnt == m) break;
			// 모든 크레인에 대하여 각각 처리 
			for (int i = 0; i < n; i++) {
				while (positions[i] < m) {
					// 아직 안 옮긴 박스 중에서, 옮길 수 있는 박스를 만날 때까지 반복
					if (!checked[positions[i]] && cranes.get(i) >= boxes.get(positions[i])) {
						checked[positions[i]] = true;
						positions[i] += 1;
						cnt += 1;
						break;
					}
					positions[i] += 1;
				}
			}
			result += 1;
		}
		
		System.out.println(result);
	}

}
