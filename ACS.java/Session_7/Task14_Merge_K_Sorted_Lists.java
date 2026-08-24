import java.util.*;

public class Task14_Merge_K_Sorted_Lists {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode h : lists) if (h != null) pq.offer(h);
        ListNode d = new ListNode(0), cur = d;
        while (!pq.isEmpty()) {
            ListNode x = pq.poll();
            cur.next = x; cur = x;
            if (x.next != null) pq.offer(x.next);
        }
        return d.next;
    }

    static ListNode build(int[] a) {
        ListNode d = new ListNode(0), c=d;
        for(int x:a){c.next=new ListNode(x);c=c.next;}
        return d.next;
    }

    static void print(ListNode h) {
        while(h!=null){System.out.print(h.val+(h.next==null?"\n":" "));h=h.next;}
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        ListNode[] lists=new ListNode[k];
        for(int i=0;i<k;i++){
            int n=sc.nextInt(); int[] a=new int[n];
            for(int j=0;j<n;j++)a[j]=sc.nextInt();
            lists[i]=build(a);
        }
        print(mergeKLists(lists));
        sc.close();
    }
}
// Input:
// 3
// 3 1 4 5
// 3 1 3 4
// 2 2 6
// Output:
// 1 1 2 3 4 4 5 6
