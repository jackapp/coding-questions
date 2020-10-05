
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        while (t-- >0) {
            int n = in.nextInt();
            if (n%2==0) {
                if (checkIfEven(in.next())) {
                    System.out.println("2");
                } else {
                    System.out.println("1");
                }
            } else {
                if (checkIfOdd(in.next())) {
                    System.out.println("1");
                } else {
                    System.out.println("2");
                }
            }
        }

    }

    private static boolean checkIfEven(String s) {
        for (int i=1;i<s.length();i+=2) {
            if (((int)(s.charAt(i)-'0'))%2==0) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfOdd(String s) {
        for (int i=0;i<s.length();i+=2) {
            if (((int)(s.charAt(i)-'0'))%2!=0) {
                return true;
            }
        }
        return false;
    }

}
