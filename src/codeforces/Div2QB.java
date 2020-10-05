package codeforces;

import java.util.*;

public class Div2QB {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- >0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int arr[] = new int[n];
            for (int i=0;i<n;i++) {
                arr[i] = in.nextInt();
            }
            List<Integer> list = findBeautifulArray(arr,k);
            if (list==null) {
                System.out.println("-1");
            } else {
                System.out.println(list.size());
                for (Integer i : list) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    public static List<Integer> findBeautifulArray(int arr[],int k) {
        Set<Integer> set = new TreeSet<>();

        for (int i=0;i<arr.length;i++) {
            set.add(arr[i]);
            if (set.size()>k) {
                return null;
            }
        }
        int counter=1;
        while (set.size()<k) {
            set.add(counter);
            counter++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++) {
            list.addAll(set);
        }
        return list;
    }
}
