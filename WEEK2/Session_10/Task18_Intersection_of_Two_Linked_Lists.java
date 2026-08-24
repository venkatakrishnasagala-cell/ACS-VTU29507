import java.util.*;

public class Task18_Intersection_of_Two_Linked_Lists {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v){val=v;}
    }

    static ListNode getIntersectionNode(ListNode a,ListNode b){
        if(a==null||b==null)return null;
        ListNode p=a,q=b;
        while(p!=q){
            p=(p==null)?b:p.next;
            q=(q==null)?a:q.next;
        }
        return p;
    }

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),skipA=sc.nextInt(),skipB=sc.nextInt();
        ListNode[] a=new ListNode[n],b=new ListNode[m];
        for(int i=0;i<n;i++)a[i]=new ListNode(sc.nextInt());
        for(int i=0;i<m;i++)b[i]=new ListNode(sc.nextInt());
        for(int i=0;i<n-1;i++)a[i].next=a[i+1];
        for(int i=0;i<m-1;i++)b[i].next=b[i+1];

        // For local testing, if skipA/skipB point to the same value index,
        // connect B to A's node to create a shared tail.
        if(skipA>=0&&skipA<n&&skipB>=0&&skipB<m){
            b[skipB].next=a[skipA];
        }

        ListNode ans=getIntersectionNode(a[0],b[0]);
        System.out.println(ans==null ? -1 : ans.val);
        sc.close();
    }
}
// Input:
// 5 2 2 1
// 4 1 8 4 5
// 5 6
// Output:
// 8
