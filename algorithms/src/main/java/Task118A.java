import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task118A {
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

        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s.length());
        Set<Integer> vowels = Stream.of('a', 'o', 'y', 'e', 'u', 'i').map(c -> (int) c).collect(Collectors.toSet());
        ;
        for (char c : s.toCharArray()) {
            char caseC = c;
            if (c < 97) caseC = (char) (c + 32);
            if (!vowels.contains((int) caseC)) sb.append('.').append(caseC);
        }
        out.println(sb);
        out.close();
    }

}
