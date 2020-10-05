package facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CoinChange2 {

    public static void main(String[] args) {
        int coins[] = new int[]{1,2,5};
        System.out.println(change(5,coins));
    }

    public static int change(int amount, int[] coins) {
        int arr[][] = new int[coins.length+1][amount+1];

        for (int i=0;i<coins.length;i++) {
            arr[i][0]=1;
        }
        for (int i=0;i<amount+1;i++) {
            arr[0][i]=0;
        }
        arr[0][0]=1;
        for (int i=1;i<=coins.length;i++) {
            for (int j=0;j<=amount;j++) {
                arr[i][j]=arr[i-1][j]+(j-coins[i-1]>=0?arr[i][j-coins[i-1]]:0);
            }
        }
        return arr[coins.length][amount];
    }
}
