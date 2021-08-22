import java.util.*;
import java.io.*;
 
public class Main {

    public static int n, m;
    public static String[] switches = new String[500];
    public static int[] cnt = new int[500];

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        n = fr.nextInt();
        m = fr.nextInt();

        // 각 스위치에 연결된 전등 정보 입력받기
        for (int i = 0; i < n; i++) {
            switches[i] = fr.nextLine();
            // 각 전등마다 자신에게 연결된 스위치의 개수 입력받기
            for (int j = 0; j < m; j++) {
                if (switches[i].charAt(j) == '1') cnt[j]++;
            }
        }

        boolean found = false;
        // 두 개의 스위치 선택
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 두 스위치를 없애도 모든 전등을 켜는게 가능한지의 여부
                boolean check = true;
                // 각 전등을 하나씩 확인하며
                for (int k = 0; k < m; k++) {
                    int target = 0;
                    if (switches[i].charAt(k) == '1') target++;
                    if (switches[j].charAt(k) == '1') target++;
                    // 현재의 두 스위치가 없으면 안 되는 전등이라면
                    if (cnt[k] <= target) {
                        check = false;
                    }
                }
                // 두 스위치가 없어도 모든 전등이 켜질 수 있다면
                if (check) {
                    System.out.println("YES");
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        if (!found) System.out.println("NO");
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
