import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		char[][] data = new char[50][50];
		int[] row = new int[50];
		int[] column = new int[50];

		for (int i = 0; i < n; i++) {
			data[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < m; j++) {
				if (data[i][j] == 'X') {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}

		int row_count = 0;
		for (int i = 0; i < n; i++) {
			if (row[i] == 0) row_count++;
		}

		int column_count = 0;
		for (int j = 0; j < m; j++) {
			if (column[j] == 0) column_count++;
		}

		System.out.println(Math.max(row_count, column_count));
	}

}
