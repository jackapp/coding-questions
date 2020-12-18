import java.util.ArrayList;
import java.util.List;

public class SegmentTreeCPlus {


    public static void main(String[] args) {
        int arr[] = {1, 8, 5, 9, 6, 14, 2, 4, 3, 7};
        int n = arr.length;

        // Build segment tree from given array
        List<node>st = constructST(arr, n);

        int qs = 0; // Starting index of query range
        int qe = 8; // Ending index of query range
        node result=MaxMin(st, n, qs, qe);

        // Print minimum and maximum value in arr[qs..qe]
        System.out.println("Minimum =" +result.minimum + "and Maximum =  " + result.maximum);

    }

    public static double log2(int N) {
        double result = (Math.log(N) / Math.log(2));
        return result;
    }


    public static class node {
        int minimum;
        int maximum;
    };

    // A utility function to get the middle index from corner indexes.
    static int getMid(int s, int e) { return s + (e -s)/2; }

    /* A recursive function to get the minimum and maximum value in
        a given range of array indexes. The following are parameters
        for this function.

        st --> Pointer to segment tree
        index --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
        ss & se --> Starting and ending indexes of the segment
                    represented by current node, i.e., st[index]
        qs & qe --> Starting and ending indexes of query range */

    static node MaxMinUntill(List<node> st, int ss, int se, int qs,
                             int qe, int index)
    {
        // If segment of this node is a part of given range, then return
        // the minimum and maximum node of the segment
        node tmp=new node();
        node left,right;
        if (qs <= ss && qe >= se)
            return st.get(index);

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
        {
            tmp.minimum = Integer.MAX_VALUE;
            tmp.maximum = Integer.MIN_VALUE;
            return tmp;
        }

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        left = MaxMinUntill(st, ss, mid, qs, qe, 2*index+1);
        right = MaxMinUntill(st, mid+1, se, qs, qe, 2*index+2);
        tmp.minimum = Math.min(left.minimum, right.minimum);
        tmp.maximum = Math.max(left.maximum, right.maximum);
        return tmp;
    }


    static node MaxMin(List<node> st, int n, int qs, int qe)
    {
        node tmp = new node();

        // Check for erroneous input values
        if (qs < 0 || qe > n-1 || qs > qe)
        {
            tmp.minimum = Integer.MAX_VALUE;
            tmp.minimum = Integer.MAX_VALUE;
            return tmp;
        }

        return MaxMinUntill(st, 0, n-1, qs, qe, 0);
    }

    // A recursive function that constructs Segment Tree for array[ss..se].
// si is index of current node in segment tree st
    static void constructSTUtil(int arr[], int ss, int se, List<node>st,
                                int si)
    {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (ss == se)
        {
            st.get(si).minimum = arr[ss];
            st.get(si).maximum = arr[ss];
            return ;
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the minimum and maximum of two values
        // in this node
        int mid = getMid(ss, se);
        constructSTUtil(arr, ss, mid, st, si*2+1);
        constructSTUtil(arr, mid+1, se, st, si*2+2);

        st.get(si).minimum = Math.min(st.get(si*2+1).minimum, st.get(si*2+2).minimum);
        st.get(si).maximum = Math.max(st.get(si*2+1).maximum, st.get(si*2+2).maximum);
    }

    /* Function to construct segment tree from given array. This function
    allocates memory for segment tree and calls constructSTUtil() to
    fill the allocated memory */
    static List<node> constructST(int arr[], int n) {
        // Allocate memory for segment tree

        // Height of segment tree
        int x = (int)(Math.ceil(log2(n)));

        // Maximum size of segment tree
        int max_size = (2*(int)Math.pow(2, x)) -1;

        List<node> st = new ArrayList<>();
        for (int i = 0; i < max_size; i++) {
            st.add(new node());
        }
        // Fill the allocated memory st
        constructSTUtil(arr, 0, n-1, st, 0);

        return st;
    }

}


