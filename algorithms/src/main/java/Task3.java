import java.io.*;
import java.util.StringTokenizer;

public class Task3 {
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

        int count = sc.nextInt();
        for (int k = 0; k < count; k++) {

            int counter = 0;
            int sPrev = Integer.MAX_VALUE;
            int tPrev = Integer.MAX_VALUE;

            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (a <= sPrev && a <= tPrev) {
                    if (sPrev <= tPrev) sPrev = a;
                    else tPrev = a;
                } else if (a > sPrev && a > tPrev) {
                    if (sPrev <= tPrev) sPrev = a;
                    else tPrev = a;
                    counter++;
                } else if (a > sPrev) {
                    tPrev = a;
                } else {
                    sPrev = a;
                }
            }
            out.println(counter);
        }
        out.close();
    }
}
