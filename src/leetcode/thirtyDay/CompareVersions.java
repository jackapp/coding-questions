package leetcode.thirtyDay;

public class CompareVersions {

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1","1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String []arr1 = version1.split("\\.");
        String []arr2 = version2.split("\\.");

        for (int i=0;i<min(arr1.length,arr2.length);i++) {
            int val =  compare(arr1[i],arr2[i]);
            if (val!=0) {
                return val;
            }
        }
        return 0;

    }

    private static int compare(String a,String b) {

        for (int i=0;i<min(a.length(),b.length());i++) {
            int x = (int)(a.charAt(i)-'0');
            int y = (int) (b.charAt(i)-'0');

            if (x>y) {
                return 1;
            } else if (x<y) {
                return -1;
            }
        }

        if (a.length()>b.length()) {
            return 1;
        } else if (a.length()<b.length()) {
            return -1;
        } else {
            return 0;
        }

    }

    private static int min(int a,int b) {
        return a>b?b:a;
    }
}
