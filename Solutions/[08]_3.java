import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		// 정수 이후에 문자열을 받는 경우, 다음과 같이 먼저 문자열로 입력 받아야 합니다.
		int n = Integer.parseInt(sc.nextLine());
		HashMap<String, Integer> books = new HashMap<String, Integer>();
		ArrayList<String> result = new ArrayList<String>();
		int max_value = 0;
		
		for (int i = 0; i < n; i++) {
			String book = sc.nextLine();
			// 해당 책이 출현한 빈도를 계산
			if (books.containsKey(book)) {
				books.put(book, books.get(book) + 1);
			}
			else {
				books.put(book, 1);
			}
			max_value = Math.max(max_value, books.get(book));
		}
		
		// 빈도수가 가장 높은 책의 이름들을 저장
		for (String book: books.keySet()) {
			if (books.get(book) == max_value) result.add(book);
		}
		Collections.sort(result);
		System.out.println(result.get(0));
		
	}

}
