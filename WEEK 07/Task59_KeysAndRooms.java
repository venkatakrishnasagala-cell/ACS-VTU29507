import java.util.*;

public class Task59_KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    count++;
                    queue.offer(key);
                }
            }
        }
        return count == rooms.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            List<Integer> keys = new ArrayList<>();
            for (int j = 0; j < k; j++) keys.add(sc.nextInt());
            rooms.add(keys);
        }
        System.out.println(canVisitAllRooms(rooms));
        sc.close();
    }
}
