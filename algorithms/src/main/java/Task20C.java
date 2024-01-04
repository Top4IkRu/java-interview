import java.io.*;
import java.util.*;

public class Task20C {
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

    static long[] distance;
    static long INF = Long.MAX_VALUE;

    static int[] parents;

    static List<Edge>[] edges;
    static boolean[] visited;

    static class Edge {
        int number;
        long weight;

        public Edge(int number, long weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        int m = sc.nextInt();

        distance = new long[n + 1];
        parents = new int[n + 1];
        edges = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i < distance.length; i++) {
            distance[i] = INF;
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            long w = sc.nextLong();
            edges[s].add(new Edge(e, w));
            edges[e].add(new Edge(s, w));
        }

        if (dijkstra(1, n)) {
            StringBuilder ans = new StringBuilder();
            List<Integer> path = new ArrayList<>();

            for (int e = n; e != -1; e = parents[e])
                path.add(e);

            // reversing path
            for (int i = path.size() - 1; i >= 0; i--) {
                ans.append(path.get(i)).append(" ");
            }
            out.println(ans);
        } else {
            out.print("-1");
        }


        out.close();
    }

    private static boolean dijkstra(int start, int end) {
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.weight));
        pq.add(new Edge(start, 0));
        parents[start] = -1;
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Edge from = pq.poll();
            int s = from.number;
            visited[s] = true;
            if (s == end) return true;

            for (Edge to : edges[s]) {
                int e = to.number;
                long w = to.weight;
                if (!visited[e] && distance[s] + w < distance[e]) {
                    distance[e] = distance[s] + w;
                    pq.add(new Edge(e, distance[e]));
                    parents[e] = s;
                }
            }
        }

        return false;
    }

}