import java.io.*;
import java.util.StringTokenizer;

public class Task363B {
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
        int k = sc.nextInt();
        int[] h = new int[n];

        int start = 0;
        int minSum = Integer.MAX_VALUE;

        int tmpSum = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            h[i] = num;

            tmpSum += num;
            if (i == k - 1) {
                minSum = tmpSum;
            }
            if (i > k - 1) {
                tmpSum -= h[i - k];
                if (tmpSum < minSum) {
                    minSum = tmpSum;
                    start = i - k + 1;
                }
            }

        }
        out.println(start + 1);

        out.close();
    }
}
