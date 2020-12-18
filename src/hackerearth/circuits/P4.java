package hackerearth.circuits;

import java.util.Scanner;

public class P4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }

        int t=n;
        int ans=0;
        int counter=0;
        while (counter<n) {
            int N = arr[counter];
            counter=counter+N+1;
            t--;
        }
        ans+=counter-n;
        ans+=t;

        System.out.println(ans);
    }
}
