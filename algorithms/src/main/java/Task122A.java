import java.io.*;
import java.util.StringTokenizer;

public class Task122A {
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

        int i = n;
        boolean r = i % 10 == 4 || i % 10 == 7;
        while (r && i != 0) {
            if (i % 10 != 4 && i % 10 != 7) {
                r = false;
                break;
            }
            i = i / 10;
        }

        if (!r) {
            int d = 4;
            while (d < n) {
                if (n % d == 0) {
                    r = true;
                    break;
                }

                int newD = 0;
                int j = 0;
                boolean inc = false;

                while (d != 0) {
                    int k = d % 10;
                    if (j == 0 || inc) {
                        newD += (int) (Math.pow(10, j) * (k == 4 ? 7 : 4));
                        inc = k == 7;
                    } else {
                        newD += (int) (Math.pow(10, j) * (k == 4 ? 4 : 7));
                    }
                    j++;
                    d = d / 10;
                }

                if (inc) newD += (int) (Math.pow(10, j) * 4);
                d = newD;
            }
        }

        out.println(r ? "YES" : "NO");

        out.close();
    }

}
