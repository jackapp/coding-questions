package leetcode.thirtyDay;

import java.util.Scanner;
import java.util.Stack;

public class WeeklyContest7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s =in.next();
        System.out.println("Ans is :" + checkValidString(s));
    }


    public static boolean checkValidString(String s) {
        int countLeft=0,countRight=0,countAsterix=0;
        Stack<Integer> asterixStack = new Stack<>();
        Stack<Integer> leftParanthesisStack = new Stack<>();


        for (int i=0;i<s.length();i++) {
            char curr = s.charAt(i);

            switch (curr) {
                case '*' :
                    asterixStack.push(i);
                    break;
                case '(':
                    leftParanthesisStack.push(i);
                    break;
                case ')' :
                    if (leftParanthesisStack.size()>0) {
                        leftParanthesisStack.pop();
                    } else if (asterixStack.size()>0) {
                        asterixStack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if (leftParanthesisStack.size()>0) {
            if (asterixStack.size()>0) {
                while (!leftParanthesisStack.isEmpty() && !asterixStack.isEmpty()) {
                    if (asterixStack.peek()>leftParanthesisStack.peek()) {
                        asterixStack.pop();
                        leftParanthesisStack.pop();
                    } else {
                        asterixStack.pop();
                    }
                }

                if (leftParanthesisStack.size()>0) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
