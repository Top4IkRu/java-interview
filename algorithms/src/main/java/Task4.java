import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Task4 {
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

    static class Element implements Comparable<Element> {
        Element next;
        Element prev;
        int id;
        int value;

        public Element(int id, int value) {
            this.id = id;
            this.value = value;
        }

        public void setNext(Element next) {
            this.next = next;
            if (next != null) next.prev = this;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
            if (prev != null) prev.next = this;
        }

        @Override
        public int compareTo(Element other) {
            if (this.value != other.value) {
                return Integer.compare(this.value, other.value);
            }
            return Integer.compare(this.id, other.id);
        }

    }

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            TreeSet<Element> treeSet = new TreeSet<>();
            Element prev = null;
            for (int j = 0; j < len; j++) {
                int val = sc.nextInt();
                Element element = new Element(j, val);
                treeSet.add(element);
                if (prev != null) element.setPrev(prev);
                prev = element;
            }

            boolean failed = false;
            for (int j = 0; j < len - 1; j++) {
                Element maxEl = treeSet.pollLast();
                if (maxEl.value == 0) {
                    failed = true;
                    break;
                }
                if (
                        (maxEl.next != null && maxEl.next.value >= maxEl.value - 1) ||
                                (maxEl.prev != null && maxEl.prev.value >= maxEl.value - 1)
                ) {
                    if (maxEl.next != null) {
                        maxEl.next.setPrev(maxEl.prev);
                    } else {
                        maxEl.prev.setNext(maxEl.next);
                    }
                } else {
                    failed = true;
                    break;
                }
            }
            out.println(failed || treeSet.size() != 1 || treeSet.pollLast().value != 0 ? "NO" : "YES");
        }
        out.close();
    }

}
