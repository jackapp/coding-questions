package leetcode;

public class ReverseWords {


    public static void main(String[] args) {
        reverseWords("   hello World!    123    ");
    }

    public static void reverseWords(String s) {
        String input[] = s.split(" +");
        System.out.println(input.length);
    }
}
