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
 
    public static int n, m;
    public static Pair[] mine = new Pair[3000];
    public static Pair[] enemy = new Pair[3000];
    public static int[] map = new int[1000002];
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        m = fr.nextInt();
 
        for (int i = 0; i < n; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            mine[i] = new Pair(a, b);
        }
 
        for (int i = 0; i < m; i++) {
            int c = fr.nextInt();
            int d = fr.nextInt();
            enemy[i] = new Pair(c, d);
        }
 
        // 위쪽으로 이동해야 하는 거리 계산
        for (int i = 0; i < m; i++) {
            Pair x = enemy[i];
            for (int j = 0; j < n; j++) {
                Pair y = mine[j];
                if (x.first >= y.first) {
                    map[x.first - y.first] = Math.max(map[x.first - y.first], x.second - y.second + 1);
                }
            }
        }
 
        // 값 재조정
        int maxValue = 0;
        for (int i = 1000001; i >= 0; i--) {
            maxValue = Math.max(maxValue, map[i]);
            map[i] = maxValue;
        }
 
        // 최종 결과 출력
        int result = 1000001;
        for (int i = 0; i <= 1000001; i++) {
            result = Math.min(result, i + map[i]);
        }
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