package leetcode.thirtyDay;

public class Complement {

    public static void main(String[] args) {
        System.out.println(findComplement(2147483647));
    }

    public static int findComplement(int num) {
        int x=1,ans=0;
        for (int i=0;i<31 && x<=num;i++) {
            int temp = num & x;
            if (temp==0) {
                ans+=x;
            }
            x = x <<1;
        }
        return ans;
    }
}
