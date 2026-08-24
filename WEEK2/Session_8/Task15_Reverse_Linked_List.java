import java.util.*;

public class Task15_Reverse_Linked_List {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v){val=v;}
    }

    static ListNode reverseList(ListNode head){
        ListNode prev=null,cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
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
        Scanner sc=new Scanner(System.in);int n=sc.nextInt();int[]a=new int[n];
        for(int i=0;i<n;i++)a[i]=sc.nextInt();
        print(reverseList(build(a)));sc.close();
    }
}
// Input:
// 5
// 1 2 3 4 5
// Output:
// 5 4 3 2 1
