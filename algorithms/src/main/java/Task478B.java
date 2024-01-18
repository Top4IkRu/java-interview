import java.io.*;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Task478B {
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

        long n = sc.nextInt();
        long m = sc.nextInt();

        Function<Long, Long> f = (k) -> k * (k - 1) / 2;

        long min = (n % m) * f.apply(n / m + 1) + (m - n % m) * f.apply(n / m);
        long max = f.apply(n - m + 1);

        out.println(min + " " + max);
        out.close();
    }
}
