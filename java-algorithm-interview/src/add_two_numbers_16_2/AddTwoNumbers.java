package add_two_numbers_16_2;

// 전가산기 ver.
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;

        ListNode result = addTwoNumbers(node1, node4);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int sum = 0 , carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode((sum + carry) % 10);
            carry = sum / 10;
            node = node.next;
        }

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