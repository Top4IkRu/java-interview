import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task158B {
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

        int[] s = new int[sc.nextInt()];
        for (int i = 0; i < s.length; i++) {
            s[i] = sc.nextInt();
        }
        Arrays.sort(s);
        int start = 0;
        int end = s.length - 1;
        int counter = 0;

        while (start < s.length && end >= 0 && end >= start && s[end] == 4) {
            counter++;
            end--;
        }


        // 3 and 1
        while (start < s.length && end >= 0 && end >= start && s[end] == 3 && s[start] == 1) {
            counter++;
            start++;
            end--;
        }

        // 3 without 1
        while (start < s.length && end >= 0 && end >= start && s[end] == 3) {
            counter++;
            end--;
        }

        while (start < s.length && end >= 0 && end >= start && s[end] == 2 && s[start] == 1) {
            if (start + 1 <= end && s[start + 1] == 1) start++;
            counter++;
            start++;
            end--;
        }

        // only 1
        if (start < s.length && end >= 0 && end >= start && s[end] == 1 && s[start] == 1) {
            int num = end - start + 1;
            counter += num / 4;
            if (num % 4 != 0) counter++;
            end = start - 1;
        }

        // only 2
        while (start < s.length && end >= 0 && end >= start) {
            counter++;
            start++;
            end--;
        }

        out.println(counter);
        out.close();
    }

}
