package leetcode;

public class ProductMultiplication {

    public static void main(String[] args) {

    }

    public static int[] productExceptSelf(int[] nums) {
        int ans[] = new int[nums.length];

        int prev=1;
        for (int i=0;i<nums.length;i++) {
            ans[i]=prev;
            prev=prev*nums[i-1];
        }
        prev=1;
        for (int i=nums.length-2;i>=0;i--) {
            ans[i]*=prev;
            prev=prev*nums[i+1];
        }
        return ans;
    }
}
