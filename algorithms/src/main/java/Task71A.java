import java.io.*;
import java.util.StringTokenizer;

public class Task71A {
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

        String[] words = new String[n];
        for (int i = 0; i < n; i++) words[i] = sc.nextLine();
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 10) {
                out.println(words[i]);
            } else {
                out.println(
                        words[i].charAt(0) + String.valueOf(words[i].length() - 2) + words[i].charAt(words[i].length() - 1)
                );
            }
        }


        out.close();
    }

}
