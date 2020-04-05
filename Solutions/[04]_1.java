import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader 클래스를 이용해 빠르게 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			data.add(x);
		}
		
		Collections.sort(data);
		
		for (int x: data) {
			System.out.println(x);
		}
	}

}
