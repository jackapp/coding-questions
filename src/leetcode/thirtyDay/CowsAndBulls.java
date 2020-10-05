package leetcode.thirtyDay;

public class CowsAndBulls {

    public static void main(String[] args) {
        System.out.println(getHint("1807","7817"));
    }

    public static String getHint(String secret, String guess) {
        int sot[] = new int[10];
        int inp[] = new int[10];

        int bullCount=0,cowCount=0;

        for (int i=0;i<guess.length();i++) {
            if (secret.charAt(i)==guess.charAt(i)) {
                bullCount++;
            } else {
                sot[secret.charAt(i)-'0']++;
                inp[guess.charAt(i)-'0']++;
            }
        }

        for (int i=0;i<10;i++) {

            if (sot[i]!=0) {
                //Check how many values are there
                cowCount+=min(sot[i],inp[i]);
            }
        }

        return bullCount+"A"+cowCount+"B";

    }

    private static int min(int a,int b) {
        return a>b?b:a;
    }
}
