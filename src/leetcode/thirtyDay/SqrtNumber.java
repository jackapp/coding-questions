package leetcode.thirtyDay;

public class SqrtNumber {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(81));
    }
    public static boolean isPerfectSquare(int num) {
        return isPerfectSquare(num,0,num/2,num);
    }

    public static boolean isPerfectSquare(int num,int low,int mid,int high) {
        //limits are 1 and num/2
        if (low == mid || mid == high) {
            if (mid*mid == num) {
                return true;
            }
            return false;
        } else {
            if (mid*mid==num) {
                return true;
            } else if (mid*mid>num) {
                return isPerfectSquare(num,low,(low+mid-1)/2,mid-1);
            } else {
                return isPerfectSquare(num,mid+1,(high+mid+1)/2,high);
            }
        }
    }


}
