import java.io.*;
import java.util.StringTokenizer;

public class Task455A {
    public static PrintWriter out;

    private static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        long[] arr = new long[100001];
        int value;
        for (int i = 0; i < n; i++) {
            value = sc.nextInt();
            arr[value]++;
        }

        long[] temp = new long[100001];
        temp[0] = 0;
        temp[1] = arr[1];

        for (int i = 2; i <= 100000; i++) {
            temp[i] = Math.max(temp[i - 1], temp[i - 2] + arr[i] * i);
        }
        System.out.println(temp[100000]);

        out.close();
    }
}