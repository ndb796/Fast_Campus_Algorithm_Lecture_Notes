import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < n.length(); j++) {
				if (n.charAt(j) - '0' == i) {
					System.out.print(i);
				}
			}
		}
	}

}
