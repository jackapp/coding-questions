package hackerearth.circuits;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class P8 {

    public void solve() {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int n = in.readInt();
        CustomObj []ar = new CustomObj[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            int val = Math.abs(x+y);
            ar[i] = new CustomObj(val,val);
        }
        SegmentTree tree = new SegmentTree(ar);
        List<List<CustomObj>> list = new ArrayList();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>(Arrays.asList(ar[i])));
        }

        int q = in.readInt();

        for (int i = 0; i < q; i++) {
            String s = in.readString();

            if (s.charAt(0)=='+') {
                int pos = in.readInt();
                int x = in.readInt();
                int y = in.readInt();

                list.get(pos).add(new CustomObj(Math.abs(x+y),Math.abs(x+y)));
                tree.update(pos-1,Math.abs(x+y));

            } else {
                int l = in.readInt();
                int r = in.readInt();
                int k = in.readInt();

                int max = tree.max(l-1,r-1);
                int min = tree.min(l-1,r-1);
                //System.out.println(min);

                int newmax = Math.abs(max-k)>Math.abs(min-k)?max:min;
                int newmin;
                if (newmax==min) {
                    newmin = max;
                } else {
                    newmin = min;
                }

                if (isInsideRange(min,max,k)) {

                    //Find the nearest number
                    int left = l-1;
                    int right = r-1;

                    newmin = tree.whatever(left,right,k);

                    long ans1 = newmax-k;
                    ans1=ans1*ans1;

                    long ans2 = newmin-k;
                    ans2 = ans2*ans2;


                    out.printLine(Math.abs(ans1-ans2));


                } else {

                    long ans1 = newmax-k;
                    ans1=ans1*ans1;

                    long ans2 = newmin-k;
                    ans2 = ans2*ans2;


                    out.printLine(Math.abs(ans1-ans2));
                }

            }
        }
        out.close();

    }

    private boolean isInsideRange(int min, int max, int k) {
        if (k<=max && k>=min) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P8 solver = new P8();
        solver.solve();

    }

    public static class SegmentTree {
        private final CustomObj[] tree;
        private final int n; // input array length

        public SegmentTree(CustomObj[] ar) {
            n = ar.length;
            tree = new CustomObj[n * 2];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new CustomObj();
            }
            // store into the right end of the array
            System.arraycopy(ar, 0, tree, n, n);

            for (int i = n - 1; i > 0; i--) {
                tree[i].max = Math.max(tree[2 * i].max, tree[2 * i + 1].max);
                tree[i].min = Math.min(tree[2 * i].min, tree[2 * i + 1].min);
            }

        }

        /**
         * @param i     - index to original array, inclusive
         * @param value - new value to be saved off
         */


        public void update(int i, int value) {
            i += n;
            if (tree[i].max<value) {
                tree[i].max = value;
                tree[i].min = value;
                int newValue;

                while (i > 1) {
                    i >>= 1; // shift right is the same as divide by 2
                    newValue = Math.max(tree[2 * i].max, tree[2 * i + 1].max);

                    if (tree[i].max != newValue) {
                        tree[i].max = newValue;
                    } else {
                        return; // since no update is made
                    }
                }
            } else if (tree[i].max>value){
                tree[i].max = value;
                tree[i].min = value;
                int newValue;

                while (i > 1) {
                    i >>= 1; // shift right is the same as divide by 2
                    newValue = Math.min(tree[2 * i].min, tree[2 * i + 1].min);

                    if (tree[i].min != newValue) {
                        tree[i].min = newValue;
                    } else {
                        return; // since no update is made
                    }
                }
            }

        }

        /**
         * Starts at the bottom of the tree and works its way up until reaching nodes that cover the requested range.
         * Note how we always start from the right end of the array. Then on each iteration of the loop, the index variables �from� and �to� are halved.
         * Thus, on each iteration we go up one level on the tree.
         * <p>
         * Note that we only invoke Math.max() function if the indexes �from� and �to� are odd. Why is that? It�s because if the index is even, then it�s
         * left child node. We don�t need to bother reading it since we�ll get another chance at doing it on the next level up. Of course, this same
         * logic applies on the next level up.
         *
         * @param from - inclusive
         * @param to   - exclusive
         * @return
         */
        public int max(int from, int to) {
            from += n; // go to second half of the array
            to += n;
            int max = Integer.MIN_VALUE;

            while (from <= to) {
                if ((from & 1) == 1) { // 'from' is odd, so it is the right child of its parent, then interval includes node 'from' but doesn't include its parent
                    max = Math.max(max, tree[from].max);
                    from++;
                }
                if ((to & 1) == 1) { // 'to' is odd, so it's the right child of its parent, then might as well use the parent
                    to--;
                    max = Math.max(max, tree[to].max);

                }
                from >>= 1; // shift right is the same as divide by 2 but a little faster
                to >>= 1;
            }

            return max;
        }


        public int whatever(int from, int to,int k) {
            from += n; // go to second half of the array
            to += n;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int closest=Integer.MAX_VALUE;
            while (from <= to) {
                if (from==1 || to ==1) {
                    break;
                }
                if ((from & 1) == 1) { // 'from' is odd, so it is the right child of its parent, then interval includes node 'from' but doesn't include its parent
                    max = Math.max(max, tree[from].max);
                    min = Math.min(min, tree[from].min);
                    if (closest>Math.abs(max-k)) {
                        closest=Math.abs(max-k);
                    }
                    if (closest<Math.abs(min-k)) {
                        closest=Math.abs(min-k);
                    }
                    from++;
                }
                if ((to & 1) == 1) { // 'to' is odd, so it's the right child of its parent, then might as well use the parent
                    to--;
                    max = Math.max(max, tree[to].max);
                    min = Math.min(min, tree[from].min);

                    max = Math.max(max, tree[from].max);
                    min = Math.min(min, tree[from].min);
                    if (closest>Math.abs(max-k)) {
                        closest=Math.abs(max-k);
                    }
                    if (closest<Math.abs(min-k)) {
                        closest=Math.abs(min-k);
                    }
                }
                from >>= 1; // shift right is the same as divide by 2 but a little faster
                to >>= 1;
            }

            return closest;
        }

        public int min(int from, int to) {
            from += n; // go to second half of the array
            to += n;
            int min = Integer.MAX_VALUE;

            while (from <= to) {
                if (from==1 || to ==1) {
                    break;
                }

                if ((from & 1) == 1) { // 'from' is odd, so it is the right child of its parent, then interval includes node 'from' but doesn't include its parent
                    min = Math.min(min, tree[from].min);
                    from++;
                }
                if ((to & 1) == 1) { // 'to' is odd, so it's the right child of its parent, then might as well use the parent
                    to--;
                    min = Math.min(min, tree[to].min);

                }
                from >>= 1; // shift right is the same as divide by 2 but a little faster
                to >>= 1;
            }

            return min;
        }

    }
    public static class CustomObj {
        int min;
        int max;

        public CustomObj(int min, int max) {
            this.min = min;
            this.max = max;
        }
        public CustomObj () {

        }
    }
























    
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }

    static class IOUtils {

        public static int[] readIntegerArray(InputReader in, int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readInt();
            }
            return array;
        }

        public static long[] readLongArray(InputReader in, int size) {
            long[] array = new long[size];
            for (int i = 0; i < size; i++) {
                array[i] = in.readLong();
            }
            return array;
        }

        public static List<Integer> readIntegerList(InputReader in, int size) {
            List<Integer> set = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                set.add(in.readInt());
            }
            return set;
        }

        public static Set<Integer> readIntegerSet(InputReader in, int size) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < size; i++) {
                set.add(in.readInt());
            }
            return set;
        }
    }
}