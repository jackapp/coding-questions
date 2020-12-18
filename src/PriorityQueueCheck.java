

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueCheck {
    public static void main(String[] args) {

        PriorityQueue<CustomObj> priorityQueue = new PriorityQueue<>(new Comparator<CustomObj>() {
            @Override
            public int compare(CustomObj customObj, CustomObj t1) {
                return customObj.value.compareTo(t1.value);
            }
        });

        priorityQueue.add(new CustomObj(3,1));
        priorityQueue.add(new CustomObj(2,1));

        System.out.println(priorityQueue.peek().value);
    }


    public static class CustomObj {
        Integer value;
        int pos;

        public CustomObj(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }

}
