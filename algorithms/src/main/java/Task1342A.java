import java.io.*;
import java.util.StringTokenizer;

public class Task1342A {
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
        while (n-- > 0) {
            long l = sc.nextInt();
            long r = sc.nextInt();

            long priceOne = sc.nextInt();
            long priceTwo = sc.nextInt();

            /*
            11 47
            8 101
             */
            long cost = 0;
            if (l != 0 || r != 0) {
                if (priceOne * 2 < priceTwo) {
                    cost += priceOne * (Math.abs(l) + Math.abs(r));
                } else {
                    long min = Math.min(l, r);
                    cost += priceTwo * min;
                    l -= min;
                    r -= min;
                    cost += Math.max(l, r) * priceOne;
                }

            }
            out.println(cost);
        }

        out.close();
    }

}
