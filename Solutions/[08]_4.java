import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static ArrayList<Integer> data = new ArrayList<Integer>();
	
	public static int ascending() {
		int now = data.get(0);
		int result = 1;
		for (int i = 1; i < data.size(); i++) {
			if (now < data.get(i)) {
				result += 1;
				now = data.get(i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(sc.nextLine());
			data.add(x);
		}
		
		System.out.println(ascending());
		Collections.reverse(data);
		System.out.println(ascending());
	}

}
