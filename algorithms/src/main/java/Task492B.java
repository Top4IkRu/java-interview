import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task492B {
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
        int l = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        Arrays.sort(a);

        int maxLen = a[0] * 2;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] == a[i]) continue;
            int len = a[i] - a[i - 1];
            if (len > maxLen) maxLen = len;
        }
        int lastLen = (l - a[a.length - 1]) * 2;
        if (lastLen > maxLen) maxLen = lastLen;

        out.println(((double) maxLen) / 2);

        out.close();
    }

}