package leetcode.thirtyDay;

import java.util.Scanner;

public class StraightLine {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

    }


    public boolean checkStraightLine(int[][] coordinates) {

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        for (int i=2;i<coordinates.length;i++) {
            if (!evaluateExpression(coordinates[i][0],coordinates[i][1],x1,x2,y1,y2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean evaluateExpression(int x,int y,int x1,int x2,int y1,int y2) {
        return (y2-y1)*(x-x1) == (y-y1)*(x2-x1);
    }

}
