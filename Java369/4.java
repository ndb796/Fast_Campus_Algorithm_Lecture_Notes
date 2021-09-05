import java.util.*;
import java.io.*;
 
public class Main {
 
    public static int na, nb;
    public static int[] a;
    public static int[] b;
    public static long result;
 
    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
 
    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
 
    public static void process(int[] a, int[] b) {
        for (int x = 0; x < a.length; x++) {
            int index = upperBound(b, a[x], 0, b.length) - 1;
            if (index == -1) continue;
            result = Math.min(result,
                (long) (a[x] - b[index]) * (a[x] - b[index])
            );
        }
    }
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        // 국가 A와 B에 대한 데이터 입력받기
        na = fr.nextInt();
        nb = fr.nextInt();
        a = new int[na];
        b = new int[nb];
        for (int i = 0; i < na; i++) {
            a[i] = fr.nextInt();
        }
        for (int i = 0; i < nb; i++) {
            b[i] = fr.nextInt();
        }

        // 정렬 수행
        Arrays.sort(a);
        Arrays.sort(b);

        // 정렬된 배열에 대하여 이진 탐색을 통해 정답 계산
        result = (long) 9e18;
        process(a, b);
        process(b, a);
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