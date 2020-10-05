package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReOrderLog {

    public static void main(String[] args) {
        String arr[] = new String[] {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        for (String s : reorderLogFiles(arr)) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                boolean sFlag=checkDigit(s),tFlag=checkDigit(t1);
                if (sFlag && tFlag) {
                    return 0;
                } else if (sFlag){
                    return -1;
                } else if (tFlag) {
                    return 1;
                } else {
                    return trim(s).compareTo(trim(t1));
                }
            }
        });
        return logs;
    }

    private static boolean checkDigit(String s) {
        String []arr = s.split(" ");
        String ans="";
        for (int i=1;i<arr.length;i++) {
            if (isText(arr[i])) {
                return false;
            }
        }
        return true;
    }

    private static String trim(String s) {
        String []arr = s.split(" ");
        String ans="";
        for (int i=1;i<arr.length;i++) {
            ans=ans.concat(arr[i]);
        }
        return ans;
    }

    private static boolean isText(String s) {
        String regex= "[a-z]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
