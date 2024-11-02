package palindrome_linked_list_13_234;

import java.util.Deque;
import java.util.LinkedList;

// LinkedList(Deque) 이용한 풀이
public class PalindromeLinkedList {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head){
        Deque<Integer> deque = new LinkedList<>();
        while(head != null){
            deque.add(head.val);
            head = head.next;
        }

        // 2개씩 빠지므로 최후에 짝수이면 0, 홀수이면 1 남음
        while (!deque.isEmpty() && deque.size() > 1) {
            if(deque.pollFirst() != deque.pollLast()) return false;
        }
        return true;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}