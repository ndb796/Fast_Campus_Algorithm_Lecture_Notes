import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n, m;
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> finding = new ArrayList<Integer>();
		
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			finding.add(sc.nextInt());
		}
		for (int i = 0; i < m; i++) {
			if (set.contains(finding.get(i))) System.out.println("1");
			else System.out.println("0");
		}
	}

}
