import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task489B {
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
        int[] men = new int[n];
        for (int i = 0; i < n; i++) {
            men[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] women = new int[m];
        for (int i = 0; i < m; i++) {
            women[i] = sc.nextInt();
        }

        Arrays.sort(men);
        Arrays.sort(women);

        int mI = 0, wI = 0;
        int pairs = 0;
        while (mI < n && wI < m) {
            while (wI < m && men[mI] - women[wI] > 1) wI++;
            while (mI < n && wI< m && women[wI] - men[mI] > 1) mI++;
            if (mI < n && wI< m && Math.abs(men[mI] - women[wI]) <= 1) {
                pairs++;
                mI++;
                wI++;
            }
        }
        out.println(pairs);
        out.close();
    }

}
