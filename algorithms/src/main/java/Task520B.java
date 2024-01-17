import java.io.*;
import java.util.StringTokenizer;

public class Task520B {
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
        int m = sc.nextInt();

        if (n > m) {
            out.println(n - m);
        } else {
            int counter = 0;
            while (n != m) {
                if (n > m) {
                    m += 1;
                } else {
                    if (m % 2 == 0) {
                        m /= 2;
                    } else {
                        m += 1;
                    }
                }
                counter++;
            }
            out.println(counter);
        }
        out.close();
    }

}
