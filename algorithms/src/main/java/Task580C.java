import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Task580C {
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
        int m = sc.nextInt();

        int[] cats = new int[n];
        for (int i = 0; i < cats.length; i++) cats[i] = sc.nextInt();

        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            edges[s].add(e);
            edges[e].add(s);
        }

        int rest = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        int[] catsCounter = new int[n];
        boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            if (visited[node]) continue;
            visited[node] = true;
            int prev = cats[node] == 1 ? catsCounter[node] + 1 : 0;
            if (prev > m) continue;

            List<Integer> children = edges[node].stream().filter(c -> !visited[c]).collect(Collectors.toList());
            if (children.isEmpty()) {
                rest++;
            } else {
                q.addAll(children);
                for (Integer child : children) catsCounter[child] = prev;
            }
        }

        out.print(rest);
        out.close();
    }

}
