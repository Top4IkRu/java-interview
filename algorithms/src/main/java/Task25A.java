import java.io.*;
import java.util.StringTokenizer;

public class Task25A {
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
        int evenCount = 0;
        int firstEvenIndex = -1;
        int oddCount = 0;
        int firstOddIndex = -1;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            if (evenCount == 0 && k % 2 == 0) firstEvenIndex = i;
            if (oddCount == 0 && k % 2 != 0) firstOddIndex = i;
            if (k % 2 == 0) evenCount++;
            else oddCount++;
            if ((evenCount >= 2 && oddCount == 1) || (oddCount >= 2 && evenCount == 1)) break;
        }
        out.println(evenCount == 1 ? firstEvenIndex + 1 : firstOddIndex + 1);

        out.close();
    }

}
