package misc;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = in.nextInt();
        System.out.println("Enter the elements of the array");
        int arr[] = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        moveZeroes(arr);
        System.out.println("The array after transforming is :-");

        for (int i=0;i<n;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }


    public static void moveZeroes(int nums[]) {
        int zeroCount=0,startFrom=-1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==0 && startFrom==-1) {
                startFrom=i;
            } else if (nums[i]!=0 && startFrom!=-1) {
                nums[startFrom]=nums[i];
                startFrom++;
            }
        }
        if (startFrom==-1) {
            startFrom=nums.length-zeroCount;
        }
        for (int i=startFrom;i<nums.length;i++) {
            nums[i]=0;
        }
    }

    public static int findMaxProductSubArray(int arr[]) {
        int counter=0;
        int prodBefore=1;
        int prodAfter=1,firstNeg;
        boolean noNeg=true;
        while (counter<arr.length&&arr[counter]!=0) {
            if (arr[counter]>0) {
                if (noNeg) {
                    prodBefore*=arr[counter];
                } else {

                }
            } else {
                if (noNeg) {
                    noNeg=false;
                    firstNeg=arr[counter];
                }
            }
        }
        return 1;
    }



    public int numberOfPiles(int arr[]) {
        return 1;
    }

}
