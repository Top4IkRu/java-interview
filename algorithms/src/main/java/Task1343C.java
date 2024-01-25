import java.io.*;
import java.util.StringTokenizer;

public class Task1343C {
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
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            long sum = 0;
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                int v = sc.nextInt();
                if (j == 0) {
                    tmp = v;
                } else {
                    if (v > 0) {
                        if (tmp < 0) {
                            sum += tmp;
                            tmp = v;
                        } else if (v > tmp) {
                            tmp = v;
                        }
                    } else {
                        if (tmp > 0) {
                            sum += tmp;
                            tmp = v;
                        } else if (v > tmp) {
                            tmp = v;
                        }
                    }
                }
            }
            out.println(sum + tmp);
        }
        out.close();
    }

}
