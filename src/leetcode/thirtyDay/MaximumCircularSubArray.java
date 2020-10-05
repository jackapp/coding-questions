package leetcode.thirtyDay;

public class MaximumCircularSubArray {

    public static void main(String[] args) {
        int x = maxSubarraySumCircular(new int[]{-5,3,-5});
        System.out.println(x);
    }

    public static int maxSubarraySumCircular(int[] A) {
        int max=Integer.MIN_VALUE;
        int prev=0;
        int prevPos=0;
        boolean negFlag=true;
        int min=Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            if (A[i]>=0) {
                negFlag=false;
                break;
            } else {
                if (min<A[i]) {
                    min=A[i];
                }
            }
        }

        if (negFlag) {
            return min;
        }

        for (int i=0;i<A.length;i++) {
            if (prev+A[i]<=0) {
                prev=0;
                prevPos=i;
            } else {
                if (prev==0) {
                    prevPos=i;
                }
                prev+=A[i];
                if (prev>max) {
                    max=prev;
                }
            }
        }

        //Check from right side of the array till prePos whats the max like.
        int maxPosFromRight=A.length-1;
        int suffix[] = new int[A.length];
        int suffVar=0,preVar=0,prefixMax=Integer.MIN_VALUE,suffixMax=Integer.MIN_VALUE;
        for (int i=A.length-1;i>=0;i--) {
            suffVar+=A[i];
            if (suffVar>suffixMax) {
                suffixMax=suffVar;
            }
            suffix[i]=suffixMax;
        }
        int prefix[] = new int[A.length];
        for (int i=0;i<A.length-1;i++) {
            if (preVar+A[i]>prefixMax) {
                prefixMax=preVar+A[i];
            }
            prefix[i]=prefixMax;
            preVar+=A[i];
        }
        for (int i=0;i<A.length;i++) {
           if (prefix[i]+(i==A.length-1?0:suffix[i+1])>max) {
               max=prefix[i]+suffix[i+1];
           }
        }

        return max;
    }
}
