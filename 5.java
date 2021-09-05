import java.util.*;
import java.io.*;
 
public class Main {
 
    public static class Pair {
        public int first;
        public int second;
 
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
 
    public static Pair dfs(int x, int parent) {
        int g = 0;
        int b = 0;
        if (arr[x] == 1) g = 1;
        else if (arr[x] == 2) b = 1;
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (y == parent) continue; // 자기 부모로 다시 가지 않도록 방지
            Pair temp = dfs(y, x);
            // 서브 트리에 초록색만 포함된 경우
            if (temp.first == green && temp.second == 0) {
                result++;
            }
            // 서브 트리에 파란색만 포함된 경우
            if (temp.first == 0 && temp.second == blue) {
                result++;
            }
            g += temp.first;
            b += temp.second;
        }
        return new Pair(g, b);
    }
 
    public static int n;
    public static int green, blue;
    public static int result;
    public static int[] arr = new int[500000];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
            if (arr[i] == 1) green += 1;
            else if (arr[i] == 2) blue += 1;
        }
        // 그래프 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x = fr.nextInt() - 1;
            int y = fr.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        // 0번 노드를 기준으로 DFS 수행
        dfs(0, -1);
        System.out.println(result);
    }
 
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}