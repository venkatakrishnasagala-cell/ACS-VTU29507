import java.util.*;

public class Task12_Palindrome_Linked_List {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;

        ListNode prev = null, cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode p1 = head, p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    static ListNode build(int[] a) {
        ListNode d = new ListNode(0), c = d;
        for (int x : a) { c.next = new ListNode(x); c = c.next; }
        return d.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println(isPalindrome(build(a)));
        sc.close();
    }
}
// Input:
// 5
// 1 2 2 1
// Use n=4 for this sample.
// Output:
// true
