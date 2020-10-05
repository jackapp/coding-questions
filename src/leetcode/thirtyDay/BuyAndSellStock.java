package leetcode.thirtyDay;

import java.util.Scanner;

public class BuyAndSellStock {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the array length");
        int n = in.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements");
        for (int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {

        //Buy when it starts increasing and sell when it starts decreasing
        int prev=-1,lastMaxStockValue=-1,profit=0;
        for (int i=0;i<prices.length;i++) {
            if (prices[i]>=prev) {
                if (lastMaxStockValue==-1) {
                    lastMaxStockValue=prices[i];
                }
                prev=prices[i];
            } else {
                //Sell the stock
                if (lastMaxStockValue!=-1) {
                    profit+=prev-lastMaxStockValue;
                    lastMaxStockValue=prices[i];
                    prev=prices[i];
                }
            }
        }
        if (lastMaxStockValue!=-1 && (prev-lastMaxStockValue>0)) {
            profit+=prev-lastMaxStockValue;
        }
        return profit;
    }
}
