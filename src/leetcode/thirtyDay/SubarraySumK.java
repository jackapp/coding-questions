package leetcode.thirtyDay;

import java.util.*;

public class SubarraySumK {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println("Enter k");
        int k = in.nextInt();
        System.out.println("Ans is : " + subarraySum(arr,k));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        int prefix[] = new int[nums.length];
        int start=0;
        int sum=0;
        for (int i=0;i<nums.length;i++) {
            sum+=nums[i];
            prefix[i]=start;
            start+=nums[i];
        }
        start=0;
        for (int i=nums.length-1;i>=0;i--) {

            if (!rightMap.containsKey(start)) {
                rightMap.put(start,new ArrayList<>(Arrays.asList(i)));
            } else {
                rightMap.get(start).add(i);
            }
            start+=nums[i];
        }
        int count=0;
        for (int i=0;i<nums.length;i++) {
            //
            if (rightMap.containsKey(sum-prefix[i]-k)) {
                //Check if how many values are there for which i> val
                List<Integer> list = rightMap.get(sum-prefix[i]-k);
                for (Integer integer : list) {
                    if (integer>=i) {
                        count++;
                    }
                }
            }

        }
        return count;
    }
}
