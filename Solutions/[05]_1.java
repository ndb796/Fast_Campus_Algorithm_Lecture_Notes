import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Node {
	public int age;
	public String name;

	public Node(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Node> data = new ArrayList<Node>();
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			String y = sc.next();
			data.add(new Node(x, y));
		}
		
		Collections.sort(data, new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				return Integer.compare(a.age, b.age);
			}
		});
		
		for (Node node: data) {
			System.out.println(node.age + " " + node.name);
		}
	}

}
