package hackerearth.circuits;

import java.util.Scanner;

public class P3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String word = in.next();

        int x=0,y=0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i)=='z') {
                x++;
            } else {
                y++;
            }
        }

        System.out.println((x*2)==y?"Yes":"No");


    }
}
