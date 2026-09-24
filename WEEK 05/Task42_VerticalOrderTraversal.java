import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, List<int[]>> map = new TreeMap<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        Queue<Integer> rows = new LinkedList<>();

        nodes.offer(root);
        columns.offer(0);
        rows.offer(0);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.poll();
            int column = columns.poll();
            int row = rows.poll();

            map.putIfAbsent(column, new ArrayList<>());
            map.get(column).add(new int[]{row, current.val});

            if (current.left != null) {
                nodes.offer(current.left);
                columns.offer(column - 1);
                rows.offer(row + 1);
            }

            if (current.right != null) {
                nodes.offer(current.right);
                columns.offer(column + 1);
                rows.offer(row + 1);
            }
        }

        for (List<int[]> values : map.values()) {
            values.sort((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            });

            List<Integer> columnValues = new ArrayList<>();

            for (int[] value : values) {
                columnValues.add(value[1]);
            }

            result.add(columnValues);
        }

        return result;
    }
}
