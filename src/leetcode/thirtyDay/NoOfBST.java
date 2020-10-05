package leetcode.thirtyDay;

public class NoOfBST {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int arr[] = new int[n+1];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        for (int i=3;i<=n;i++) {
            int val=0;
            for (int j=0;j<i;j++) {
                val+=arr[j]*arr[i-j-1];
            }
            arr[i]=val;
        }
        return arr[n];
    }
}
