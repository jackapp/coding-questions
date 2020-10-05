package leetcode.thirtyDay;

public class SortColors {

    public static void main(String[] args) {
        int arr[] = new int[] {2,1,0,0,1,1,2,0};
        sortColors(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sortColors(int[] nums) {
        int counter=0,zeroCount=0,twoCount=nums.length-1;
        while (zeroCount<twoCount && counter<twoCount) {
            if (nums[counter]==0) {
                //Swap it with the last zeroCounter and keep the counter as is
                if (zeroCount==counter) {
                    zeroCount++;
                    counter++;
                } else {
                    //Swap with zeroCounter
                    nums[zeroCount]=0;
                    zeroCount++;
                    nums[counter]=1;
                }
            } else if (nums[counter]==1) {
                counter++;
            } else {
                //Swap with last element
                int temp = nums[twoCount];
                nums[twoCount]=2;
                nums[counter]=temp;
                twoCount--;
            }
        }
    }
}
