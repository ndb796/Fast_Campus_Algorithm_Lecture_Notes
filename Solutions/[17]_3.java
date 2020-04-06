import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			data.add(sc.nextInt());
		}
		
		// 오름차순 정렬 수행 
		Collections.sort(data);
		
		// 불만도의 합 계산
		long result = 0;
		for (int i = 1; i <= n; i++) {
			result += Math.abs(i - data.get(i - 1));
		} 
		
		System.out.println(result);
	}

}
