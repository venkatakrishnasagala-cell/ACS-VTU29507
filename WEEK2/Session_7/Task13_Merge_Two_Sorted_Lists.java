import java.util.*;

public class Task13_Merge_Two_Sorted_Lists {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode d = new ListNode(0), c = d;
        while (a != null && b != null) {
            if (a.val <= b.val) { c.next = a; a = a.next; }
            else { c.next = b; b = b.next; }
            c = c.next;
        }
        c.next = (a != null) ? a : b;
        return d.next;
    }

    static ListNode build(int[] a) {
        ListNode d = new ListNode(0), c = d;
        for (int x : a) { c.next = new ListNode(x); c = c.next; }
        return d.next;
    }

    static void print(ListNode h) {
        while (h != null) { System.out.print(h.val + (h.next == null ? "\n" : " ")); h = h.next; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n], b = new int[m];
        for (int i=0;i<n;i++) a[i]=sc.nextInt();
        for (int i=0;i<m;i++) b[i]=sc.nextInt();
        print(mergeTwoLists(build(a), build(b)));
        sc.close();
    }
}
// Input:
// 3 3
// 1 2 4
// 1 3 4
// Output:
// 1 1 2 3 4 4
