import java.util.*;
import java.io.*;
 
public class Main {
 
    public static int n;
    public static int[] arr = new int[300001];
    public static int[] leaves = new int[300001];
    public static long[] sum = new long[300001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    public static long result;
 
    // 단방향 트리 구조이므로, 방문 정보를 기록할 필요 없음
    public static void dfs(int x) {
        // 리프 노드인 경우
        if (graph.get(x).size() == 0) {
            leaves[x] = 1;
        }
        // 인접 노드를 하나씩 확인하며
        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            dfs(y);
            // 서브 트리에 포함된 원소의 합과 리프 노드의 수 계산
            sum[x] += sum[y];
            leaves[x] += leaves[y];
        }
        result = Math.max(result, (long) Math.ceil((double) sum[x] / leaves[x]));
    }
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 2; i <= n; i++) {
            int x = fr.nextInt();
            graph.get(x).add(i);
        }
        // 각 노드의 값 입력받기
        for (int i = 1; i <= n; i++) {
            arr[i] = fr.nextInt();
            sum[i] = arr[i];
        }
        dfs(1);
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