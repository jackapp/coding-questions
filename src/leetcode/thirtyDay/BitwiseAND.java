package leetcode.thirtyDay;

import java.util.ArrayList;
import java.util.List;

public class BitwiseAND {

    public static void main(String[] args) {
        //System.out.println(rangeBitwiseAnd(5,7));
        System.out.println(findPowerOf2(0));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int arr[] = getBinary(m);
        int arr1[] = getBinary(n);
        if (arr.length!=arr1.length) {
            return 0;
        }
        int nearestPower = findRange(m,n);
        int tp = (n/nearestPower)*nearestPower;
        return m&n&tp;
    }

    private static int findRange(int m, int n) {
        int nearestPower=findPowerOf2(n);
        while (((n/nearestPower)*nearestPower)<m) {
            nearestPower=nearestPower/2;
        }
       return nearestPower;
    }

    private static int convertToDecimal(int[] arr) {
        int sum=0;
        int start=1;
        for (int i=arr.length-1;i>=0;i--) {
            sum+=start*arr[i];
            start*=2;
        }
        return sum;
    }

    private static int[] getBinary(int a) {
        List<Integer> list = new ArrayList<>();

        int start=a;

        while (start>=1) {
            list.add(start%2);
            start=start/2;
        }
        int arr[] = new int[list.size()];
        int counter=arr.length-1;
        for (Integer i : list) {
            arr[counter--] = i;
        }
        if (arr.length==0) {
            arr = new int[]{0};
        }
        return arr;
    }

    public static int findPowerOf2(int n) {
        int p = (int)(Math.log(n) /
                Math.log(2));
        return (int)Math.pow(2, p);
    }
}
