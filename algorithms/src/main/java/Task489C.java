import java.io.*;
import java.util.StringTokenizer;

public class Task489C {
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

        int m = sc.nextInt();
        int s = sc.nextInt();

        if (s == 0 && m != 1) {
            out.println("-1 -1");
        } else {
            int restMaxSum = s;
            int restMinSum = s;
            int[] max = new int[m];
            int[] min = new int[m];

            for (int i = 0; i < m; i++) {
                int n = Math.min(restMaxSum, 9);
                restMaxSum -= n;
                max[i] = n;
                int k;
                if (i == m - 1) {
                    k = restMinSum;
                } else if (restMinSum == 1) {
                    k = 0;
                } else {
                    k = Math.min(9, restMinSum - 1);
                }
                restMinSum -= k;
                min[m - i - 1] = k;
            }

            if (restMaxSum != 0 || restMinSum != 0) {
                out.println("-1 -1");
            } else {
                for (int i = 0; i < m; i++) out.print(min[i]);
                out.print(" ");
                for (int i = 0; i < m; i++) out.print(max[i]);
            }
        }
        out.close();
    }

}
