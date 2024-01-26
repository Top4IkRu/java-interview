import java.io.*;
import java.util.StringTokenizer;

public class Task327A {
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

        int t = sc.nextInt();

        int curSum = 0;
        int maxSum = 0;
        int ones = 0;

        for (int i = 0; i < t; i++) {
            int v = sc.nextInt();
            if (v == 1) ones++;
            curSum += v == 0 ? 1 : -1;
            if (curSum > maxSum) maxSum = curSum;
            if (curSum < 0) curSum = 0;
        }

        out.println(maxSum == 0 ? ones - 1 : maxSum + ones);
        out.close();
    }

}
