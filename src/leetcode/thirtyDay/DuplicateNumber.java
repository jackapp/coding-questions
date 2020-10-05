package leetcode.thirtyDay;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicateNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = in.nextInt();
        int arr[] = new int[n];
       for (int i = 0;i<n;i++) {
           arr[i] = in.nextInt();
       }
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int arr[]) {
        int start=0;
        for (int i=0;i<arr.length;i++) {
            start=start^arr[i];
        }
        return start;
    }
}
