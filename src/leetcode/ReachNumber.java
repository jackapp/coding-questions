package leetcode;

import java.util.Scanner;

public class ReachNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(reachNumber(x));
    }

    public static int reachNumber(int target) {
        if (target<0) {
            target=-target;
        }
        int val = 0;
        int num=0;
        for (int i=1;val<=target;i++) {
            val = ((i)*(i+1))/2;
            if (val==target) {
                return i;
            }
            num=i;
        }
        int compare1= ((num) *(num-1))/2;
        int compare2 = ((num) *(num+1))/2;
        if (Math.abs(target-compare1)>Math.abs(target-compare2)) {
            return ((compare2-target)*2)+num-1;
        } else {
            return ((target-compare1)*2)+num;

        }
    }
}
