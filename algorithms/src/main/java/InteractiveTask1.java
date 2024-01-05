import java.io.*;
import java.util.StringTokenizer;

/**
 * <a href="https://codeforces.com/gym/101021/problem/1">Task</a>
 */
public class InteractiveTask1 {
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

        int i = 0;
        boolean done = false;
        int l = 1;
        int r = 1_000_000;
        String sign;
        while (!done && i <= 25) {
            int m = (l + r) / 2 + 1;
            out.println(m);
            out.flush();
            i++;
            sign = sc.nextLine();
            if (sign.equals("<")) {
                r = m - 1;
            } else {
                l = m;
            }
            done = r == l;
        }
        out.print("! ");
        out.print(r);
        out.close();
    }

}
