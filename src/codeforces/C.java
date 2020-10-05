
import java.util.*;

public class C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- >0) {
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();

            System.out.println(numberOfPaths(Math.abs(x2-x1)+1,Math.abs(y2-y1)+1));


        }
    }

    static long numberOfPaths(long m, long n) {
        if (m==1 || n==1) return 1;
        return (m*n)%2==0?(m*n)/2:((m*n)/2+1);
    }

}
