import java.util.Arrays;

public class SegmentTree {
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

        while (from < to) {
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

    public int min(int from, int to) {
        from += n; // go to second half of the array
        to += n;
        int min = Integer.MAX_VALUE;

        while (from < to) {
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

    public static void main(String[] args) {
        //int[] ar = new int[]{6, 10, 5, 2, 7, 1, 0, 9};
        CustomObj[] ar = new CustomObj[8];
        ar[0] = new CustomObj(6,6);
        ar[1] = new CustomObj(10,10);
        ar[2] = new CustomObj(5,5);
        ar[3] = new CustomObj(2,2);
        ar[4] = new CustomObj(7,7);
        ar[5] = new CustomObj(1,1);
        ar[6] = new CustomObj(0,0);
        ar[7] = new CustomObj(9,9);



        SegmentTree tree = new SegmentTree(ar);
        //System.out.println(Arrays.toString(tree.tree));
        System.out.println("max=" + tree.max(1,  5));
        System.out.println("min=" + tree.min(1,  5));

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
}
