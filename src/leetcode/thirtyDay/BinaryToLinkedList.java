package leetcode.thirtyDay;

public class BinaryToLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(0);

        head.next=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=null;

        System.out.println(getDecimalValue(head));
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static int getDecimalValue(ListNode head) {
        if (head == null) return 0;

        //Find the length of the linkedlist
        int length = length(head);
        int number=0;
        for (int i=length-1;i>=0;i--) {
            if (head.val!=0) {
                number+=Math.pow(2,i);
            }
            head=head.next;
        }
        return number;
    }

    private static int length(ListNode head) {
        int count=0;
        while (head!=null) {
            count++;
            head=head.next;
        }
        return count;
    }
}
