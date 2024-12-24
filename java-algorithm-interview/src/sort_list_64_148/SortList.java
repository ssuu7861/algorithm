package sort_list_64_148;


public class SortList {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode half = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        half.next = null; // half 와 slow 두 개로 분할

        ListNode listNode1 = sortList(head);
        ListNode listNode2 = sortList(slow);

        return merge(listNode1, listNode2);
    }

    public ListNode merge(ListNode listNode1, ListNode listNode2) {
        if(listNode1 == null) return listNode2;
        if(listNode2 == null) return listNode1;

        if(listNode1.val > listNode2.val) {
            ListNode temp = listNode1;
            listNode1 = listNode2;
            listNode2 = temp;
        }
        listNode1.next = merge(listNode1.next, listNode2);
        return listNode1;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    