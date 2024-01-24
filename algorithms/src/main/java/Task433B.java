import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task433B {
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

        long[] v = new long[n];
        long[] u = new long[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextLong();
            u[i] = v[i];
        }
        Arrays.sort(u);

        long vSum = 0;
        long uSum = 0;
        for (int i = 0; i < n; i++) {
            vSum += v[i];
            v[i] = vSum;

            uSum += u[i];
            u[i] = uSum;
        }


        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (t == 1) {
                out.println(v[r - 1] - (l > 1 ? v[l - 2] : 0));
            } else {
                out.println(u[r - 1] - (l > 1 ? u[l - 2] : 0));
            }
        }

        out.close();
    }

}
