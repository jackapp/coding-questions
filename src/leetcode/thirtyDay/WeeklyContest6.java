package leetcode.thirtyDay;

public class WeeklyContest6 {

    public static void main(String[] args) {
        String s  ="";
        int shift[][] = new int[][]{{0,1},{1,2}};
        System.out.println(stringShift("abc",shift));
    }

    public static String stringShift(String s, int[][] shift) {
        int direction=0;
        for (int i=0;i<shift.length;i++) {
            if (shift[i][0]==1) {
                direction+=shift[i][1];
            } else {
                direction-=shift[i][1];
            }
        }

        char arr[] = new char[s.length()];
        direction=direction%s.length();
        if (direction<0) {
            direction=-1*direction;
            for (int i=0;i<s.length();i++) {

                if (i-direction<0) {
                    arr[s.length()+(i-direction)]=s.charAt(i);
                } else {
                    arr[i-direction]=s.charAt(i);
                }
            }
        } else if (direction>0) {
            for (int i=0;i<s.length();i++) {
                if (i+direction>=arr.length) {
                    arr[i+direction-s.length()]=s.charAt(i);
                } else {
                    arr[i+direction]=s.charAt(i);
                }
            }
        } else {
            return s;
        }
        return String.valueOf(arr);
    }
}
