import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0, k = 1;
		
		while (n != 0) {
			if (k > n) k = 1;
			n -= k;
			k += 1;
			result += 1;
		}
		
		System.out.println(result);
	}

}
