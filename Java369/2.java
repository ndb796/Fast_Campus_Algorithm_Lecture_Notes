import java.util.*;
import java.io.*;
 
public class Main {

    public static int n, k;
    public static int[] arr = new int[100000];

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        n = fr.nextInt();
        k = fr.nextInt();
        // 모든 공격력 입력받기
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }
        // 앞에서부터 하나씩 공격력을 더해서 그 합이 k보다 커지는 지점 찾기
        long sum = 0;
        int maxValue = arr[0];
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            // 가장 큰 공격력의 값과 인덱스 기록
            if (maxValue < arr[i]) {
                maxValue = arr[i];
                maxIndex = i;
            }
            // 합이 k보다 크다면 중지
            sum += arr[i];
            if (sum > k) break;
        }
        // 건너뛰지 않아도 괜찮은 경우
        if (sum <= k) {
            System.out.println(n);
        }
        // 건너뛰어야 하는 경우
        else {
            // 가장 큰 공격력 제거
            arr[maxIndex] = 0;
            sum = 0;
            // 다시 앞에서부터 하나씩 공격력을 더해서 정답 계산
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > k) {
                    System.out.println(i - 1);
                    break;
                }
            }
            if (sum <= k) {
                System.out.println(n - 1);
            }
        }
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