import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Task5C {
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

        Stack<Integer> stack = new Stack<>();
        int tmpSum = 0;
        char[] arr = s.toCharArray();
        char c;
        int lastOpenBracketIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            c = arr[i];
            if (c == '(') {
                stack.push(i);
                if (tmpSum != 0) {
                    for (int j = lastOpenBracketIndex; j < i; j++) arr[j] = '+';
                    tmpSum = 0;
                }
            } else {
                if (!stack.isEmpty()) {
                    lastOpenBracketIndex = stack.pop();
                    tmpSum += 2;
                } else {
                    if (tmpSum != 0) {
                        for (int j = lastOpenBracketIndex; j < i; j++) arr[j] = '+';
                        tmpSum = 0;
                    }
                }
            }
        }
        if (tmpSum != 0) {
            for (int j = lastOpenBracketIndex; j < arr.length; j++) arr[j] = '+';
        }

        int max = 0;
        int counter = 0;

        tmpSum = 0;
        for (char value : arr) {
            if (value == '+') tmpSum++;
            else {
                if (tmpSum != 0) {
                    if (tmpSum > max) {
                        max = tmpSum;
                        counter = 1;
                    } else if (tmpSum == max) {
                        counter += 1;
                    }
                }
                tmpSum = 0;
            }
        }
        if (tmpSum != 0) {
            if (tmpSum > max) {
                max = tmpSum;
                counter = 1;
            } else if (tmpSum == max) {
                counter += 1;
            }
        }

        out.print(max);
        out.print(' ');
        out.print(counter == 0 ? 1 : counter);
        out.close();
    }
}