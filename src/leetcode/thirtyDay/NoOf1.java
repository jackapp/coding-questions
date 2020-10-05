package leetcode.thirtyDay;

public class NoOf1 {

    public static void main(String[] args) {
        System.out.println(countBits(2));
    }

    public static int[] countBits(int num) {
        int ans[] = new int [num+1];
        for (int i=0;i<=num;i++) {
            int temp=1;
            int counter=0;
            for (int j=0;j<31;j++) {
                if ((temp & i)!=0) {
                    counter++;
                }
                temp=temp<< 1;
            }
            ans[i]=counter;
        }
        return ans;
    }
}
