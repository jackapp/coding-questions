package geeks;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();

            int arr[] = new int[n];
            PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
                @Override
                public int compare(Integer o, Integer t1) {
                    return t1.compareTo(o);
                }
            });
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int k = in.nextInt();

            for (int i = 0; i < k; i++) {
                pq.add(arr[i]);
            }

            for (int i = k; i <n; i++) {
                if (pq.peek()> arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }

            System.out.println(pq.peek());
        }
    }
}
