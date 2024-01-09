import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Task230B {
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
        Set<Long> set = calcSet();
        for (int i = 0; i < count; i++) {
            long number = sc.nextLong();
            out.println(set.contains(number) ? "YES" : "NO");
        }

        out.close();
    }

    private static Set<Long> calcSet() {
        int limit = 1000001;
        boolean[] arr = new boolean[limit];
        for (int i = 2; i*i < limit; i++) {
            if (!arr[i]) {
               for (int j = i*i; j < limit; j += i) {
                   arr[j] = true;
                }
            }
        }
        Set<Long> set = new HashSet<>();
        for (int i = 2; i < limit; i++) if (!arr[i]) set.add((long) i * i);
        return set;
    }
}
