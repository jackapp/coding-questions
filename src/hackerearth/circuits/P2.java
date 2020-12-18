package hackerearth.circuits;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class P2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int Q = in.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        for (int i=0;i<N;i++) {
            for (int j=i;j<N;j++) {
                if (arr[i]< arr[j] && findSumOfDigits(arr[i]) > findSumOfDigits(arr[j])) {
                    arr[i]=j+1;
                    break;
                } else {
                    if (j==N-1) {
                        arr[i]=-1;
                    }
                }
            }
        }

        for (int i=0;i<Q;i++) {
            System.out.println(arr[in.nextInt()-1]);
        }
    }


    public static int findSumOfDigits(int n) {
        int sum=0;

        while (n>0) {
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}
