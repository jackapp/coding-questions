package leetcode.thirtyDay;

import java.util.Arrays;
import java.util.Scanner;

public class Weekly4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the arrays");
        String s = in.next();
        String t = in.next();

        System.out.println("Ans is :" + backspaceCompare(s,t));
    }

    public static boolean backspaceCompare(String S, String T) {
         char a[] = doSomething(S.toCharArray());
         char b[] = doSomething(T.toCharArray());
         S=null;
         T=null;

         if (a.length!=b.length) {
             return false;
         } else {
             for (int i=0;i<a.length;i++) {
                 if (a[i]!=b[i]) {
                     return false;
                 }
             }
             return true;
         }
    }

    public static char[] doSomething(char []arr) {
        //Do a normal traverse and find the occurrence of #
        int startCounter=0;
        while (startCounter<arr.length && arr[startCounter]!='#') {
            startCounter++;
        }
        if (startCounter==arr.length) {
            return arr;
        } else {
            //Pointer till where the # has occurred
            int counter = startCounter;
            while (counter>=0 &&counter < arr.length) {
                if (arr[counter]=='#') {
                    startCounter--;
                    if (startCounter>=0) {
                        arr[startCounter]='1';
                    } else {
                        startCounter=0;
                    }

                } else {
                    //Write this element at startPos and increment startPos
                    arr[startCounter]=arr[counter];
                    startCounter++;
                    if (startCounter<arr.length) {
                        arr[startCounter]='1';
                    }
                }
                counter++;
            }
        }
        return parseAndRemoveInvalid(arr);
    }

    public static char[] parseAndRemoveInvalid(char []arr) {
        int pos=0;

        while (pos<arr.length) {
            if (arr[pos]!='1') {
                pos++;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(arr, 0, pos!=arr.length?pos:pos-1);
    }
}
