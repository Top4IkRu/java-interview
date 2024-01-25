import java.io.*;
import java.util.StringTokenizer;

public class Task1328C {
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
            String x = sc.nextLine();
            int[] f = new int[x.length()];
            int[] s = new int[x.length()];
            int min = 0;
            int index = 0;
            for (char c : x.toCharArray()) {
                if (min == 0) {
                    if (c == '2') {
                        f[index] = s[index] = 1;
                    } else if (c == '1') {
                        min = 1;
                        f[index] = 1;
                        s[index] = 0;
                    } else {
                        f[index] = s[index] = 0;
                    }
                } else {
                    f[index] = 0;
                    s[index] = (int) c - 48;
                }
                index++;
            }
            for (int j = 0; j < x.length(); j++) out.print(f[j]);
            out.println();
            for (int j = 0; j < x.length(); j++) out.print(s[j]);
            out.println();
        }

        out.close();
    }

}
