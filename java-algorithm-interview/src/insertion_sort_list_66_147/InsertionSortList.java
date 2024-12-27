package insertion_sort_list_66_147;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode front = new ListNode();
        ListNode node = front;
        while (head != null) {
            while (node.next != null && node.next.val < head.val) node = node.next;
            
            ListNode nodeNext = node.next;
            ListNode headNext = head.next;
            node.next = head;
            head.next = nodeNext;
            head = headNext;
            
            if(head != null && node.val > head.val) node = front;
        }

        return front.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
