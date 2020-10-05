package leetcode.thirtyDay;

import java.util.Scanner;

public class ModifiedBinarySearch {
    static int global;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int badVersion = in.nextInt();
        global=badVersion;
        System.out.println("First bad version is :" + firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        return binarySearch(1,(n+1)/2,n);
    }

    public static int binarySearch(int low,int mid,int high) {
        if (low==mid) {
           return isBadVersion(mid)?mid:high;
        } else if (mid==high) {
            return isBadVersion(low)?low:mid;
        } else  {
            if (!isBadVersion(mid)) {
                return binarySearch(mid+1,calculateMid(mid,high),high);
            } else {
                return binarySearch(low+1,calculateMid(low,mid),mid);
            }
        }
    }
    public static int calculateMid(int low,int high) {
        return ((high-low)/2 + low);
    }

    public static boolean isBadVersion(int pos) {
        if (pos>=global) return true;
        return false;
    }
}
