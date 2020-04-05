import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// 빠르게 입력을 받기 위해 BufferedReader 라이브러리 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[10001];
		
		for (int i = 0; i < n; i++) {
			data[Integer.parseInt(br.readLine())]++;
		}
		
		// 한 번에 빠르게 출력하기 위해 StringBuilder 라이브러리 사용
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < 10001; i++) {
			if (data[i] != 0) {
				for (int j = 0; j < data[i]; j++) {
					result.append(i).append("\n");
				}
			}
		}
		
		System.out.print(result);
	}

}
