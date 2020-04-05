import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = 0;
		int b = 1;
		while (n > 0) {
			int temp = a;
			a = b;
			b = temp + b;
			n--;
		}
		
		System.out.println(a);
	}

}
