package hackerearth.circuits;

import java.util.Scanner;

public class P5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if (n==1) {
            System.out.println("-1");
            System.out.println("-1");
        } else {
            if (n%2==0) {
                System.out.println(n);
            } else {
                System.out.println(n+1);
            }
            printArr(findMinDifference(n));
            int arr[] = findMaximumDifference(n);
            System.out.println(findMaxDifference(arr));
            printArr(arr);
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static int[] findMinDifference(int n) {

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i+1;
        }
        if (n%2==0) {
            for (int i = 0; i < n; i=i+2) {
                int temp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1] = temp;
            }
        } else if (n==3){
            arr[0]=3;
            arr[1]=1;
            arr[2]=2;
        } else {
            for (int i = 3; i < n; i=i+2) {
                int temp = arr[i];
                arr[i]=arr[i+1];
                arr[i+1] = temp;
            }
            arr[0]=3;
            arr[1]=1;
            arr[2]=2;

        }
        return arr;
    }
    public static int findMaxDifference(int arr[]) {
        int diff=0;
        for (int i=0;i<arr.length;i++) {
            diff+=Math.abs(arr[i]-i-1);
        }
        return diff;
    }

    public static int[] findMaximumDifference(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i+1;
        }
        if (n%2==0) {
            int first=0,last=n-1;
            while (first<last) {
                //swap them
                int temp = arr[first];
                arr[first]=arr[last];
                arr[last] = temp;
                first++;
                last--;
            }
        } else if (n==3){
            arr[0]=2;
            arr[1]=3;
            arr[2]=1;
        } else {
            int first=0,last=n-1;
            while (last-first-1>=3) {
                //swap them
                int temp = arr[first];
                arr[first]=arr[last];
                arr[last] = temp;
                first++;
                last--;
            }
            int temp = arr[first];
            arr[first]=arr[first+1];
            arr[first+1]=arr[last];
            arr[last]=temp;

        }
        return arr;
    }
}
