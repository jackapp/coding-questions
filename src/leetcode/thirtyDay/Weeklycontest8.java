package leetcode.thirtyDay;

import java.util.Scanner;

public class Weeklycontest8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter the value which you want to search");
        int k = in.nextInt();
        System.out.println("Ans is " + binarySearchWithOffset(arr,k));

    }

    public static int findRotation(int arr[]) {
        return findRotation(arr,0,arr.length-1,(arr.length-1)/2);
    }
    public static int binarySearchWithOffset(int arr[],int elementToSearch) {
        int offset = findRotation(arr);
        return binarySearch(arr,elementToSearch,0,(arr.length-1)/2,arr.length-1,offset);
    }

    public static int binarySearch(int arr[], int valueToSearch, int low, int mid, int high,int offSet) {
        int newLow = (low+offSet)%arr.length;
        int newHigh = (high+offSet)%arr.length;
        int newMid = (mid+offSet)%arr.length;

        if (mid == low || mid == high) {
            if (valueToSearch == arr[newLow]) {
                return newLow;
            } else if (valueToSearch == arr[newHigh]) {
                return newHigh;
            } else {
                return -1;
            }
        } else {
            int val;
            val = arr[newLow] == valueToSearch ? newLow : arr[newHigh] == valueToSearch ? newHigh : valueToSearch == arr[newMid] ? newMid : -1;
            if (val != -1) {
                return val;
            }
            if (arr[newMid] > valueToSearch) {
                return binarySearch(arr, valueToSearch, low, (mid + low) / 2, mid,offSet);
            } else {
                return binarySearch(arr, valueToSearch, mid, (mid + high) / 2, high,offSet);
            }


        }
    }


    public static int findRotation(int arr[],int start,int end,int mid) {
        if (arr[start]<=arr[mid] && arr[mid]<=arr[end]) {
          return start;
        } else if (start==mid || end==mid) {
           int val = arr[start]>arr[mid]?mid:arr[mid]<arr[end]?mid:end;
           return val;
        } else {
            if (arr[start]>arr[mid]) {
                return findRotation(arr,start+1,mid,(start+mid+1)/2);
            } else {
                return findRotation(arr,mid+1,end,(mid+end+1)/2);
            }
        }
    }

  /*

    public int search(int[] nums, int target) {
        return 1;
    }
    public static int binarySearch(int arr[], int valueToSearch) {
        return binarySearch(arr, valueToSearch, 0, (arr.length - 1) / 2, arr.length - 1);
    }

    public static int binarySearch(int arr[], int valueToSearch, int low, int mid, int high) {
        if (mid == low || mid == high) {
            if (valueToSearch == arr[low]) {
                return low;
            } else if (valueToSearch == arr[high]) {
                return high;
            } else {
                return -1;
            }
        } else {
            int val;
            val = arr[low] == valueToSearch ? low : arr[high] == valueToSearch ? high : valueToSearch == arr[mid] ? mid : -1;
            if (val != -1) {
                return val;
            }

            if (arr[mid] > valueToSearch) {
                return binarySearch(arr, valueToSearch, low, (mid + low) / 2, mid);
            } else {
                return binarySearch(arr, valueToSearch, mid, (mid + high) / 2, high);
            }


        }
    }
     */

}
