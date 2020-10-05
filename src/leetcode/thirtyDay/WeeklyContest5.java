package leetcode.thirtyDay;

import java.util.*;
import java.util.stream.Collectors;

public class WeeklyContest5 {

    public static void main(String[] args) {
        int arr[] = new int[]{191,193,552,881,68,337,209,749,58,923,300,43,121,185,977,454,151,83,97,282,561,58,692,550,949,931,465,29,295,412};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight1(int[] stones) {
        int main[] = new int[1001];
        for (int i : stones) {
            main[i]++;
        }
        int last = 1000, secondLast = 999;

        while (secondLast >= 0 && last >= 0) {
            if (last == secondLast) {
                secondLast--;
            }
            if (main[secondLast] != 0 && main[last] != 0) {
                main[last] = main[last] % 2 == 0 ? 0 : 1;
                if (main[last] == 0) {
                    last--;
                    continue;
                }
                // Whichever is bigger subtract from it

                main[last - secondLast]++;
                main[secondLast]--;
                main[last] = 0;
                last--;

            } else if (main[secondLast] == 0 && main[last] != 0) {
                secondLast--;
            } else if (main[secondLast] != 0 && main[last] == 0) {
                last--;
            } else {
                last--;
                secondLast--;
            }
        }
        int val = 0;
        for (int i = 0; i < main.length; i++) {
            if (main[i] != 0) {
                if (main[i] % 2 == 0) {
                    val = 0;
                } else {
                    val = i;
                }
                break;
            }
        }
        return val;
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> integers = new PriorityQueue<>(stones.length,new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer.compareTo(t1);
            }
        });

        for (int i : stones) {
            integers.add(i);
        }
        while (integers.size()>1) {
            int pick1 = integers.poll();
            int pick2 = integers.poll();
            if (pick1!=pick2) {
                integers.add(pick1>pick2?pick1-pick2:pick2-pick1);
            }
        }
        if (integers.size()==0) {
            return 0;
        } else {
           return integers.poll();
        }
    }
}
