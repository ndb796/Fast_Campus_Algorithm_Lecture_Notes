import java.util.*;
import java.io.*;
 
public class Main {
 
    public static int n, r;
    public static int[] t = new int[100001];
    public static int[] x = new int[100001];
    public static int[] y = new int[100001];
    public static int[] d = new int[100001];
    public static int maxValue;
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        r = fr.nextInt();
 
        // 처음(0초)에는 항상 (1, 1)의 위치
        x[0] = 1;
        y[0] = 1;
        for (int i = 1; i <= n; i++) {
            t[i] = fr.nextInt();
            x[i] = fr.nextInt();
            y[i] = fr.nextInt();
            d[i] = (int) -1e9; // 기본적으로 도달 불가능하다고 가정
            // (2 * r - 2) 범위인 경우에는 시간 내 도달 가능한지 확인 (오차 없이 정확함)
            for (int j = i - (2 * r - 2); j < i; j++) {
                if (j < 0) continue;
                // 시간 내 도달 가능하다면
                if (Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]) <= t[i] - t[j]) {
                    d[i] = Math.max(d[i], d[j] + 1); // 점화식에 따라 값 갱신
                }
            }
            // i가 커지면 무조건 [시간 내 도달 가능한] 경우가 생김
            if (i - 1 >= (2 * r - 2)) {
                // 바로 점화식에 따라서 갱신
                maxValue = Math.max(maxValue, d[i - 1 - (2 * r - 2)]);
                d[i] = Math.max(d[i], maxValue + 1);
            }
        }
        // 정답 출력
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result = Math.max(result, d[i]);
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