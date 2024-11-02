package merge_two_sorted_lists_14_21;

// 일반적인 풀이
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(4);
        ListNode node10 = new ListNode(7);
        ListNode node11 = new ListNode(10);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;

        ListNode result = mergeTwoLists(node1, node7);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
            
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode head = result;
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                result.next = list2;
                list2 = list2.next;
            }
            else {
                result.next = list1;
                list1 = list1.next;
            }

            result = result.next;
        }

        if(list1 != null) result.next = list1;
        if(list2 != null) result.next = list2;

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}