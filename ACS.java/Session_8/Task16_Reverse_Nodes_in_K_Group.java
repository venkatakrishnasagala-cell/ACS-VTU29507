import java.util.*;

public class Task16_Reverse_Nodes_in_K_Group {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v){val=v;}
    }

    static ListNode reverseKGroup(ListNode head,int k){
        if(k<=1||head==null)return head;
        ListNode dummy=new ListNode(0);dummy.next=head;
        ListNode groupPrev=dummy;
        while(true){
            ListNode kth=groupPrev;
            for(int i=0;i<k&&kth!=null;i++)kth=kth.next;
            if(kth==null)break;
            ListNode groupNext=kth.next;
            ListNode prev=groupNext,cur=groupPrev.next;
            while(cur!=groupNext){
                ListNode next=cur.next;cur.next=prev;prev=cur;cur=next;
            }
            ListNode oldHead=groupPrev.next;
            groupPrev.next=kth;
            groupPrev=oldHead;
        }
        return dummy.next;
    }

    static ListNode build(int[]a){
        ListNode d=new ListNode(0),c=d;
        for(int x:a){c.next=new ListNode(x);c=c.next;}
        return d.next;
    }

    static void print(ListNode h){
        while(h!=null){System.out.print(h.val+(h.next==null?"\n":" "));h=h.next;}
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);int n=sc.nextInt(),k=sc.nextInt();int[]a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        print(reverseKGroup(build(a),k));sc.close();
    }
}
// Input:
// 5 2
// 1 2 3 4 5
// Output:
// 2 1 4 3 5
