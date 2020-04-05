import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// 빠르게 입력 받기 위해 BufferedReader 라이브러리 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			data.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(data);
		System.out.println(data.get(k - 1));
	}

}
