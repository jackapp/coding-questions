package geeks;

import java.util.Scanner;


public class RowColumnWiseSortedMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t =in.nextInt();

        while (t-- >0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int arr[][] = new int[n][m];

            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    arr[i][j] = in.nextInt();
                }
            }
            int x = in.nextInt();
           boolean found =  search(arr,x);
            System.out.println(found?"1":"0");
        }
    }

    private static boolean search(int arr[][],int x) {
        int i=0,j=arr[0].length-1;
        boolean found=false;
        int n = arr.length;
        int m = arr[0].length;
        while (i>=0 && i <arr.length && j>=0 && j<arr[0].length) {
            if (arr[i][j]==x) {
                return true;
            } else if (arr[i][j]<x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }


}
