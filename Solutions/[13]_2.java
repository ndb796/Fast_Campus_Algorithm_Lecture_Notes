import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> data = new ArrayList<Integer>();
		int[][] dp = new int[101][1001];
		
		for (int i = 0; i < n; i++) {
			data.add(sc.nextInt());
		}
		
		dp[0][s] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (dp[i - 1][j] == 0) continue;
				if (j - data.get(i - 1) >= 0) {
					dp[i][j - data.get(i - 1)] = 1;
				}
				if (j + data.get(i - 1) <= m) {
					dp[i][j + data.get(i - 1)] = 1;
				}
			}
		}
		
		int result = -1;
		for (int i = m; i >= 0; i--) {
			if (dp[n][i] == 1) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
	}

}
