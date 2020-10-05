package leetcode;

import java.util.*;

public class UglyNumber2 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumberModified(0));
    }


    public static int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();

        long start=1l;
        set.add(start);
        int counter=0;
        while (counter<n) {
            long x = set.pollFirst();
            set.add(2*x);
            set.add(3*x);
            set.add(5*x);

            if (counter==n-1) {
                return (int)x;
            }
            counter++;
        }
        return -1;
    }

    public static int nthUglyNumberModified(int n) {
        List<Long> two = new ArrayList<>();
        List<Long> three = new ArrayList<>();
        List<Long> five = new ArrayList<>();

        two.add(2l);
        three.add(3l);
        five.add(5l);

        int twoCounter=0;
        int threeCounter=0;
        int fiveCounter=0;

       Set<Long> set = new HashSet<>();
        set.add(1l);
        long last=1l;
        while (set.size()<n) {
            //Find the next number and add that number to the list and then check which number is smaller in those three lists and repeat this again
            long number;
            if (two.get(twoCounter) < three.get(threeCounter) ) {
                if (two.get(twoCounter)<five.get(fiveCounter)) {
                   number = two.get(twoCounter);
                   twoCounter++;
                } else {
                    number = five.get(fiveCounter);
                    fiveCounter++;
                }
            } else if (three.get(threeCounter)<five.get(fiveCounter)) {
                number = three.get(threeCounter);
                threeCounter++;
            } else {
                number = five.get(fiveCounter);
                fiveCounter++;
            }

            two.add(number*2);
            three.add(number*3);
            five.add(number*5);

            set.add(number);
            last=number;
        }

        return (int)last;
    }
}
