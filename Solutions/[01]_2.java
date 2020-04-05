import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n, m;
		int[] data = new int[100];
		int result = 0;
		
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = data[i] + data[j] + data[k];
					if (sum <= m) result = Math.max(result, sum);
				}
			}
		}
		System.out.println(result);
	}

}
