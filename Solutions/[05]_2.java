import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Node {
	public int x;
	public int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Node> data = new ArrayList<Node>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			data.add(new Node(x, y));
		}
		
		Collections.sort(data, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				// x 좌표의 값이 같다면, y의 값을 기준으로 정렬
				if (a.x == b.x) {
					return Integer.compare(a.y, b.y);
				}
				// x 좌표의 값이 다르다면, x의 값을 기준으로 정렬
				return Integer.compare(a.x, b.x);
			}
		});
		
		for (Node node: data) {
			System.out.println(node.x + " " + node.y);
		}
	}

}
