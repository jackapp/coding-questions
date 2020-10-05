package codeforces;

public class E {

    public static void main(String[] args) {

    }

    public static int maxLengthOfPalindrome(int arr[]) {

        int [][]left = new int[201][arr.length];
        int total[] = new int[201];
        int [][]right = new int[201][arr.length];

        for (int i=0;i<201;i++) {
           left[0][i]=0;
        }
        for (int i=0;i<arr.length;i++) {
            for (int j=1;j<201;j++) {
                left[i][j] = j==arr[i]?left[i-1][j]+1:left[i-1][j];
            }
        }

        for (int i=arr.length-1;i>=0;i--) {
            right[arr.length-1][i]=0;
        }
        for (int i=arr.length-2;i>=0;i--) {
            for (int j=0;j<201;j++) {
                right[i][j] = j==arr[i]?right[i+1][j]+1:right[i+1][j];
            }
        }

        int maxValue=Integer.MIN_VALUE;

        for (int i=1;i<201;i++) {

            //Do the main maxing thing

        }
        return 1;
    }

    public static int getValueBetween(int left[][], int right[][],int total[],int leftPos, int rightPos,int forWhat) {
        return total[forWhat]-left[leftPos-1][forWhat]-right[rightPos+1][forWhat];
    }
}
