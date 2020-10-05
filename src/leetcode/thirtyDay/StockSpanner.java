package leetcode.thirtyDay;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StockSpanner {

    private Stack<Custom> stack;
    private int counter;
    public StockSpanner() {
        this.stack = new Stack<>();
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }

    public int next(int price) {
        if (stack.isEmpty()) {
            counter++;
            stack.push(new Custom(price,counter,0,0));
            return 1;
        } else {
            counter++;
            if (stack.peek().value>price) {
                stack.push(new Custom(price,counter,stack.peek().value,stack.peek().i));
                return 1;
            } else if (stack.peek().value==price) {
                int retVal;
                Custom temp = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(new Custom(price,counter,0,0));
                    retVal = counter;
                } else {
                    retVal = counter - temp.lastValPos;
                    stack.push(new Custom(price,counter,temp.lastVal,temp.lastValPos));

                }

                return retVal;
            } else {
                //
                Custom temp = stack.peek();
                while (temp.value<=price) {
                    if (temp.lastVal<=price) {
                        stack.pop();
                    } else {
                        int retVal = counter - temp.lastValPos;
                        stack.pop();
                        stack.push(new Custom(price,counter,temp.lastVal,temp.lastValPos));
                        return retVal;
                    }

                    if (stack.isEmpty()) {
                        stack.push(new Custom(price,counter,0,1));
                        return counter;
                    }
                    temp=stack.peek();
                }

                stack.push(new Custom(price,counter,stack.peek().lastVal,stack.peek().i));
                return counter-temp.i;

            }
        }
    }

    static class Custom {
        int value;
        int i;
        int lastVal;
        int lastValPos;

        public Custom(int value, int i, int lastVal, int lastValPos) {
            this.value = value;
            this.i = i;
            this.lastVal = lastVal;
            this.lastValPos = lastValPos;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getLastVal() {
            return lastVal;
        }

        public void setLastVal(int lastVal) {
            this.lastVal = lastVal;
        }

        public int getLastValPos() {
            return lastValPos;
        }

        public void setLastValPos(int lastValPos) {
            this.lastValPos = lastValPos;
        }
    }
}
