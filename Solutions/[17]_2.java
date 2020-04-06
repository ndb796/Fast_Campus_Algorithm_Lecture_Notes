import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count0 = 0; // 전부 0으로 바꾸는 경우 
		int count1 = 0; // 전부 1로 바꾸는 경우 
		String data = sc.nextLine();
		
		if (data.charAt(0) == '1') count0 += 1;
		else count1 += 1;
		
		for (int i = 0; i < data.length() - 1; i++) {
			if (data.charAt(i) != data.charAt(i + 1)) {
				// 다음 수에서 1로 바뀌는 경우 
				if (data.charAt(i + 1) == '1') count0 += 1;
				else count1 += 1;
			}
		}
		
		System.out.println(Math.min(count0, count1));
	}

}
