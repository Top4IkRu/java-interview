import java.io.*;
import java.util.StringTokenizer;

public class Task279B {
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
        long t = sc.nextLong();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int max = 0;
        int last = 0;
        long tmp = t;
        for (int i = 0; i < n; i++) {
            if (tmp >= a[i]) {
                tmp -= a[i];
            } else {
                max = Math.max(i - last, max);
                if (a[i] > t) {
                    tmp = t;
                    last = i + 1;
                } else {
                    while (tmp < a[i] && last <= i) {
                        tmp += a[last];
                        last++;
                    }
                    tmp -= a[i];
                }
            }
        }
        max = Math.max(n - last, max);
        out.println(max);

        out.close();
    }

}
