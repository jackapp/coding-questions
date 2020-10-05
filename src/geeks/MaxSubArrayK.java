package geeks;

import java.util.*;

public class MaxSubArrayK {

    public static void main(String[] args) {

        int arr[] = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Max sum is : "+findMaxSumSubArray(arr));
        int arr1[] = new int[] {9,4,2,10,7,8,8,1,9};
        System.out.println("Max turbulent array length is : " + findLongestTurbulentSubArray(arr1));
    }

    public static List<Integer> maxOfSubArray(int arr[], int k) {
        return new ArrayList<>();
    }

    public static boolean checkIfArrayCanBeDivided(int arr[],int k) {
        Map<Integer,Integer> map = new TreeMap<>();

        for (int element : arr) {
            map.put(element,map.containsKey(element)?map.get(element)+1:1);
        }

        //Traverse through the map and check if the array can be divided
        return false;

    }



    public static int findMaxSumSubArray(int arr[]) {
        int counter = 0, prevSum = 0, maxSum = Integer.MIN_VALUE;
        while (counter < arr.length) {

            if (prevSum <= 0) {
                prevSum = arr[counter];

                if (maxSum < prevSum) {
                    maxSum = prevSum;
                }
                counter++;
            } else {
                prevSum += arr[counter];
                if (maxSum < prevSum) {
                    maxSum = prevSum;
                }
                counter++;
            }
        }
        return maxSum;
    }

    public static int findLongestTurbulentSubArray(int arr[]) {
        boolean gt=false;
        int counter = 0,maxLength=1,prevLength=0;
        while (counter<arr.length-1) {

            if (counter==0) {
                if (arr[counter]>arr[counter+1]) {
                    gt=false;
                    prevLength=2;
                } else if (arr[counter]<arr[counter+1]){
                    gt=true;
                    prevLength=2;
                } else {
                    prevLength=0;
                }
                counter++;
            } else {

                if (gt) {
                    if (arr[counter]>arr[counter+1]) {
                        prevLength = prevLength==0?2:prevLength+1;
                        gt=false;
                    } else if (arr[counter]<arr[counter+1]) {
                        //Check if longest
                        prevLength=2;
                    } else {
                        prevLength=0;
                    }
                } else {
                    if (arr[counter]<arr[counter+1]) {
                        prevLength = prevLength==0?2:prevLength+1;
                        gt=true;
                    } else if (arr[counter]>arr[counter+1]) {
                        //Check if longest
                        prevLength=2;
                    } else {
                        prevLength=0;
                    }
                }
                maxLength = checkAndSetMaxLength(maxLength,prevLength);
                counter++;
            }

        }

        return maxLength;
    }

    private static int checkAndSetMaxLength(int length1,int length2) {
        return length1>length2?length1:length2;
    }
}
