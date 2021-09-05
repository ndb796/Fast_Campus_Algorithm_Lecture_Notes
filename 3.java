import java.util.*;
import java.io.*;
 
public class Main {
 
    public static int n;
    public static int[] arr, flag, result;
 
    public static void main(String[] args) {
        FastReader fr = new FastReader();

        n = fr.nextInt();
        arr = new int[n];
        flag = new int[n];

        // 각 원소의 값 입력 받기
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }
        // 각 원소의 고정 여부 입력 받기
        for (int i = 0; i < n; i++) {
            flag[i] = fr.nextInt();
        }

        // 고정된 원소를 제외한 다른 원소를 내림차순 정렬
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) {
                list.add(arr[i]);
            }
        }
        Collections.sort(list, Collections.reverseOrder());

        // 최종적인 배열
        result = new int[n];
        for (int i = 0; i < n; i++) {
            if (flag[i] == 0) result[i] = list.removeFirst();
            else result[i] = arr[i];
        }

        // 결과 계산
        int k = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += result[i];
            if (sum < 0) {
                k = i + 1;
            }
        }
        System.out.println(k);
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