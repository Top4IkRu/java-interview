import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Round_919_Task2 {
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


        int caseNumbers = sc.nextInt();
        for (int i = 0; i < caseNumbers; i++) {
            int arrSize = sc.nextInt();
            int[] arr = new int[arrSize];

            int maxDropNumber = sc.nextInt();
            int maxNegativeNumber = sc.nextInt();

            int arrSum = 0;

            for (int j = 0; j < arrSize; j++) {
                arr[j] = sc.nextInt();
                arrSum += arr[j];
            }
            Arrays.sort(arr);


            int r = arrSize - maxDropNumber;
            int maxSum = 0;
            int c = 0;
            for (int j = r - 1; j >= 0; j--) {
                if (c == maxNegativeNumber) {
                    maxSum += arr[j];
                } else {
                    maxSum -= arr[j];
                    c++;
                }
            }

            int l = r - maxNegativeNumber;
            int tmpSum = maxSum;
            while (r < arrSize) {
                tmpSum -= arr[r];
                if (l >= 0) tmpSum += 2 * arr[l];
                l++;
                r++;
                maxSum = Math.max(maxSum, tmpSum);
            }

            out.println(maxSum);
        }

        out.close();
    }
}

            /*

            6 4
            1 2 3 3 3 4 5 8 9 200


            1 2 3 3 [3] | 4 5 8 9 200

*/
