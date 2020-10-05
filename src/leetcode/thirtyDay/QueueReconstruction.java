package leetcode.thirtyDay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class QueueReconstruction {

    public static void main(String[] args) {
        int [][]people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int ans[][] = reconstructQueue(people);
        for (int arr[] : ans) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        if (people.length==0) return people;
        LinkedList<Custom> head = new LinkedList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                Integer a = ints[0];
                Integer b = t1[0];

                if (a.intValue()==b.intValue()) {
                    Integer c = ints[1];
                    Integer d = t1[1];
                    return c.compareTo(d);
                } else {
                    return b.compareTo(a);
                }
            }
        });

        for (int arr[] : people) {
            head.add(arr[1],new Custom(arr[0],arr[1]));
        }

        int [][]ans = new int[people.length][people[0].length];

        Iterator<Custom> integerIterator = head.iterator();
        int counter=0;
        while (integerIterator.hasNext()) {
            Custom temp = integerIterator.next();
            ans[counter][0]= temp.value;
            ans[counter][1]= temp.position;
            counter++;
        }

        return ans;
    }

    private static class Custom {
        int value;
        int position;

        public Custom(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
}
