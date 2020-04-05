import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String document = sc.nextLine();
		String word = sc.nextLine();
		
		int idx = 0, result = 0;
		
		while (document.length() - idx >= word.length()) {
			if (document.substring(idx, idx + word.length()).equals(word)) {
				result += 1;
				idx += word.length();
			}
			else {
				idx++;
			}
		}
		
		System.out.println(result);
	}

}
