package leetcode.thirtyDay;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoint {

    public static void main(String[] args) {

    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Custom> priorityQueue = new PriorityQueue<>(new Comparator<Custom>() {
            @Override
            public int compare(Custom a, Custom b) {
                return b.distance.compareTo(a.distance);
            }
        });

        for (int arr[] : points) {
            Custom custom = new Custom(arr[0],arr[1]);
            if (priorityQueue.size()<K) {
                priorityQueue.add(custom);
            } else {
                if (priorityQueue.peek().distance>custom.distance) {
                    priorityQueue.poll();
                    priorityQueue.add(custom);
                }
            }
        }

        int result[][] = new int[K][2];
        int counter=0;
        for (Custom custom : priorityQueue) {
            result[counter][0]=custom.x;
            result[counter][1]=custom.y;
            counter++;
        }
        return result;
    }
    private static class Custom {
        Long distance;
        int x;
        int y;

        public Custom(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = distance(x,y);
        }

        public Long getDistance() {
            return distance;
        }

        public void setDistance(Long distance) {
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    private static long distance(int a,int b) {
        return ((a*a)+(b*b));
    }
}
