package geeks;

import java.util.LinkedList;
import java.util.UUID;

public class LinkedListReverse {

    public static void main(String[] args) {
        CustomLinkedList head = new CustomLinkedList(1);
        CustomLinkedList node1 = new CustomLinkedList(1);
        CustomLinkedList node2 = new CustomLinkedList(1);

        head.next=node1;
        node1.next=node2;
        node2.next =null;

        reverse(head);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        System.out.println(head);
    }
    static class CustomLinkedList {
        int data;
        CustomLinkedList next;

        public CustomLinkedList(int data) {
            this.data = data;
        }
    }
    private static CustomLinkedList reverse(CustomLinkedList linkedList) {
        CustomLinkedList first,second,third;
        first=linkedList.next;
        second=first.next;
        if (second == null) {
            return first;
        }
        first.next = null;
        third = second.next;
        while (second!=null) {
            second.next=first;
            first = second;
            second = third;
            if (third != null) {
            third = third.next;
            } else {
            return second;
            }
        }
        return second;
    }
}
