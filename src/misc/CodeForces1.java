package misc;

import java.util.Scanner;

public class CodeForces1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int left = in.nextInt();
            int right = in.nextInt();
            int down = in.nextInt();
            int up = in.nextInt();

            int x = in.nextInt();
            int y = in.nextInt();
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            boolean flag = true;
            int val;

            val = right-left;

            if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                if (val >= x1 && val <= x2) {
                    flag = true;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }

            if (!flag) {
                System.out.println("NO");
            } else {

                val = up - down;
                if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                    if (val >= y1 && val <= y2) {
                        flag = true;
                    } else {
                        flag = false;
                    }
                } else {
                    flag = false;
                }

                if (flag) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }

            }



        }
    }
}
