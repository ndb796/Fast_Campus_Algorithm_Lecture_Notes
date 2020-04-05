import java.util.Scanner;

public class Main {

	public static int N, X, Y, result = 0;
	
	public static void solve(int n, int x, int y) {
		if (n == 2) {
			if (x == X && y == Y) {
				System.out.println(result);
				return;
			}
			result++;
			if (x == X && y + 1 == Y) {
				System.out.println(result);
				return;
			}
			result++;
			if (x + 1 == X && y == Y) {
				System.out.println(result);
				return;
			}
			result++;
			if (x + 1 == X && y + 1 == Y) {
				System.out.println(result);
				return;
			}
			result++;
			return;
		}
		solve(n / 2, x, y);
		solve(n / 2, x, y + n / 2);
		solve(n / 2, x + n / 2, y);
		solve(n / 2, x + n / 2, y + n / 2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		
		solve((int) Math.pow(2, N), 0, 0);
	}

}
