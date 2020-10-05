package leetcode.thirtyDay;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int A[][] = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int B[][] =  new int[][]{{1,5},{8,12},{15,24},{25,26}};

        int [][]ans = intervalIntersection(A,B);
        System.out.println("Ans length is "+ ans.length);
        for (int arr[] : ans) {
            System.out.println(arr[0] + " " + arr[1] + " ");
        }
        System.out.println();
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        /*
        Take max of the 2 pointers and search in the other which is that element which is just greater than it.
        Once found. fetch the interval.
           case 1
               it lies in (x,*)
               in that case the number is actually the previous interval.
               (v,w) and now check whether in this interval there lies any intersection

               else

                (v,w)
            find the intersection
            the ans will be
            max (a,b) , min (w,c)

         */
        int i=0,j=0;
        List<List<Integer>> ans = new ArrayList<>();
        while (i<A.length&&j<B.length) {
            if (A[i][0]<B[j][0]) {
                if (A[i][1]<B[j][0]) {
                    i++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(B[j][0]);
                    //Add this to the main list
                    if (A[i][1]<B[j][1]) {
                        temp.add(A[i][1]);
                        i++;
                    } else if (A[i][1]>B[j][1]){
                        temp.add(B[j][1]);
                        j++;
                    } else {
                        temp.add(B[j][1]);
                        i++;
                        j++;
                    }
                    ans.add(temp);
                }

            } else if (A[i][0] == B[j][0]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(B[j][0]);
                //Add this to the main list
                if (A[i][1]<B[j][1]) {
                    temp.add(A[i][1]);
                    i++;
                } else if (A[i][1]>B[j][1]){
                    temp.add(B[j][1]);
                    j++;
                } else {
                    temp.add(B[j][1]);
                    i++;
                    j++;
                }
                ans.add(temp);
            } else {
                if (A[i][0]>B[j][1]) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(A[i][0]);
                    //Add this to the main list
                    if (A[i][1]<B[j][1]) {
                        temp.add(A[i][1]);
                        i++;
                    } else if (A[i][1]>B[j][1]){
                        temp.add(B[j][1]);
                        j++;
                    } else {
                        temp.add(B[j][1]);
                        i++;
                        j++;
                    }
                    ans.add(temp);
                }
            }
        }

        int [][]result = new int[ans.size()][2];
        int counter=0;
        for (List<Integer> list : ans) {
            result[counter][0]=list.get(0);
            result[counter][1]=list.get(1);
            counter++;
        }

        return result;
    }
}
