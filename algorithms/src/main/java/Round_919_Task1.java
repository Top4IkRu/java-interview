import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Round_919_Task1 {
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


        int caseCounter = sc.nextInt();
        for (int i = 0; i < caseCounter; i++) {

            int ruleCounter = sc.nextInt();

            long l = 0;
            long r = Long.MAX_VALUE;
            Set<Long> ex = new HashSet<>();
            for (int j = 0; j < ruleCounter; j++) {
                int ruleNumber = sc.nextInt();
                long ruleValue = sc.nextInt();
                if (ruleNumber == 1) {
                    l = Math.max(ruleValue, l);
                } else if (ruleNumber == 2) {
                    r = Math.min(ruleValue, r);
                } else {
                    ex.add(ruleValue);
                }
            }

            long result;
            if (r < l) result = 0;
            else if (r == l) {
                result = ex.contains(r) ? 0 : 1;
            } else {
                long finalL = l;
                long finalR = r;
                result = r - l + 1 - ex.stream().filter(e -> e >= finalL && e <= finalR).count();
            }

            out.println(result);
        }
        out.close();
    }
}