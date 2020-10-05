package leetcode.thirtyDay;

import java.util.Scanner;

public class MaxJump {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Ans is : " + canJump(arr));

    }

    public static boolean canJump(int[] nums) {
        if (nums.length==0) return false;
        int maxSoFar=0;
        for (int i=0;i<nums.length;i++) {
            if (i>maxSoFar) {
                return false;
            }
            if (nums[i]+i>maxSoFar) {
                maxSoFar=nums[i]+i;
            }

        }
        return true;
    }
}
