package leetcode;

import java.util.*;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int arr[][] = new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        System.out.println(twoCitySchedCost(arr));
    }

    public static int twoCitySchedCost(int[][] costs) {
        List<Custom> cityA = new ArrayList<>();
        List<Custom> cityB = new ArrayList<>();

        for (int arr[] : costs) {
            if (arr[0]>arr[1]) {
                cityB.add(new Custom(arr[0],arr[1]));
            } else {
                cityA.add(new Custom(arr[0],arr[1]));
            }
        }

        if (cityA.size()==costs.length/2) {
            return findSum(cityA,cityB);
        } else if (cityA.size()<cityB.size()){
            Collections.sort(cityB, new Comparator<Custom>() {
                @Override
                public int compare(Custom custom, Custom t1) {
                    Integer x =  (custom.b-custom.a);
                    Integer y =  (t1.b-t1.a);
                    return y.compareTo(x);
                }
            });
            int sum=0;
            for (int i=0;i<cityB.size();i++) {
                if (i<(costs.length/2)-cityA.size()) {
                    sum+=cityB.get(i).a;
                } else {
                    sum+=cityB.get(i).b;
                }
            }

            for (Custom a :cityA) {
                sum+=a.a;
            }
            return sum;
        } else {
            Collections.sort(cityA, new Comparator<Custom>() {
                @Override
                public int compare(Custom custom, Custom t1) {
                    Integer x =  (custom.a-custom.b);
                    Integer y =  (t1.a-t1.b);
                    return y.compareTo(x);
                }
            });
            int sum=0;
            for (int i=0;i<cityA.size();i++) {
                if (i<(costs.length/2)-cityB.size()) {
                    sum+=cityA.get(i).b;
                } else {
                    sum+=cityA.get(i).a;
                }
            }
            for (Custom b :cityB) {
                sum+=b.b;
            }
            return sum;
        }
    }

    private static int findSum(List<Custom> cityA,List<Custom> cityB) {
        int sum=0;
        for (Custom a :cityA) {
            sum+=a.a;
        }

        for (Custom b :cityB) {
            sum+=b.b;
        }
        return sum;
    }

    public static class Custom {
        Integer a;
        Integer b;

        public Custom(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
