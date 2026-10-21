import java.util.*;

public class Task49_LowestCommonAncestorBST {
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

    static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        while (root != null) {
            if (p < root.val && q < root.val) root = root.left;
            else if (p > root.val && q > root.val) root = root.right;
            else return root;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;

        for (int i = 0; i < n; i++) root = insert(root, sc.nextInt());

        int p = sc.nextInt();
        int q = sc.nextInt();
        TreeNode answer = lowestCommonAncestor(root, p, q);
        System.out.println(answer == null ? "Not found" : answer.val);
        sc.close();
    }
}
