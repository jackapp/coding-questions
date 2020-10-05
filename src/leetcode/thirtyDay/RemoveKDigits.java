package leetcode.thirtyDay;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class RemoveKDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num = in.next();
        int k = in.nextInt();
        System.out.println("Ans is "+ removeKdigits(num,k) );
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int counter=0;
        char prev='0';
        int x=0;
        while (counter<num.length() && x<k) {
            if (num.charAt(counter)>=prev) {
                stack.push(num.charAt(counter));
                prev=num.charAt(counter);
                counter++;
            } else {
                if (!stack.isEmpty()) {
                    x++;
                    stack.pop();
                    if (!stack.isEmpty()) {
                        prev=stack.peek();
                    } else {
                        prev=num.charAt(counter);
                        stack.push(prev);
                        counter++;
                    }
                }
            }
        }

        //if x has not been fulfilled then pop the stack elements
        while (x<k) {
            stack.pop();
            x++;
        }
        //Stack + counter is the ans
        String ans="";
        while (!stack.isEmpty()) {
            ans=(stack.pop()+"").concat(ans);
        }
        while (counter<num.length()) {
            ans=ans.concat(num.charAt(counter)+"");
            counter++;
        }

        //Trim leading zeroes
        int i=0;
        while (i<ans.length() && ans.charAt(i)=='0') {
            i++;
        }
        ans=ans.substring(i,ans.length());
        return ans.equals("")?"0":ans;
    }
}
