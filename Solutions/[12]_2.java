import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n + 1][k + 1];
		
		for (int i = 1; i <= n; i++) {
			int weight = sc.nextInt();
			int value = sc.nextInt();
			for (int j = 1; j <= k; j++) {
				if (j < weight) {
					dp[i][j] = dp[i - 1][j];
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
