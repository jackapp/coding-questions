package google;

public class SingleNumber2 {

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        /*
        *  Algo
        * convert the number into a 32 bit integer array of 0s and 1
        *
        */
        return 1;
    }

    private static int [] convertToBinary(int a) {
        int[] arr = new int[32];
        int temp=a;
        for (int i = 31; i >0; i--) {
            arr[i] = temp%2;
        }
        return null;
    }
}
