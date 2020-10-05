package hackerearth;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Rescuer {

    public static void main(String[] args) {
        int t;

        Scanner in = new Scanner(System.in);

        t = in.nextInt();

        while (t--> 0) {

            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int v1 = in.nextInt();
            int v2 = in.nextInt();

            double xm = (y2!=y1)?x1:x1+((-1D*y1)/findSlope(x2,y2,x1,y1));
            double ym = 0;

            double distance1 = findDist(xm,ym,x1,y1);
            double distance2 = findDist(xm,ym,x2,y2);


            double d = (distance1/v1)+(distance2/v2);
            DecimalFormat decimalFormat =  new DecimalFormat("#0.00000");
            System.out.printf(decimalFormat.format(d)+"");

        }
    }

    private static double findSlope(double x2,double y2,double x1,double y1) {
        return (x2-x1)/(y2-y1);
    }

    private static double findDist(double x2,double y2,double x1,double y1) {
        return Math.sqrt(((x2-x1)*(x2-x1)) + ((y2-y1)*(y2-y1)));
    }
}

