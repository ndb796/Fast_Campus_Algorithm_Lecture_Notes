import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int c = sc.nextInt();
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			data.add(x);
		}
		
		Collections.sort(data);
		
		int start = data.get(1) - data.get(0);
		int end = data.get(n - 1) - data.get(0);
		int result = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int value = data.get(0);
			int cnt = 1;
			for (int i = 1; i < n; i++) {
				if (data.get(i) >= value + mid) {
					value = data.get(i);
					cnt += 1;
				}
			}
			if (cnt >= c) {
				start = mid + 1;
				result = mid;
			}
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}

}
