package leetcode.thirtyDay;

import java.util.HashMap;
import java.util.Map;

public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("a","ab"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length()) {
            return false;
        }
        int main[] = new int[26];
        for (int i=0;i<s1.length();i++) {
            main[s1.charAt(i)-'a']++;
        }
        int temp[]=new int[26];
        for (int i=0;i<s1.length();i++) {
            temp[s2.charAt(i)-'a']++;
        }
        boolean val1= checkIfSame(main,temp);
        for (int i=s1.length();i<s2.length();i++) {
            temp[s2.charAt(i-s1.length())-'a']--;
            temp[s2.charAt(i)-'a']++;
            boolean val = checkIfSame(main,temp);
            if (val) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkIfSame(int []main,int temp[]) {
        for (int i=0;i<26;i++) {
            if (main[i]!=temp[i]) {
                return false;
            }
        }
        return true;
    }


}
