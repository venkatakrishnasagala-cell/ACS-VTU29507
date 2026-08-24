import java.util.*;

public class Task17_Linked_List_Cycle_II {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v){val=v;}
    }

    static ListNode detectCycle(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;fast=fast.next.next;
            if(slow==fast){
                ListNode p=head;
                while(p!=slow){p=p.next;slow=slow.next;}
                return p;
            }
        }
        return null;
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), pos=sc.nextInt();
        if(n==0){System.out.println("-1");sc.close();return;}
        ListNode[] nodes=new ListNode[n];
        for(int i=0;i<n;i++)nodes[i]=new ListNode(sc.nextInt());
        for(int i=0;i<n-1;i++)nodes[i].next=nodes[i+1];
        if(pos>=0&&pos<n)nodes[n-1].next=nodes[pos];
        ListNode ans=detectCycle(nodes[0]);
        System.out.println(ans==null ? -1 : ans.val);
        sc.close();
    }
}
// Input:
// 4 1
// 3 2 0 -4
// Output:
// 2
// pos is the zero-based index where the tail connects.
