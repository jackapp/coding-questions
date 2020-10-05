package geeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmallestStringContainingSubstring {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the main string");
        String base = in.next();
        System.out.println("Enter the aux string");
        String input = in.next();
        System.out.println("Ans is " + smallestSubstringContainingStringHelper(base,input));
    }

    public static String smallestSubstringContainingStringHelper(String base, String input) {
        Map<Character,Integer> mainMap = new HashMap<>();
        Map<Character,Integer> auxMap = new HashMap<>();
        
        for (Character c : base.toCharArray()) {
            if (mainMap.containsKey(c)) {
                mainMap.put(c,mainMap.get(c)+1);
            } else {
                mainMap.put(c,1);
            }
        }

        for (Character c : input.toCharArray()) {
            if (auxMap.containsKey(c)) {
                auxMap.put(c,auxMap.get(c)+1);
            } else {
                auxMap.put(c,1);
            }
        }

        //Find out the validity of input inside main
        for (Map.Entry entry : auxMap.entrySet()) {
            if (!mainMap.containsKey(entry.getKey())) {
                return "";
            }
        }

        boolean flag=true;
        int right=base.length()-1;
        int left=0;
        int counter=-1;

        //Start with right
        while (flag) {
            if (!auxMap.containsKey(base.charAt(right)) || mainMap.get(base.charAt(right))>auxMap.get(base.charAt(right))) {
                right--;
            } else {
                break;
            }
        }

        while (flag) {
            if (!auxMap.containsKey(base.charAt(left)) || mainMap.get(base.charAt(left))>auxMap.get(base.charAt(left))) {
                left++;
            } else {
                break;
            }
        }

        return base.substring(left,right+1);
    }
}
