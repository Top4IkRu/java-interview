import java.io.*;
import java.util.*;

public class Task230A {
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

        int s = sc.nextInt();
        int n = sc.nextInt();
        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(l -> l.get(0)));
        for (int i = 0; i < n; i++) pq.add(Arrays.asList(sc.nextInt(), sc.nextInt()));

        boolean done = true;
        while (done && !pq.isEmpty()) {
            List<Integer> dragonInfo = pq.poll();
            if (s <= dragonInfo.get(0)) {
                done = false;
            } else {
                s += dragonInfo.get(1);
            }
        }
        out.println(done ? "YES" : "NO");
        out.close();
    }

}
