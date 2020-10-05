
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- >0) {
            int n =in.nextInt();
            int arr[] = new int[n];
            for (int i=0;i<n;i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);
            int last=0;
            for (int i=0;i<arr.length;i++) {
                if (arr[i]<=i+1) {
                    last=i+1;
                }
            }
            System.out.println(last+1);

        }
    }

    public static boolean checkIfPower(int n) {
        return n%4==0;
    }

    /*
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- >0) {
            int n = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();

            String ans = "";
            String start ="";
            for (int i=0;i<b;i++) {
                char c = (char)('a'+i);
                start=start.concat(c+"");
            }
            int counter=0;
            for (int i=b;i<a;i++) {
                if (counter>=a) {
                    counter=0;
                }
                start=start.concat(start.charAt(counter)+"");
                counter++;
            }
            counter=0;
            for (int i=a;i<n;i++) {
                if (counter>=a) {
                    counter=0;
                }
                start=start.concat(start.charAt(counter)+"");
                counter++;
            }
            System.out.println(start);
        }
    }
    */


    public static void printArray(int arr[]) {
        //Sorted array
        //Find the elements having min difference
        //select the indices having minmum difference

        int start=0,end=1;
        int diff = Integer.MAX_VALUE;
        for (int i=0;i<arr.length-1;i++) {
            if (Math.abs(arr[i]-arr[i+1])<diff) {
                diff = Math.abs(arr[i]-arr[i+1]);
                start=i;
                end=i+1;
            }
        }
        if (arr.length==1) {
            System.out.println(arr[0]);
            return;
        } else if (arr.length==0) {
            System.out.println("");
        }
        //Now everytime check left and right for the possible values
        int curr,left=start-1,right=end+1;
        int val1= nextPos(arr,start,start-1,end+1);
        int diff1;
        int val2= nextPos(arr,end,start-1,end+1);
        List<Integer> list = new ArrayList<>();
        if (val1==-1) {
            curr = end;
            list.add(start);
            list.add(end);
        } else if (val2 == -1) {
            curr=start;
            list.add(end);
            list.add(start);
        } else {
            if (Math.abs(arr[start]-arr[val1])>Math.abs(arr[end]-arr[val2])) {
                curr = end;
                list.add(start);
                list.add(end);
            } else {
                curr = start;
                list.add(end);
                list.add(start);
            }
        }

        while (curr!=-1) {
            curr = nextPos(arr,curr,left,right);
            if (curr==-1) {
              break;
            } else if (left==curr) {
                left--;
                list.add(curr);
            } else if (curr==right) {
                right++;
                list.add(curr);
            }
        }

        for (Integer i : list) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

    public static int nextPos(int arr[],int curr,int left,int right) {
        if (left<0) {
            return right<arr.length?right:-1;
        } else if (right>=arr.length) {
            return left>=0?left:-1;
        } else {
            return Math.abs(arr[curr]-arr[left])>Math.abs(arr[curr]-arr[right])?right:left;
        }
    }
}
