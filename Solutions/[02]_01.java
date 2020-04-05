import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, cnt = 1;
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<Character> result = new ArrayList<Character>();
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			// 입력 받은 데이터에 도달할 때까지 삽입 
			while (cnt <= x) {
				s.push(cnt);
				cnt += 1;
				result.add('+');
			}
			// 스택의 최상의 원소가 데이터와 같을 때 출력 
			if (s.peek() == x) {
				s.pop();
				result.add('-');
			}
			else {
				System.out.println("NO");
				return;
			}
		}
		
		// 결과를 차례대로 출력 
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
