import java.util.*;

public class Task50_KthSmallestElementBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.val) root.left = insert(root.left, value);
        else if (value > root.val) root.right = insert(root.right, value);
        return root;
    }

    static int count = 0;
    static Integer answer = null;

    static void inorder(TreeNode root, int k) {
        if (root == null || answer != null) return;
        inorder(root.left, k);
        if (answer != null) return;
        count++;
        if (count == k) {
            answer = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;

        for (int i = 0; i < n; i++) root = insert(root, sc.nextInt());

        int k = sc.nextInt();
        if (k <= 0 || k > n) {
            System.out.println("Invalid k");
        } else {
            inorder(root, k);
            System.out.println(answer);
        }
        sc.close();
    }
}
