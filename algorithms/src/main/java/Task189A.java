import java.io.*;
import java.util.StringTokenizer;

public class Task189A {
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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max = 0;

        // z =  (n - ax - by) / c
        for (int x = 0; x <= n / a; x++) {
            for (int y = 0; y <= (n - x * a) / b; y++) {
                int diff = n - a * x - b * y;
                int z = diff / c;
                if (diff % c == 0 && x + y + z > max && x * a + y * b + z * c == n) {
                    max = x + y + z;
                }
            }
        }
        out.println(max);
        out.close();
    }
}
